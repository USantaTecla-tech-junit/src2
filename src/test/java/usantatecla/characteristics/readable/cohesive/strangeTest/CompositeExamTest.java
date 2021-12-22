package usantatecla.characteristics.readable.cohesive.strangeTest;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

import java.util.Random;

import org.junit.Test;

public class CompositeExamTest extends ExamTest {

	@Override
	protected ExamBuilder getExamBuilder() {
		return this.getCompositeExamBuilder();
	}

	private CompositeExamBuilder getCompositeExamBuilder() {
		return new CompositeExamBuilder();
	}

	@Test(expected = AssertionError.class)
	public void testCompositeExamWithNullExamsError() {
		this.getCompositeExamBuilder().withoutExams().build();
	}

	@Test(expected = AssertionError.class)
	public void testCompositeExamWithEmptyExamsError() {
		this.getCompositeExamBuilder().build();
	}

	@Test(expected = AssertionError.class)
	public void testCompositeExamWithTotalPercentError() {
		this.getCompositeExamBuilder()
				.exam(new SingleExamBuilder().name("teoría").percent(0.45)
						.build())
				.exam(new SingleExamBuilder().name("practica").percent(0.45)
						.build()).build();
	}

	@Test(expected = AssertionError.class)
	public void testCompositeExamWithRepeatedNamesError() {
		this.getCompositeExamBuilder()
				.exam(new SingleExamBuilder().name("problema").percent(0.5)
						.build())
				.exam(new SingleExamBuilder().name("problema").percent(0.5)
						.build()).build();
	}

	@Test
	public void testCompositeExam() {	
		Exam singelExam1 = assertSingleExam("teoría", 0.5, 7, 3.5);
		Exam singelExam2 = assertSingleExam("práctica", 0.5, 5, 2.5);
		Exam compositeExam = this
				.getCompositeExamBuilder()
				.exam(singelExam1)
				.exam(singelExam2)
				.name("asignatura")
				.build();
		assertThat(compositeExam.getName(), is("asignatura"));
		assertThat(compositeExam.isQualifiable(), is(true));
		assertThat(compositeExam.getResult(), closeTo(6.0, PRECISION));
	}

	private Exam assertSingleExam(String name, double percent, double value, double result) {
		Exam singelExam = new SingleExamBuilder().name(name).percent(percent)
				.value(value).build();
		assertThat(singelExam.getName(), is(name));
		assertThat(singelExam.isQualifiable(), is(true));
		assertThat(singelExam.getResult(), closeTo(result, PRECISION));
		return singelExam;
	}

	@Test
	public void testIsQualifiable() {
		boolean[][] qualifiables = new boolean[][]{
				{false, false, false},
				{false, false, true},
				{false, true, false},
				{false, true, true},
				{true, false, false},
				{true, false, true},
				{true, true, false},
				{true, true, true},
		};
		boolean[] isQualifiables = new boolean[]{
				false,
				false,
				false, 
				false, 
				false,
				false, 
				false,
				true};
		assert qualifiables.length == isQualifiables.length;
		for(int i=0; i<qualifiables.length; i++){
			assertThat("con "+ qualifiables[i] + " y " + isQualifiables[i],
					getCompositeExamWithQualifiableOrNotSingleExam(qualifiables[i])
							.isQualifiable(), is(isQualifiables[i]));
		}
	}

	public Exam getCompositeExamWithQualifiableOrNotSingleExam(
			boolean[] isQualifiables) {
		CompositeExamBuilder compositeExamBuilder = new CompositeExamBuilder();
		double minimum = new Random(System.currentTimeMillis()).nextInt(10);
		for (int i = 0; i < isQualifiables.length; i++) {
			ExamBuilder singleExamBuilder = new SingleExamBuilder()
					.name("examen" + i).minimum(minimum)
					.percent(1.0 / isQualifiables.length);
			if (isQualifiables[i]) {
				singleExamBuilder.value(minimum + 1.0);
			} else {
				singleExamBuilder.value(minimum - 1.0);
			}
			compositeExamBuilder.exam(singleExamBuilder.build());
		}
		return compositeExamBuilder.build();
	}

	@Test
	public void testGetResult() {
		assertThat(
				getCompositeExamWithSamePercents(7.0,
						new double[] { 9.0, 8.0, 7.0 }).getResult(),
				closeTo(8.0, PRECISION));
	}

	private static Exam getCompositeExamWithSamePercents(double minimum,
			double[] values) {
		CompositeExamBuilder compositeExamBuilder = new CompositeExamBuilder();
		for (int i = 0; i < values.length; i++) {
			compositeExamBuilder.exam(new SingleExamBuilder()
					.name("examen" + i).minimum(minimum)
					.percent(1.0 / values.length).value(values[i]).build());
		}
		return compositeExamBuilder.build();
	}

}
