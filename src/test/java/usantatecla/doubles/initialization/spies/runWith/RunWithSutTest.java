package usantatecla.doubles.initialization.spies.runWith;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class RunWithSutTest {

    public SUT sut;
    public DOC doc;

    @Before
    public void before(){
        this.doc = spy(new DOC());
        this.sut = new SUT(doc);
    }

    @Test
    public void testGivenSUTWhenExerciseThenResult(){
        assertThat(this.sut.exerciseSUT(true), is(0));
        verify(this.doc).exerciseDOC(true);
    }

}
