package usantatecla.blackBox.equivalenceClasses.abs;

import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class MathTest {

	private static final double PRECISION = 0.00000001;
	
	@Test
	public void testAbs() {
		assertThat(Math2.abs(-0.99), is(closeTo(0.99, PRECISION)));
		assertThat(Math2.abs(37.43), is(closeTo(37.43, PRECISION)));
	}

}
