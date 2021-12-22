package usantatecla.testCaseDesign;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;

public class AlternativeTest {

	private static final double PRECISION = 0.00000001;
	
	private double in = 111.11;
	
	@Test
	public void testCheckInverseRelationship() {
		double sqrt = Math.sqrt(in);
		assertThat(sqrt*sqrt, closeTo(in, PRECISION));
	}
	
	@Test
	public void testCrossCheck() {
		assertThat(Math.sqrt(in), closeTo(java.lang.Math.sqrt(in), PRECISION));
	}

}
