package usantatecla.characteristics.readable.cohesive.strangeTest;

import org.junit.Test;

public abstract class ExamTest {

	protected static final double PRECISION = 0.001;

	@Test(expected = AssertionError.class)
	public void testSingleExamWihtNullNameError() {
		this.getExamBuilder().name(null).build();
	}

	@Test(expected = AssertionError.class)
	public void testSingleExamWihtEmptyNameError() {
		this.getExamBuilder().name("").build();
	}
	
	protected abstract ExamBuilder getExamBuilder();

}
