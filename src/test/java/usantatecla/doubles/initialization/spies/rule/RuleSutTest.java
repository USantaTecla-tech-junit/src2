package usantatecla.doubles.initialization.spies.rule;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import org.mockito.junit.MockitoRule;
import org.mockito.junit.MockitoJUnit;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;

public class RuleSutTest {

    @Rule
    public MockitoRule initRule = MockitoJUnit.rule();

    private SUT sut;
    private DOC doc;

    @Before
    public void before() {
        this.doc = spy(new DOC());
        this.sut = new SUT(this.doc);
    }

    @Test
    public void testGivenSUTWhenExerciseThenResult() {
        assertThat(this.sut.exerciseSUT(true), is(0));
        verify(this.doc).exerciseDOC(true);
    }

}
