package usantatecla.blackBox.boundaryValues.sqrt;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MathTest {

	private static final double PRECISION = 0.1;
	
	@Test
	public void testSqrt() {
		assertThat(Math.sqrt(Double.NaN), is(Double.NaN));
		assertThat(Math.sqrt(Double.NEGATIVE_INFINITY), is(Double.NaN));
		assertThat(Math.sqrt(-0.0001), is(Double.NaN));
		assertThat(Math.sqrt(-0), is(0.0));
		assertThat(Math.sqrt(0), is(0.0));
		assertThat(Math.sqrt(0.01), is(closeTo(0.00001, PRECISION)));
		assertThat(Math.sqrt(Double.MAX_VALUE), is(1.3407807929942596E154));
		assertThat(Math.sqrt(Double.POSITIVE_INFINITY), is(Double.POSITIVE_INFINITY));
	}
	
}
