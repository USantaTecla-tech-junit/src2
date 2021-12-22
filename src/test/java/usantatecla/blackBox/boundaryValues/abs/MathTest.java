package usantatecla.blackBox.boundaryValues.abs;

import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class MathTest {

	private static final double PRECISION = 0.00000001;
	
	@Test
	public void testAbs() {
		assertThat(Math.abs(Double.MIN_VALUE), is(closeTo(-(Double.MIN_VALUE+1), PRECISION)));
		assertThat(Math.abs(-0.01), is(closeTo(0.01, PRECISION)));
		assertThat(Math.abs(0.00), is(closeTo(0.00, PRECISION)));
		assertThat(Math.abs(Double.MAX_VALUE), is(closeTo(Double.MAX_VALUE, PRECISION)));
	}

}
