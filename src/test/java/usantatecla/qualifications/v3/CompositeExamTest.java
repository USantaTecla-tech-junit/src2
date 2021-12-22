package usantatecla.qualifications.v3;

import static org.junit.Assert.*;
import static usantatecla.qualifications.v3.builders.ExamFactory.createCompositeExam_Empty;
import static usantatecla.qualifications.v3.builders.ExamFactory.createCompositeExam_SingleExam;
import static usantatecla.qualifications.v3.builders.ExamFactory.createCompositeExam_Exams;
import static usantatecla.qualifications.v3.builders.ExamFactory.createCompositeExam_Minimum;
import static usantatecla.qualifications.v3.builders.ExamFactory.createCompositeExam_Name;
import static usantatecla.qualifications.v3.builders.ExamFactory.createCompositeExam_Percent;
import static usantatecla.qualifications.v3.builders.ExamFactory.createCompositeExam_Percent_Name;
import static usantatecla.qualifications.v3.builders.ExamFactory.createSingleExam;
import static usantatecla.qualifications.v3.builders.ExamFactory.createSingleExam_Name;
import static usantatecla.qualifications.v3.builders.ExamFactory.createSingleExam_Percent;
import static usantatecla.qualifications.v3.builders.ExamFactory.createSingleExam_Percent_Name;
import static usantatecla.qualifications.v3.builders.ExamFactory.createSingleExam_Percent_Value;
import static org.hamcrest.number.IsCloseTo.closeTo;
import org.junit.Test;

public class CompositeExamTest extends ExamTest {

	@Test(expected = AssertionError.class)
	public void givenCompositeExam_whenCreatingWithoutExam_thenAssertionError() {
		createCompositeExam_Empty();
	}

	@Test(expected = AssertionError.class)
	public void givenCompositeExam_whenCreatingSumPercentLessThanMaximum_thenAssertionError() {
		double percent = Rate.MAXIMUM_PERCENT / 2;
		createCompositeExam_Exams(
			createSingleExam_Percent(percent)
		, createSingleExam_Percent(percent - CompositeExamTest.EPSILON));
	}

	@Test
	public void givenCompositeExam_whenCreatingSumPercentEqualsMaximum_thenOk(){
		double percent = Rate.MAXIMUM_PERCENT / 2;
		double value = 5.0;
		Exam exam = createCompositeExam_Exams(
			createSingleExam_Percent_Value(percent, value)
		, createSingleExam_Percent_Value(percent, value));
		assertThat(exam.getResult(), closeTo(value, CompositeExamTest.EPSILON));
	}

	@Test(expected = AssertionError.class)
	public void givenCompositeExam_whenCreatingSumPercentGreaterMaximum_thenAssertionError() {
		double percent = Rate.MAXIMUM_PERCENT / 2;
		createCompositeExam_Exams(
			createSingleExam_Percent(percent)
		, createSingleExam_Percent(percent + CompositeExamTest.EPSILON));
	}

	@Test(expected = AssertionError.class)
	public void givenCompositeExam_whenCreatingWithSameNames_thenAssertionError() {
		String name = "name";
		createCompositeExam_Exams(
			createSingleExam_Name(name)
		, createSingleExam_Name(name));
	}

	@Test
	public void givenCompositionExamWithTwoSimgleExam_whenGetResult_thenOk() {
		assertThat(
			createCompositeExam_Exams(
				createSingleExam_Percent_Value(0.3, 7.0)
			,	createSingleExam_Percent_Value(0.7, 5.0))
				.getResult()
		, closeTo(5.6, CompositeExamTest.EPSILON));
	}

	@Test
	public void givenCompositionExamWithTwoTypeExams_whenGetResult_thenOk() {
		Exam exam = createCompositeExam_Exams(
			createSingleExam_Percent_Value(0.5, 10.0)
		, createCompositeExam_Percent(0.5
			, createSingleExam_Percent_Value(0.3, 7.0)
			, createSingleExam_Percent_Value(0.7, 5.0)));
		assertThat(
			exam.getResult()
		, closeTo(7.8, CompositeExamTest.EPSILON));
	}

	@Test
	public void givenCompositeExamWithTwoSingleExam_whenSetValue_thenOk() {
		Exam exam = createCompositeExam_Exams(
			createSingleExam_Percent_Name(0.1, "a")
		,	createSingleExam_Percent_Name(0.9, "b"));
		exam.setValue(2.0, "a");
		exam.setValue(8.0, "b");
		assertThat(
			exam.getResult()
		, closeTo(7.4, CompositeExamTest.EPSILON));
	}

	@Test
	public void givenCompositeExamWithTypesSingleExam_whenSetValue_thenOk() {
		Exam exam = createCompositeExam_Exams(
			createSingleExam_Percent_Name(0.5, "a")
		, createCompositeExam_Percent_Name(0.5, "b", 
				createSingleExam_Percent_Name(0.3, "b1")
			, createSingleExam_Percent_Name(0.7, "b2")));
		exam.setValue(10.0, "a");
		exam.setValue(7.0, "b", "b1");
		exam.setValue(5.0, "b", "b2");
		assertThat(
			exam.getResult()
		, closeTo(7.8, CompositeExamTest.EPSILON));
	}

	@Override
	protected Exam createExam_Name(String name) {
		return createCompositeExam_Name(name, createSingleExam());
	}

	@Override
	protected Exam createExam_Minimum(double minimum) {
		return createCompositeExam_Minimum(minimum);
	}

	@Override
	protected Exam createExam_Percent(double percent) {
		return createCompositeExam_Percent(percent);
	}

	@Override
	protected Exam createExam() {
		return createCompositeExam_SingleExam();
	}	

}
