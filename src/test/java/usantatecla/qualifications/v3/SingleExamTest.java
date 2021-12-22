package usantatecla.qualifications.v3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static usantatecla.qualifications.v3.builders.ExamFactory.createSingleExam;
import static usantatecla.qualifications.v3.builders.ExamFactory.createSingleExam_Minimum;
import static usantatecla.qualifications.v3.builders.ExamFactory.createSingleExam_Minimum_Value;
import static usantatecla.qualifications.v3.builders.ExamFactory.createSingleExam_Name;
import static usantatecla.qualifications.v3.builders.ExamFactory.createSingleExam_Percent;
import static usantatecla.qualifications.v3.builders.ExamFactory.createSingleExam_Value;
import static usantatecla.qualifications.v3.builders.ExamFactory.createSingleExam_Value_Percent;

import org.junit.Test;

public class SingleExamTest extends ExamTest {

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithNegativeValue_thenAssertionError() {
		createSingleExam_Value(-ExamTest.EPSILON);
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithExcesiveValue_thenAssertionError() {
		createSingleExam_Value(Rate.MAXIMUM_VALUE + ExamTest.EPSILON);
	}

	@Test
	public void givenRateWithValueGreaterThanMinimun_whenIsQualifiable_thenTrue() {
		final double minimum = 0;
		assertThat(
			createSingleExam_Minimum_Value(minimum, minimum).isQualifiable()
		, is(true));
	}

	@Test
	public void givenRateWithValueLessThanMinimun_whenIsQualifiable_thenFalse() {
		final double minimum = Rate.MAXIMUM_VALUE;
		assertThat(
			createSingleExam_Minimum_Value(minimum, minimum - ExamTest.EPSILON).isQualifiable()
		, is(false));
	}

	@Test(expected = AssertionError.class)
	public void givenRateNotIsQualifiable_whenGetResult_thenAssertionError() {
		final double minimum = Rate.MAXIMUM_VALUE;
		createSingleExam_Minimum_Value(minimum, minimum - ExamTest.EPSILON).getResult();
	}

	@Test
	public void givenRateIsQualifiableOnTop_whenGetResult_thenOk() {
		final double value = Rate.MAXIMUM_VALUE;
		assertThat(
			createSingleExam_Value_Percent(value, Rate.MAXIMUM_PERCENT).getResult()
		, is(value));
	}

	@Test
	public void givenRateIsQualifiableOnMiddle_whenGetResult_thenOk() {
		final double value = Rate.MAXIMUM_VALUE / 2;
		final double percent = Rate.MAXIMUM_PERCENT / 2;
		assertThat(
			createSingleExam_Value_Percent(value, percent).getResult()
		, is(value * percent));
	}

	@Test
	public void givenRateIsQualifiableOnBottom_whenGetResult_thenOk() {
		final double value = 0.0;
		assertThat(
			createSingleExam_Value_Percent(value, 0.0).getResult()
		, is(value));
	}

	@Test
	public void givenExamWithValueTo10_whenSetValue0_thenNotIsQualified() {
		Exam exam = this.createExam_Minimum(1);
		exam.setValue(0);
		assertThat(
			exam.isQualifiable()
		, is(false));
	}

	@Test
	public void givenExamWithValueTo10_whenSetValue0_thenIsQualified() {
		Exam exam = this.createExam_Minimum(1);
		exam.setValue(1);
		assertThat(
			exam.isQualifiable()
		, is(true));
	}

	@Test
	public void givenExam_whenSetValueTo10_thenOk() {
		Exam exam = this.createExam_Percent(Rate.MAXIMUM_PERCENT);
		final double value = Rate.MAXIMUM_VALUE;
		exam.setValue(value);
		assertThat(
			exam.getResult()
		, is(value));
	}

	@Test
	public void givenExam_whenSetValueTo0_thenOk() {
		Exam exam = this.createExam_Percent(Rate.MAXIMUM_PERCENT);
		final double value = 0.0;
		exam.setValue(value);
		assertThat(
			exam.getResult()
		, is(value));
	}

	@Override
	protected Exam createExam() {
		return createSingleExam();
	}
	
	@Override
	protected Exam createExam_Name(String name) {
		return createSingleExam_Name(name);
	}

	@Override
	protected Exam createExam_Minimum(double minimum) {
		return createSingleExam_Minimum(minimum);
	}

	@Override
	protected Exam createExam_Percent(double percent) {
		return createSingleExam_Percent(percent);
	}

}
