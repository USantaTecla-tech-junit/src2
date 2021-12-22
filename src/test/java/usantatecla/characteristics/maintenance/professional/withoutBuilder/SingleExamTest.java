package usantatecla.characteristics.maintenance.professional.withoutBuilder;

import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class SingleExamTest extends ExamTest {

	@Test(expected = AssertionError.class)
	public void testSingleExamWihtNullNameError() {
		new SingleExam(null, new Rate(3.0, 0.5));
	}

	@Test(expected = AssertionError.class)
	public void testSingleExamWihtEmptyNameError() {
		new SingleExam("", new Rate(3.0, 0.5));
	}
	
	@Test
	public void testSingleExam() {
		String name = "extraordinario";
		Rate rate = new Rate(3.0, 0.5);
		rate.setValue(5);
		Exam singleExam = new SingleExam(name, rate);
		assertThat(singleExam.getName(), is(name));
		assertThat(singleExam.getResult(), closeTo(2.5, PRECISION));
	}

	@Test
	public void testIsQuilifiable() {
		String name = "extraordinario";
		Rate rate = new Rate(3.0, 1.0);
		rate.setValue(5);
		assertThat(new SingleExam(name, rate).isQualifiable(), is(true));
		rate.setValue(2);
		assertThat(new SingleExam(name, rate).isQualifiable(), is(false));
	}
	
	@Test
	public void testGetResult() {
		String name = "extraordinario";
		Rate rate = new Rate(3.0, 1.0);
		rate.setValue(5);
		assertThat(new SingleExam(name, rate).getResult(), closeTo(5.0, PRECISION));
	}
	
}
