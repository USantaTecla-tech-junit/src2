package usantatecla.doubles.initialization.mocks.runWith;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.Mockito.mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class RunWithSutTest {

    private SUT sut;
    private DOC doc;

    @Before
    public void before(){
        this.doc = mock(DOC.class);
        this.sut = new SUT(this.doc);
    }

    @Test
    public void testGivenSUTWhenExerciseThenResult(){
        when(this.doc.exerciseDOC(true)).thenReturn(-1);
        assertThat(this.sut.exerciseSUT(true), is(-1));
        verify(this.doc).exerciseDOC(true);
    }

}
