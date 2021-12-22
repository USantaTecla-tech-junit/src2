package usantatecla.characteristics.maintenance.professional.withoutBuilder;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class CompositeExamTest extends ExamTest {

	@Test(expected = AssertionError.class)
	public void testCompositeExamWithNullExamsError() {
		new CompositeExam("extraordinario", new Rate(), null);
	}

	@Test(expected = AssertionError.class)
	public void testCompositeExamWithEmptyExamsError() {
		new CompositeExam("extraordinario", new Rate(), new ArrayList<Exam>());
	}

	@Test(expected = AssertionError.class)
	public void testCompositeExamWithTotalPercentError() {
		Exam[] exams = new Exam[] {
			new SingleExam("teoría", new Rate(3.0, 0.45)),
			new SingleExam("practica", new Rate(3.0, 0.45)) };
		new CompositeExam("asignatura", new Rate(), Arrays.asList(exams));
	}

	@Test(expected = AssertionError.class)
	public void testCompositeExamWithRepeatedNamesError() {
		Exam[] exams = new Exam[] {
			new SingleExam("problema", new Rate(3.0, 0.45)),
				new SingleExam("problema", new Rate(3.0, 0.45)) };
		new CompositeExam("asignatura", new Rate(), Arrays.asList(exams));
	}

	@Test
	public void testCompositeExam() {
		Rate rate = new Rate(0.0, 0.5);
		rate.setValue(7);
		Exam singleExam1 = new SingleExam("teoría", rate);
		rate = new Rate(0.0, 0.5);
		rate.setValue(5);
		Exam singleExam2 = new SingleExam("práctica", rate);
		Exam compositeExam = new CompositeExam("asignatura", new Rate(0.0, 1.0),
				Arrays.asList(singleExam1, singleExam2));
		assertThat(compositeExam.getName(), is("asignatura"));
		assertThat(compositeExam.isQualifiable(), is(true));
		assertThat(compositeExam.getResult(), closeTo(6.0, PRECISION));
	}

	@Test
	public void testIsQualifiable() {
		boolean[][] qualifiables = new boolean[][] { 
			{ false, false, false }, 
			{ false, false, true },
			{ false, true, false }, 
			{ false, true, true }, 
			{ true, false, false }, 
			{ true, false, true },
			{ true, true, false }, 
			{ true, true, true }, };
		boolean[] isQualifiables = new boolean[] { 
				false, 
				false, 
				false, 
				false, 
				false, 
				false, 
				false, 
				true };
		assert qualifiables.length == isQualifiables.length;
		for (int i = 0; i < qualifiables.length; i++) {
			assertThat("con " + qualifiables[i] + " y " + isQualifiables[i],
					getCompositeExamWithQualifiableOrNotSingleExam(qualifiables[i]).isQualifiable(),
					is(isQualifiables[i]));
		}
	}
	
	public Exam getCompositeExamWithQualifiableOrNotSingleExam(boolean[] isQualifiables) {
		double minimum = new Random(System.currentTimeMillis()).nextInt(9)+1;
		List<Exam> exams = new ArrayList<Exam>();
		for (int i = 0; i < isQualifiables.length; i++) {
			Rate rate = new Rate(minimum, 1.0 / isQualifiables.length);
			if (isQualifiables[i]) {
				rate.setValue(minimum + 1.0);
			} else {
				rate.setValue(minimum - 1.0);
			}
			exams.add(new SingleExam("examen"+i, rate));
		}
		return new CompositeExam("asignatura", new Rate(), exams);
	}

	@Test
	public void testGetResult() {
		assertThat(getCompositeExamWithSamePercents(7.0, new double[] { 9.0, 8.0, 7.0 }).getResult(),
				closeTo(8.0, PRECISION));
	}

	private static Exam getCompositeExamWithSamePercents(double minimum, double[] values) {
		List<Exam> exams = new ArrayList<Exam>();
		for (int i = 0; i < values.length; i++) {
			Rate rate = new Rate(minimum, 1.0 / values.length);
			rate.setValue(values[i]);
			exams.add(new SingleExam("teoría" + i, rate));
		}
		return new CompositeExam("asignatura", new Rate(0.0, 1.0), exams);
	}

}
