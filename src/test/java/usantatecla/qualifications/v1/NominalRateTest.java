package usantatecla.qualifications.v1;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class NominalRateTest {
	private static final double PRECISSION = 0.001;

	@Test(expected = AssertionError.class)
	public void givenExcesiveValue_whenGetNominalRate_thenAssertionError() {
		NominalRate.getNominalRate(Rate.MAXIMUM_VALUE + NominalRateTest.PRECISSION);
	}

	@Test
	public void givenMaximumValue_whenGetNominalRate_thenOk() {
		assertThat(
			NominalRate.getNominalRate(Rate.MAXIMUM_VALUE)
		, is(NominalRate.A));
	}

	@Test
	public void givenMinimumValue_whenGetNominalRate_thenOk() {
		NominalRate[] nominalRates = NominalRate.values();
		for (int i = 0; i < nominalRates.length; i++) {
			assertThat(
				NominalRate.getNominalRate(nominalRates[i].getMinimum())
			, is(nominalRates[i]));
		}
	}

	@Test
	public void givenLessThanMinimumValue_whenGetNominalRate_thenOk() {
		NominalRate[] nominalRates = NominalRate.values();
		for (int i = 0; i < nominalRates.length - 1; i++) {
			assertThat(
				NominalRate.getNominalRate(nominalRates[i].getMinimum() - NominalRateTest.PRECISSION)
			,	is(nominalRates[i + 1]));
		}
	}

	@Test(expected = AssertionError.class)
	public void givenDefectValue_whenGetNominalRate_thenAssertionError() {
		NominalRate.getNominalRate(-NominalRateTest.PRECISSION);
	}

}
