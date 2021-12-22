package usantatecla.qualifications.v1;

import static org.junit.Assert.*;

import java.util.Arrays;

import static org.hamcrest.number.IsCloseTo.closeTo;
import org.junit.Test;

public class CompositeExamTest extends ExamTest {

	@Test(expected = AssertionError.class)
	public void givenCompositeExam_whenCreatingWithoutExam_thenAssertionError() {
		new CompositeExam("name", new Rate(), Arrays.asList(new Exam[]{}));
	}

	@Test(expected = AssertionError.class)
	public void givenCompositeExam_whenCreatingSumPercentLessThanMaximum_thenAssertionError() {
		double percent = Rate.MAXIMUM_PERCENT / 2;
		new CompositeExam("name", new Rate(), Arrays.asList(new Exam[]{
			new SingleExam("a", new Rate(percent)), 
			new SingleExam("b", new Rate(percent - CompositeExamTest.EPSILON))}));
	}

	@Test
	public void givenCompositeExam_whenCreatingSumPercentEqualsMaximum_thenOk(){
		double percent = Rate.MAXIMUM_PERCENT / 2;
		double value = 5.0;
		Exam exam = new CompositeExam("name", new Rate(), Arrays.asList(new Exam[]{
			new SingleExam("a", new Rate(percent)), 
			new SingleExam("b", new Rate(percent))}));
		exam.setValue(value, "a");
		exam.setValue(value, "b");
		assertThat(exam.getResult(), closeTo(value, CompositeExamTest.EPSILON));
	}

	@Test(expected = AssertionError.class)
	public void givenCompositeExam_whenCreatingSumPercentGreaterMaximum_thenAssertionError() {
		double percent = Rate.MAXIMUM_PERCENT / 2;
		new CompositeExam("name", new Rate(), Arrays.asList(new Exam[]{
			new SingleExam("a", new Rate(percent)), 
			new SingleExam("b", new Rate(percent + CompositeExamTest.EPSILON))}));
	}

	@Test(expected = AssertionError.class)
	public void givenCompositeExam_whenCreatingWithSameNames_thenAssertionError() {
		String name = "name";
		new CompositeExam("name", new Rate(), Arrays.asList(new Exam[]{
			new SingleExam(name, new Rate()), 
			new SingleExam(name, new Rate())}));
	}

	@Test
	public void givenCompositionExamWithTwoSimgleExam_whenGetResult_thenOk() {
		Exam exam = new CompositeExam("name", new Rate(), Arrays.asList(new Exam[]{
			new SingleExam("a", new Rate(0.3)), 
			new SingleExam("b", new Rate(0.7))}));
		exam.setValue(7.0, "a");
		exam.setValue(5.0, "b");
		assertThat(exam.getResult(), closeTo(5.6, CompositeExamTest.EPSILON));
	}

	@Test
	public void givenCompositionExamWithTwoTypeExams_whenGetResult_thenOk() {
		CompositeExam exam = new CompositeExam("c", new Rate(), Arrays.asList(new Exam[]{
			new SingleExam("a", new Rate(0.5))
		, new CompositeExam("b", new Rate(0.5), Arrays.asList(new Exam[]{
				new SingleExam("b1", new Rate(0.3)), 
				new SingleExam("b2", new Rate(0.7))}))}));
		exam.setValue(10.0, "a");
		exam.setValue(7.0, "b", "b1");
		exam.setValue(5.0, "b", "b2");
		assertThat(exam.getResult(), closeTo(7.8, CompositeExamTest.EPSILON));
	}

	@Test
	public void givenCompositeExamWithTwoSingleExam_whenSetValue_thenOk() {
		Exam exam = new CompositeExam("name", new Rate(), Arrays.asList(new Exam[]{
			new SingleExam("a", new Rate(0.1))
		, new SingleExam("b", new Rate(0.9))}));
		exam.setValue(2.0, "a");
		exam.setValue(8.0, "b");
		assertThat(exam.getResult(), closeTo(7.4, CompositeExamTest.EPSILON));
	}

	@Test
	public void givenCompositeExamWithTypesSingleExam_whenSetValue_thenOk() {
		Exam exam = new CompositeExam("name", new Rate(), Arrays.asList(new Exam[]{
				new SingleExam("a", new Rate(0.5))
			, new CompositeExam("b", new Rate(0.5), Arrays.asList(new Exam[]{
					new SingleExam("b1", new Rate(0.3))
				, new SingleExam("b2", new Rate(0.7))})) }));
		exam.setValue(10.0, "a");
		exam.setValue(7.0, "b", "b1");
		exam.setValue(5.0, "b", "b2");
		assertThat(exam.getResult(), closeTo(7.8, CompositeExamTest.EPSILON));
	}

	@Override
	protected Exam createExam_Name(String name) {
		return new CompositeExam(name, new Rate(), Arrays.asList(
			new Exam[]{new SingleExam("name")}));
	}

	@Override
	protected Exam createExam_Minimum(double minimum) {
		return new CompositeExam("name", new Rate(Rate.MAXIMUM_PERCENT, minimum), Arrays.asList(
			new Exam[]{new SingleExam("name")}));
	}

	@Override
	protected Exam createExam_Percent(double percent) {
		return new CompositeExam("name", new Rate(percent), Arrays.asList(
			new Exam[]{new SingleExam("name")}));
	}

	@Override
	protected Exam createExam() {
		return new CompositeExam("name", new Rate(), Arrays.asList(
			new Exam[]{new SingleExam("name")}));
	}	

}
