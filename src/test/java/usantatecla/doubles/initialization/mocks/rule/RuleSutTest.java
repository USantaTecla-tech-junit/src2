package usantatecla.doubles.initialization.mocks.rule;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import org.mockito.junit.MockitoRule;
import org.mockito.junit.MockitoJUnit;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RuleSutTest {
    
    @Rule
    public MockitoRule initRule = MockitoJUnit.rule();

    private SUT sut;
    private DOC doc;

    @Before
    public void before(){
        this.doc = mock(DOC.class);
        this.sut = new SUT(doc);
    }

    @Test
    public void testGivenSUTWhenExerciseThenResult(){
        when(this.doc.exerciseDOC(true)).thenReturn(-1);
        assertThat(this.sut.exerciseSUT(true), is(-1));
        verify(this.doc).exerciseDOC(true);
    }

}
