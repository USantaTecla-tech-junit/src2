package usantatecla.qualifications.v1;

import static org.junit.Assert.assertThat;

import org.junit.Test;


import static org.hamcrest.core.Is.is;

public abstract class ExamTest {
	protected static final double EPSILON = 0.001;
	
	@Test(expected = AssertionError.class)
	public void givenExam_whenCreatingWithNullName_thenAssertionError() {
		this.createExam_Name(null);
	}
	
	protected abstract Exam createExam_Name(String name);

	@Test(expected = AssertionError.class)
	public void givenExam_whenCreatingWithEmptyName_thenAssertionError() {
		this.createExam_Name("");
	}

	@Test()
	public void givenExam_whenGetName_thenOk() {
		String name = "name";
		assertThat(this.createExam_Name(name).getName(), is(name));
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithNegativeMinimum_thenAssertionError() {
		this.createExam_Minimum(-ExamTest.EPSILON);
	}

	protected abstract Exam createExam_Minimum(double minimum);

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithExcesiveMinimum_thenAssertionError() {
		this.createExam_Minimum(Rate.MAXIMUM_VALUE + ExamTest.EPSILON);
	}

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithNegativePercent_thenAssertionError() {
		this.createExam_Percent(-ExamTest.EPSILON);
	}

	protected abstract Exam createExam_Percent(double percent);

	@Test(expected = AssertionError.class)
	public void givenRate_whenCreatingWithExcesivePercent_thenAssertionError() {
		this.createExam_Percent(Rate.MAXIMUM_PERCENT + ExamTest.EPSILON);
	}

	@Test(expected = AssertionError.class)
	public void givenExamWithValueTo10_whenSetNegativeValue_thenAssertionError() {
		this.createExam().setValue(-ExamTest.EPSILON);
	}

	protected abstract Exam createExam();

	@Test(expected = AssertionError.class)
	public void givenExamWithValueTo10_whenSetExcessiveValue_thenAssertionError() {
		this.createExam().setValue(Rate.MAXIMUM_VALUE+ExamTest.EPSILON);
	}

}
