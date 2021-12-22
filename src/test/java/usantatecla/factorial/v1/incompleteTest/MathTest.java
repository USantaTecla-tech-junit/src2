package usantatecla.factorial.v1.incompleteTest;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;


public class MathTest {

	@Test
	public void testFactorial() {
		assertThat(Math.factorial(0), is(1L));
		assertThat(Math.factorial(1), is(1L));
		assertThat(Math.factorial(2), is(2L));
		assertThat(Math.factorial(3), is(6L));
		assertThat(Math.factorial(4), is(24L));
		assertThat(Math.factorial(5), is(120L));
	}

}


