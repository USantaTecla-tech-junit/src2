package usantatecla.doubles.configuration;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import org.mockito.stubbing.Answer;
import org.mockito.invocation.InvocationOnMock;

public class SutTest {

  private SUT sut;
  private DOC doc;

  @Before
  public void before() {
    initMocks(this);
    this.doc = mock(DOC.class);
    this.sut = new SUT(this.doc);
  }

  @Test
  public void testSameThenReturn() {
    when(this.doc.returnMethod()).thenReturn(0);
    this.sut.voidMethod();
    assertThat(this.sut.returnMethod(), is(1));
    this.sut.voidMethod();
    assertThat(this.sut.returnMethod(), is(2));
    assertThat(this.sut.returnMethod(), is(2));
  }

  @Test
  public void testSameDoReturn() {
    doReturn(0).when(this.doc).returnMethod();
    this.sut.voidMethod();
    assertThat(this.sut.returnMethod(), is(1));
    this.sut.voidMethod();
    assertThat(this.sut.returnMethod(), is(2));
    assertThat(this.sut.returnMethod(), is(2));
  }

  @Test
  public void testSeveralThenReturn() {
    when(this.doc.returnMethod()).thenReturn(0, 1);
    this.sut.voidMethod();
    assertThat(this.sut.returnMethod(), is(1));
    this.sut.voidMethod();
    assertThat(this.sut.returnMethod(), is(3));
    assertThat(this.sut.returnMethod(), is(3));
  }

  @Test
  public void testSeveralDoReturn() {
    doReturn(0, 1).when(this.doc).returnMethod();
    this.sut.voidMethod();
    assertThat(this.sut.returnMethod(), is(1));
    this.sut.voidMethod();
    assertThat(this.sut.returnMethod(), is(3));
    assertThat(this.sut.returnMethod(), is(3));
  }

  @Test
  public void testWithDisjointValuesThenReturn() {
    when(this.doc.returnMethodWithParemeters(0)).thenReturn(0);
    when(this.doc.returnMethodWithParemeters(1)).thenReturn(1);
    when(this.doc.returnMethodWithParemeters(2)).thenReturn(2);
    this.sut.voidMethod();
    assertThat(this.sut.returnMethodWithParemeters(0), is(1));
    this.sut.voidMethod();
    assertThat(this.sut.returnMethodWithParemeters(1), is(4));
    assertThat(this.sut.returnMethodWithParemeters(2), is(6));
  }

  @Test
  public void testWithDisjointValuesDoReturn() {
    doReturn(0).when(this.doc).returnMethodWithParemeters(0);
    doReturn(1).when(this.doc).returnMethodWithParemeters(1);
    doReturn(2).when(this.doc).returnMethodWithParemeters(2);
    this.sut.voidMethod();
    assertThat(this.sut.returnMethodWithParemeters(0), is(1));
    this.sut.voidMethod();
    assertThat(this.sut.returnMethodWithParemeters(1), is(4));
    assertThat(this.sut.returnMethodWithParemeters(2), is(6));
  }

  @Test
  public void testWithSametMatchers() {
    when(this.doc.returnMethodWithParemeters(anyInt())).thenReturn(0);
    this.sut.voidMethod();
    assertThat(this.sut.returnMethodWithParemeters(0), is(1));
    this.sut.voidMethod();
    assertThat(this.sut.returnMethodWithParemeters(1), is(3));
    assertThat(this.sut.returnMethodWithParemeters(2), is(4));
  }

  @Test
  public void testWithMixedValuestMatchers() {
    when(this.doc.returnMethodWithParemeters(2)).thenReturn(-100); // of no effect
    when(this.doc.returnMethodWithParemeters(anyInt())).thenReturn(3);
    when(this.doc.returnMethodWithParemeters(0)).thenReturn(0);
    this.sut.voidMethod();
    assertThat(this.sut.returnMethodWithParemeters(0), is(1));
    this.sut.voidMethod();
    assertThat(this.sut.returnMethodWithParemeters(1), is(6));
    assertThat(this.sut.returnMethodWithParemeters(2), is(7));
  }

  @Test
  public void testWithArgumentMatcher() {
    doNothing().when(this.doc).voidMethodWithParemeters(anyInt(), argThat(new isValidOther()));
    this.sut.voidMethodWithParemeters(1, new Other(-1));
    this.sut.voidMethodWithParemeters(1, new Other(0));
    this.sut.voidMethodWithParemeters(1, new Other(3));
    assertThat(this.sut.returnMethod(), is(3));
  }

  @Test
  public void testVoid() {
    doNothing().when(this.doc).voidMethod();
    doNothing().when(this.doc).voidMethodWithParemeters(1, new Other(0));
    this.sut.voidMethod();
    this.sut.voidMethodWithParemeters(1, new Other(0));
    assertThat(this.sut.returnMethod(), is(2));
  }

  @Test
  public void testWithDoAnswer() {
    doAnswer(new Answer() {
      public Object answer(InvocationOnMock invocation) {
        Object[] args = invocation.getArguments();
        int value = (Integer) args[0];
        return value + 5;
      }
    }).when(this.doc).returnMethodWithParemeters(5);
    assertThat(this.sut.returnMethodWithParemeters(5), is(15));
  }

  @Test
  public void testWithThenAnswer() {
    when(this.doc.returnMethodWithParemeters(5)).thenAnswer(new Answer() {
      public Object answer(InvocationOnMock invocation) {
        Object[] args = invocation.getArguments();
        int value = (Integer) args[0];
        return value + 5;
      }
    });
    assertThat(this.sut.returnMethodWithParemeters(5), is(15));
  }

  @Test(expected = Error.class)
  public void testWithExceptions() throws Exception {
    doThrow(new Error("test")).when(this.doc).voidMethodWithExcpetion();
    this.sut.voidMethodWithExcpetion();
  }

  @Test(expected = Error.class)
  public void testWithReturnsAndExceptions() throws Exception {
    when(this.doc.returnMethodWithExcpetion()).thenReturn(0).thenThrow(new Error("test"));
    this.sut.returnMethodWithExcpetion();
    this.sut.returnMethodWithExcpetion();
  }

  @Test
  public void testWithExceptionsAndReturns() throws Exception {
    when(this.doc.returnMethodWithExcpetion()).thenThrow(new Error("test")).thenReturn(0);
    try {
      this.sut.returnMethodWithExcpetion();
    } catch (Error ex) {
      assertThat(ex.getMessage(), is("test"));
    }
    assertThat(this.sut.returnMethodWithExcpetion(), is(0));
  }

}
