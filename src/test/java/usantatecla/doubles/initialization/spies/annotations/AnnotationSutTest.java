package usantatecla.doubles.initialization.spies.annotations;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.verify;

public class AnnotationSutTest {

    @InjectMocks
    private SUT sut;
    @Spy
    private DOC doc;

    @Before
    public void before(){
        initMocks(this);
    }

    @Test
    public void testGivenSUTWhenExerciseThenResult(){
        assertThat(sut.exerciseSUT(true), is(0));
        verify(doc).exerciseDOC(true);
    }

}
