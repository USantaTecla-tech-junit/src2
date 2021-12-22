package usantatecla.blackBox.boundaryValues.round;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MathTest {

	@Test
	public void testRound() {
		assertThat(Math.round(-3.00), is(-3L));
		assertThat(Math.round(73.499), is(73L));
		assertThat(Math.round(-0.50), is(-1L));
		assertThat(Math.round(-33.99), is(-34L));
		assertThat(Math.round(37.50), is(38L));
		assertThat(Math.round(110.99), is(111L));
	}

}

