package usantatecla.doubles.initialization.spies.init;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.spy;

public class InitSutTest {

    private SUT sut;
    private DOC doc;

    @Before
    public void before(){
        initMocks(this);
        this.doc = spy(new DOC());
        this.sut = new SUT(doc);
    }

    @Test
    public void testGivenSUTWhenExerciseThenResult(){
        assertThat(this.sut.exerciseSUT(true), is(0));
        verify(this.doc).exerciseDOC(true);
    }

}
