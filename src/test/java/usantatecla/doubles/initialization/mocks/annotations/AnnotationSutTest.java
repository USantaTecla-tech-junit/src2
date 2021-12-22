package usantatecla.doubles.initialization.mocks.annotations;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AnnotationSutTest {

    @InjectMocks
    private SUT sut;
    @Mock
    private DOC doc;

    @Before
    public void before(){
        initMocks(this);
    }

    @Test
    public void testGivenSUTWhenExerciseThenResult(){
        when(this.doc.exerciseDOC(true)).thenReturn(-1);
        assertThat(this.sut.exerciseSUT(true), is(-1));
        verify(this.doc).exerciseDOC(true);
    }

}
