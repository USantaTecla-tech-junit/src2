package usantatecla.blackBox.equivalenceClasses.sqrt;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MathTest {

	private static final double PRECISION = 0.00000001;
	
	@Test
	public void testSqrt() {
		assertThat(Math.sqrt(Double.NaN), is(Double.NaN));
		assertThat(Math.sqrt(-34), is(Double.NaN));
		assertThat(Math.sqrt(-0), is(0.0));
		assertThat(Math.sqrt(0), is(0.0));
		assertThat(Math.sqrt(111.11), is(closeTo(10.54087282, PRECISION)));
		assertThat(Math.sqrt(Double.POSITIVE_INFINITY), is(Double.POSITIVE_INFINITY));
	}
	
}
