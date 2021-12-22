package usantatecla.blackBox.boundaryValues.days;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class DayTest {

	@Test(expected = AssertionError.class)
	public void testNextWithNullError() {
		Day.next(null);
	}

	@Test
	public void testNext() {
		assertThat(Day.next(Day.MONDAY), is(Day.TUESDAY));
		assertThat(Day.next(Day.SATURDAY), is(Day.SUNDAY));
		assertThat(Day.next(Day.SUNDAY), is(Day.MONDAY));
	}

}
