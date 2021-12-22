package usantatecla.qualifications.v2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import usantatecla.qualifications.v2.builders.SingleExamBuilder;

import org.junit.Test;

public class SingleExamTest extends ExamTest {

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithNegativeValue_thenAssertionError() {
		new SingleExamBuilder().value(-ExamTest.EPSILON).build();
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithExcesiveValue_thenAssertionError() {
		new SingleExamBuilder().value(Rate.MAXIMUM_VALUE + ExamTest.EPSILON).build();
	}

	@Test
	public void givenRateWithValueGreaterOrEqualsThanMinimun_whenIsQualifiable_thenTrue() {
		final double minimum = 0;
		assertThat(
			new SingleExamBuilder().value(minimum).minimum(minimum).build().isQualifiable()
		, is(true));
	}

	@Test
	public void givenRateWithValueLessThanMinimun_whenIsQualifiable_thenFalse() {
		final double minimum = Rate.MAXIMUM_VALUE;
		assertThat(
			new SingleExamBuilder().value(minimum - ExamTest.EPSILON).minimum(minimum).build().isQualifiable()
		, is(false));
	}

	@Test(expected = AssertionError.class)
	public void givenRateNotIsQualifiable_whenGetResult_thenAssertionError() {
		final double minimum = Rate.MAXIMUM_VALUE;
		new SingleExamBuilder().value(minimum - ExamTest.EPSILON).minimum(minimum).build().getResult();
	}

	@Test
	public void givenRateIsQualifiableOnTop_whenGetResult_thenOk() {
		final double value = Rate.MAXIMUM_VALUE;
		assertThat(
			new SingleExamBuilder().value(value).percent(Rate.MAXIMUM_PERCENT).build().getResult()
		, is(value));
	}

	@Test
	public void givenRateIsQualifiableOnMiddle_whenGetResult_thenOk() {
		final double value = Rate.MAXIMUM_VALUE / 2;
		final double percent = Rate.MAXIMUM_PERCENT / 2;
		assertThat(
			new SingleExamBuilder().value(value).percent(percent).build().getResult()
		, is(value * percent));
	}

	@Test
	public void givenRateIsQualifiableOnBottom_whenGetResult_thenOk() {
		final double value = 0.0;
		assertThat(
			new SingleExamBuilder().value(value).percent(value).build().getResult()
		, is(value));
	}

	@Test
	public void givenExamWithValueTo10_whenSetValue0_thenNotIsQualified() {
		Exam exam = new SingleExamBuilder().minimum(1).build();
		exam.setValue(0);
		assertThat(
			exam.isQualifiable()
		, is(false));
	}

	@Test
	public void givenExamWithValueTo10_whenSetValue0_thenIsQualified() {
		Exam exam = new SingleExamBuilder().minimum(1).build();
		exam.setValue(1);
		assertThat(
			exam.isQualifiable()
		, is(true));
	}

	@Test
	public void givenExam_whenSetValueTo10_thenOk() {
		Exam exam = new SingleExamBuilder().percent(Rate.MAXIMUM_PERCENT).build();
		final double value = Rate.MAXIMUM_VALUE;
		exam.setValue(value);
		assertThat(
			exam.getResult()
		, is(value));
	}

	@Test
	public void givenExam_whenSetValueTo0_thenOk() {
		Exam exam = new SingleExamBuilder().percent(Rate.MAXIMUM_PERCENT).build();
		final double value = 0.0;
		exam.setValue(value);
		assertThat(
			exam.getResult()
		, is(value));
	}

	@Override
	protected Exam createExam() {
		return new SingleExamBuilder().build();
	}
	
	@Override
	protected Exam createExam_Name(String name) {
		return new SingleExamBuilder().name(name).build();
	}

	@Override
	protected Exam createExam_Minimum(double minimum) {
		return new SingleExamBuilder().minimum(minimum).build();
	}

	@Override
	protected Exam createExam_Percent(double percent) {
		return new SingleExamBuilder().percent(percent).build();
	}

}
