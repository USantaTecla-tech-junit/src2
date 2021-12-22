package usantatecla.qualifications.v2;

import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;
import org.junit.Test;

import usantatecla.qualifications.v2.builders.CompositeExamBuilder;
import usantatecla.qualifications.v2.builders.SingleExamBuilder;

public class CompositeExamTest extends ExamTest {

	@Test(expected = AssertionError.class)
	public void givenCompositeExam_whenCreatingWithoutExam_thenAssertionError() {
		new CompositeExamBuilder()
			.build();
	}

	@Test(expected = AssertionError.class)
	public void givenCompositeExam_whenCreatingSumPercentLessThanMaximum_thenAssertionError() {
		double percent = Rate.MAXIMUM_PERCENT / 2;
		new CompositeExamBuilder()
				.exam(new SingleExamBuilder().percent(percent).build())
				.exam(new SingleExamBuilder().percent(percent - CompositeExamTest.EPSILON).build()).build();
	}

	@Test
	public void givenCompositeExam_whenCreatingSumPercentEqualsMaximum_thenOk(){
		double percent = Rate.MAXIMUM_PERCENT / 2;
		double value = 5.0;
		Exam exam = new CompositeExamBuilder()
			.exam(new SingleExamBuilder().value(value).percent(percent).build())
			.exam(new SingleExamBuilder().value(value).percent(percent).build()).build();
		assertThat(exam.getResult(), closeTo(value, CompositeExamTest.EPSILON));
	}

	@Test(expected = AssertionError.class)
	public void givenCompositeExam_whenCreatingSumPercentGreaterMaximum_thenAssertionError() {
		double percent = Rate.MAXIMUM_PERCENT / 2;
		new CompositeExamBuilder()
				.exam(new SingleExamBuilder().percent(percent).build())
				.exam(new SingleExamBuilder().percent(percent + CompositeExamTest.EPSILON).build()).build();
	}

	@Test(expected = AssertionError.class)
	public void givenCompositeExam_whenCreatingWithSameNames_thenAssertionError() {
		String name = "name";
		new CompositeExamBuilder()
				.exam(new SingleExamBuilder().name(name).build())
				.exam(new SingleExamBuilder().name(name).build()).build();
	}

	@Test
	public void givenCompositionExamWithTwoSimgleExam_whenGetResult_thenOk() {
		assertThat(
			new CompositeExamBuilder()
				.exam(new SingleExamBuilder().value(7.0).percent(0.3).build())
				.exam(new SingleExamBuilder().value(5.0).percent(0.7).build())
				.build()
					.getResult()
		, closeTo(5.6, CompositeExamTest.EPSILON));
	}

	@Test
	public void givenCompositionExamWithTwoTypeExams_whenGetResult_thenOk() {
		Exam exam = new CompositeExamBuilder()
		.exam(new SingleExamBuilder().value(10.0).percent(0.5).build())
		.exam(new CompositeExamBuilder() 
			.exam(new SingleExamBuilder().value(7.0).percent(0.3).build())
			.exam(new SingleExamBuilder().value(5.0).percent(0.7).build())
			.percent(0.5)
			.name("b").build()).build();
		assertThat(
			exam.getResult()
		, closeTo(7.8, CompositeExamTest.EPSILON));
	}

	@Test
	public void givenCompositeExamWithTwoSingleExam_whenSetValue_thenOk() {
		Exam exam = new CompositeExamBuilder()
		.exam(new SingleExamBuilder().percent(0.1).name("a").build())
		.exam(new SingleExamBuilder().percent(0.9).name("b").build()).build();
		exam.setValue(2.0, "a");
		exam.setValue(8.0, "b");
		assertThat(
			exam.getResult()
		, closeTo(7.4, CompositeExamTest.EPSILON));
	}

	@Test
	public void givenCompositeExamWithTypesSingleExam_whenSetValue_thenOk() {
		Exam exam = new CompositeExamBuilder()
			.exam(new SingleExamBuilder().percent(0.5).name("a").build())
			.exam(new CompositeExamBuilder() 
				.exam(new SingleExamBuilder().percent(0.3).name("b1").build())
				.exam(new SingleExamBuilder().percent(0.7).name("b2").build())
				.percent(0.5)
				.name("b").build()).build();
		exam.setValue(10.0, "a");
		exam.setValue(7.0, "b", "b1");
		exam.setValue(5.0, "b", "b2");
		assertThat(
			exam.getResult()
		, closeTo(7.8, CompositeExamTest.EPSILON));
	}

	@Override
	protected Exam createExam_Name(String name) {
		return new CompositeExamBuilder().exam(new SingleExamBuilder().build()).name(name).build();
	}

	@Override
	protected Exam createExam_Minimum(double minimum) {
		return new CompositeExamBuilder().exam(new SingleExamBuilder().build()).minimum(minimum).build();
	}

	@Override
	protected Exam createExam_Percent(double percent) {
		return new CompositeExamBuilder().exam(new SingleExamBuilder().build()).percent(percent).build();
	}

	@Override
	protected Exam createExam() {
		return new CompositeExamBuilder().exam(new SingleExamBuilder().build()).build();
	}	

}
