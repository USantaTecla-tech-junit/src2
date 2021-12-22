package usantatecla.qualifications.v3;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import usantatecla.qualifications.v3.builders.RateBuilder;

public class RateTest {
	static final double EPSILON = 0.001;

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithNegativeMinimum_thenAssertionError() {
		new RateBuilder()
			.minimum(-RateTest.EPSILON)
			.build();
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithExcesiveMinimum_thenAssertionError() {
		new RateBuilder()
			.minimum(Rate.MAXIMUM_VALUE + RateTest.EPSILON)
			.build();
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithNegativePercent_thenAssertionError() {
		new RateBuilder()
			.percent(-RateTest.EPSILON)
			.build();
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithExcesivePercent_thenAssertionError() {
		new RateBuilder()
			.percent(Rate.MAXIMUM_PERCENT + RateTest.EPSILON)
			.build();
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithNegativeValue_thenAssertionError() {
		new RateBuilder()
			.value(-RateTest.EPSILON)
			.build();
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithExcesiveValue_thenAssertionError() {
		new RateBuilder()
			.value(Rate.MAXIMUM_VALUE + RateTest.EPSILON)
			.build();
	}

	@Test
	public void givenRateWithValueGreaterThanMinimun_whenIsQualifiable_thenTrue() {
		final int minimum = 0;
		assertThat(
			new RateBuilder()
				.minimum(minimum)
				.value(minimum)
				.build()
					.isQualifiable()
			, is(true));
	}

	@Test
	public void givenRateWithValueLessThanMinimun_whenIsQualifiable_thenFalse() {
		final int minimum = 10;
		assertThat(
			new RateBuilder()
				.minimum(minimum)
				.value(minimum - RateTest.EPSILON)
				.build()
					.isQualifiable()
			, is(false));
	}

	@Test(expected = AssertionError.class)
	public void givenRateNotIsQualifiable_whenGetResult_thenAssertionError() {
		final int minimum = 10;
		new RateBuilder()
			.minimum(minimum)
			.value(minimum - RateTest.EPSILON)
			.build()
				.getResult();
	}

	@Test
	public void givenRateIsQualifiableOnTop_whenGetResult_thenOk() {
		final double value = Rate.MAXIMUM_VALUE;
		assertThat(
			new RateBuilder()
				.percent(Rate.MAXIMUM_PERCENT)
				.value(value)
				.build()
					.getResult()
			, is(value));
	}

	@Test
	public void givenRateIsQualifiableOnMiddle_whenGetResult_thenOk() {
		final double value = Rate.MAXIMUM_VALUE / 2;
		final double percent = Rate.MAXIMUM_PERCENT / 2;
		assertThat(
			new RateBuilder()
				.percent(percent)
				.value(value)
				.build()
					.getResult()
			, is(value * percent));
	}

	@Test
	public void givenRateIsQualifiableOnBottom_whenGetResult_thenOk() {
		final double result = 0.0;
		assertThat(
			new RateBuilder()
				.percent(0.0)
				.value(result)
				.build()
					.getResult()
			, is(result));
	}

}
