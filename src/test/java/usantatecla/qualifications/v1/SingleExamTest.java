package usantatecla.qualifications.v1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SingleExamTest extends ExamTest {

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithNegativeValue_thenAssertionError() {
		SingleExam singleExam = new SingleExam("exam", new Rate());
		singleExam.setValue(-ExamTest.EPSILON);
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithExcesiveValue_thenAssertionError() {
		SingleExam singleExam = new SingleExam("exam", new Rate());
		singleExam.setValue(Rate.MAXIMUM_VALUE + ExamTest.EPSILON);
	}

	@Test
	public void givenRateWithValueGreaterOrEqualsThanMinimun_whenIsQualifiable_thenTrue() {
		final double minimum = 0;
		SingleExam singleExam = new SingleExam("exam", new Rate(Rate.MAXIMUM_PERCENT, minimum));
		singleExam.setValue(minimum);
		assertThat(singleExam.isQualifiable(), is(true));
	}

	@Test
	public void givenRateWithValueLessThanMinimun_whenIsQualifiable_thenFalse() {
		final double minimum = Rate.MAXIMUM_VALUE;
		SingleExam singleExam = new SingleExam("exam", new Rate(Rate.MAXIMUM_PERCENT, minimum));
		singleExam.setValue(minimum - ExamTest.EPSILON);
		assertThat(singleExam.isQualifiable(), is(false));
	}

	@Test(expected = AssertionError.class)
	public void givenRateNotIsQualifiable_whenGetResult_thenAssertionError() {
		final double minimum = Rate.MAXIMUM_VALUE;
		SingleExam singleExam = new SingleExam("exam", new Rate(Rate.MAXIMUM_PERCENT, minimum));
		singleExam.setValue(minimum - ExamTest.EPSILON);
		singleExam.getResult();
	}

	@Test
	public void givenRateIsQualifiableOnTop_whenGetResult_thenOk() {
		final double value = Rate.MAXIMUM_VALUE;
		SingleExam singleExam = new SingleExam("exam", new Rate(Rate.MAXIMUM_PERCENT));
		singleExam.setValue(value);
		assertThat(singleExam.getResult(), is(value));
	}

	@Test
	public void givenRateIsQualifiableOnMiddle_whenGetResult_thenOk() {
		final double value = Rate.MAXIMUM_VALUE / 2;
		final double percent = Rate.MAXIMUM_PERCENT / 2;
		SingleExam singleExam = new SingleExam("exam", new Rate(percent));
		singleExam.setValue(value);
		assertThat(singleExam.getResult(), is(value * percent));
	}

	@Test
	public void givenRateIsQualifiableOnBottom_whenGetResult_thenOk() {
		final double value = 0.0;
		SingleExam singleExam = new SingleExam("exam", new Rate(value));
		singleExam.setValue(value);
		assertThat(singleExam.getResult(), is(value));
	}

	@Test
	public void givenExamWithValueTo10_whenSetValue0_thenNotIsQualified() {
		Exam exam = new SingleExam("exam", new Rate(Rate.MAXIMUM_PERCENT, 1.0));
		exam.setValue(0);
		assertThat(exam.isQualifiable(), is(false));
	}

	@Test
	public void givenExamWithValueTo10_whenSetValue0_thenIsQualified() {
		Exam exam = new SingleExam("exam", new Rate(Rate.MAXIMUM_PERCENT, 1.0));
		exam.setValue(1);
		assertThat(exam.isQualifiable(), is(true));
	}

	@Test
	public void givenExam_whenSetValueTo10_thenOk() {
		Exam exam = new SingleExam("exam", new Rate());
		final double value = Rate.MAXIMUM_VALUE;
		exam.setValue(value);
		assertThat(exam.getResult(), is(value));
	}

	@Test
	public void givenExam_whenSetValueTo0_thenOk() {
		Exam exam = new SingleExam("exam", new Rate());
		final double value = 0.0;
		exam.setValue(value);
		assertThat(exam.getResult(), is(value));
	}

	@Override
	protected Exam createExam() {
		return new SingleExam("exam", new Rate());
	}

	@Override
	protected Exam createExam_Name(String name) {
		return new SingleExam(name, new Rate());
	}

	@Override
	protected Exam createExam_Minimum(double minimum) {
		return new SingleExam("name", new Rate(Rate.MAXIMUM_PERCENT, minimum));
	}

	@Override
	protected Exam createExam_Percent(double percent) {
		return new SingleExam("name", new Rate(percent));
	}

}
