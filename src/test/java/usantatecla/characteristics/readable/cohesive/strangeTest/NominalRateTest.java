package usantatecla.characteristics.readable.cohesive.strangeTest;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class NominalRateTest {

	@Test(expected = AssertionError.class)
	public void testGetNominalRateWithNegativeRateError() {
		NominalRate.getNominalRate(-1.1);
	}
	
	@Test(expected = AssertionError.class)
	public void testGetNominalRateWithExcessiveRateError() {
		NominalRate.getNominalRate(10.1);
	}
	
	@Test
	public void testGetNominalRate() {
		assertThat(NominalRate.getNominalRate(9.7), is(NominalRate.A));
		assertThat(NominalRate.getNominalRate(7.7), is(NominalRate.B));
		assertThat(NominalRate.getNominalRate(5.7), is(NominalRate.C));
		assertThat(NominalRate.getNominalRate(3.7), is(NominalRate.D));
		assertThat(NominalRate.getNominalRate(1.7), is(NominalRate.E));
	}

}
