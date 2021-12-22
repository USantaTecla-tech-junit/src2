package usantatecla.doubles.initialization.mocks.init;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class InitSutTest {

    private SUT sut;
    private DOC doc;

    @Before
    public void before(){
        initMocks(this);
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
