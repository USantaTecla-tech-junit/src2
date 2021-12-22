package usantatecla.qualifications.v1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class RateTest {
	static final double EPSILON = 0.001;

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithNegativeMinimum_thenAssertionError() {
		new Rate(Rate.MAXIMUM_VALUE, -RateTest.EPSILON);
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithExcesiveMinimum_thenAssertionError() {
		new Rate(Rate.MAXIMUM_VALUE, Rate.MAXIMUM_VALUE + RateTest.EPSILON);
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithNegativePercent_thenAssertionError() {
		new Rate(-RateTest.EPSILON);
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithExcesivePercent_thenAssertionError() {
		new Rate(Rate.MAXIMUM_PERCENT + RateTest.EPSILON);
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithNegativeValue_thenAssertionError() {
		Rate rate = new Rate();
		rate.setValue(-RateTest.EPSILON);
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithExcesiveValue_thenAssertionError() {
		Rate rate = new Rate();
		rate.setValue(Rate.MAXIMUM_VALUE + RateTest.EPSILON);
	}

	@Test
	public void givenRateWithValueGreaterThanMinimun_whenIsQualifiable_thenTrue() {
		final int minimum = 0;
		Rate rate = new Rate(Rate.MAXIMUM_PERCENT, minimum);
		rate.setValue(minimum);
		assertThat(rate.isQualifiable(), is(true));
	}

	@Test
	public void givenRateWithValueLessThanMinimun_whenIsQualifiable_thenFalse() {
		final int minimum = 10;
		Rate rate = new Rate(Rate.MAXIMUM_PERCENT, minimum);
		rate.setValue(minimum - RateTest.EPSILON);
		assertThat(rate.isQualifiable(), is(false));
	}

	@Test(expected = AssertionError.class)
	public void givenRateNotIsQualifiable_whenGetResult_thenAssertionError() {
		final int minimum = 10;
		Rate rate = new Rate(Rate.MAXIMUM_PERCENT, minimum);
		rate.setValue(minimum - RateTest.EPSILON);
		rate.getResult();
	}

	@Test
	public void givenRateIsQualifiableOnTop_whenGetResult_thenOk() {
		final double value = Rate.MAXIMUM_VALUE;
		Rate rate = new Rate(Rate.MAXIMUM_PERCENT);
		rate.setValue(value);
		assertThat(rate.getResult(), is(value));
	}

	@Test
	public void givenRateIsQualifiableOnMiddle_whenGetResult_thenOk() {
		final double value = Rate.MAXIMUM_VALUE / 2;
		final double percent = Rate.MAXIMUM_PERCENT / 2;
		Rate rate = new Rate(percent);
		rate.setValue(value);
		assertThat(rate.getResult(), is(value * percent));
	}

	@Test
	public void givenRateIsQualifiableOnBottom_whenGetResult_thenOk() {
		final double result = 0.0;
		Rate rate = new Rate(0.0);
		rate.setValue(result);
		assertThat(rate.getResult(), is(result));
	}

}
