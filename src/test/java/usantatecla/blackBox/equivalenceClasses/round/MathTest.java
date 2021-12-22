package usantatecla.blackBox.equivalenceClasses.round;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MathTest {

	@Test
	public void testRound() {
		assertThat(Math.round(-3.33), is((long)-3));
		assertThat(Math.round(-0.999), is((long)-1));
		assertThat(Math.round(37.73), is((long)38));		
	}

}

