package usantatecla.blackBox.equivalenceClasses.ratings;

import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class SingleExamTest extends ExamTest {

	@Override
	protected ExamBuilder getExamBuilder() {
		return new SingleExamBuilder();
	}
	
	@Test
	public void testSingleExam() {
		String name = "extraordinario";
		Exam singleExam = this.getExamBuilder().name(name).minimum(3.0)
				.percent(0.5).value(5).build();
		assertThat(singleExam.getName(), is(name));
		assertThat(singleExam.getResult(), closeTo(2.5, PRECISION));
	}

	@Test
	public void testIsQuilifiable() {
		assertThat(this.getExamBuilder().minimum(3.0).value(5).build()
				.isQualifiable(), is(true));
		assertThat(this.getExamBuilder().minimum(3.0).value(2).build()
				.isQualifiable(), is(false));
	}
	
	@Test
	public void testGetResult() {
		assertThat(this.getExamBuilder().percent(0.3).value(5).build()
				.getResult(), closeTo(1.5, PRECISION));
	}
	
}
