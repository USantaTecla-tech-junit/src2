package usantatecla.doubles.verification;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import static org.mockito.hamcrest.MockitoHamcrest.intThat;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.MockitoAnnotations.initMocks;

import static org.hamcrest.Matchers.greaterThan;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

public class SutTest {

  private SUT sut;
  private DOC doc;

  @Before
  public void before() {
    initMocks(this);
    this.doc = spy(new DOC());
    this.sut = new SUT(this.doc);
  }

  @Test
  public void test() {
    this.sut.voidMethod();
    verify(this.doc).voidMethod();
  }

  @Test
  public void testWithSomeVerifications() {
    this.sut.voidMethodWithParemeters(1, new Other(0));
    this.sut.voidMethod();
    verify(this.doc).voidMethod();
  }

  @Test
  public void testWithDifferentVerifications() {
    this.sut.voidMethodWithParemeters(1, new Other(0));
    this.sut.voidMethod();
    verify(this.doc).voidMethod();
    verify(this.doc).voidMethodWithParemeters(1, new Other(0));
  }

  @Test
  public void testWithSameVerifications() {
    this.sut.voidMethodWithParemeters(1, new Other(0));
    this.sut.voidMethod();
    this.sut.voidMethodWithParemeters(0, null);
    this.sut.voidMethod();
    verify(this.doc).voidMethodWithParemeters(0, null);
    verify(this.doc, times(2)).voidMethod();
    verify(this.doc).voidMethodWithParemeters(1, new Other(0));
  }

  @Test
  public void testWithTimes() {
    this.sut.voidMethod();
    verify(this.doc, times(1)).voidMethod(); // default
    verify(this.doc, atLeastOnce()).voidMethod();
    verify(this.doc, atLeast(1)).voidMethod();
    verify(this.doc, atMost(1)).voidMethod();
    verify(this.doc, never()).voidMethodWithParemeters(0, null);
  }

  @Test
  public void testWithVerifyZeroInteractions() {
    // this.sut.voidMethod();
    verifyZeroInteractions(this.doc);
  }

  @Test
  public void testWithverifyNoMoreInteractions() {
    // this.sut.voidMethod();
    this.sut.voidMethod();
    verify(this.doc).voidMethod();
    verifyNoMoreInteractions(this.doc);
  }

  @Test
  public void testWithMatchers() {
    this.sut.voidMethodWithParemeters(0, null);
    this.sut.voidMethodWithParemeters(1, new Other(0));
    verify(this.doc).voidMethodWithParemeters(1, new Other(0));
    // all matchers
    verify(this.doc).voidMethodWithParemeters(anyInt(), eq(new Other(0)));
    verify(this.doc).voidMethodWithParemeters(anyInt(), isA(Other.class));
    verify(this.doc).voidMethodWithParemeters(anyInt(), (Other) isNull());
    verify(this.doc).voidMethodWithParemeters(eq(0), (Other) isNull());
    verify(this.doc).voidMethodWithParemeters(intThat(greaterThan(-1)), (Other) isNull());
  }

  @Test
  public void testWithArgumentMatcher(){
    this.sut.voidMethodWithParemeters(0, new Other(1));
    verify(this.doc).voidMethodWithParemeters(anyInt(), argThat(new isValidOther()));
  }

  @Test
  public void testWithCapture() {
    ArgumentCaptor<Integer> value = ArgumentCaptor.forClass(Integer.class);
    ArgumentCaptor<Other> other = ArgumentCaptor.forClass(Other.class);
    this.sut.voidMethod();
    this.sut.voidMethodWithParemeters(1, new Other(-1));
    verify(this.doc).voidMethod();
    verify(this.doc).voidMethodWithParemeters(value.capture(), other.capture());
    assertThat(value.getValue(), is(1));
    assertThat(other.getValue().attribute, is(-1));
  }

  @Test
  public void testWithOrder() {
    Other other = new Other(0);
    this.sut.voidMethodWithParemeters(1, other);
    this.sut.voidMethodWithParemeters(2, other);
    this.sut.voidMethodWithParemeters(3, other);
    InOrder inOrder = inOrder(this.doc);
    inOrder.verify(this.doc).voidMethodWithParemeters(1, other);
    inOrder.verify(this.doc).voidMethodWithParemeters(2, other);
    inOrder.verify(this.doc).voidMethodWithParemeters(3, other);
  }

  @Test
  public void testWithOrderMultiple() {
    Other other = new Other(0);
    DOC doc = spy(new DOC());
    SUT sut = new SUT(doc);
    this.sut.voidMethodWithParemeters(1, other);
    sut.voidMethodWithParemeters(1, other);
    this.sut.voidMethodWithParemeters(2, other);
    sut.voidMethodWithParemeters(2, other);
    InOrder inOrder = inOrder(this.doc, doc);
    inOrder.verify(this.doc).voidMethodWithParemeters(1, other);
    inOrder.verify(doc).voidMethodWithParemeters(1, other);
    inOrder.verify(this.doc).voidMethodWithParemeters(2, other);
    inOrder.verify(doc).voidMethodWithParemeters(2, other);
  }

  @Test
  public void testWithDescription() {
    this.sut.voidMethod();
    verify(this.doc, times(1).description("Mensaje")).voidMethod();
    verify(this.doc, atLeastOnce().description("Mensaje")).voidMethod();
    verify(this.doc, atLeast(1).description("Mensaje")).voidMethod();
    verify(this.doc, atMost(1).description("Mensaje")).voidMethod();
    verify(this.doc, never().description("Mensaje")).voidMethodWithParemeters(0, null);
  }

  @Test
  public void testWithTimeOut() {
    this.sut.slowMethod();
    verify(this.doc, timeout(1)).slowMethod();
  }

}
