package usantatecla.blackBox.equivalenceClasses.days;

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
		assertThat(Day.next(Day.TUESDAY), is(Day.WEDNESDAY));
		assertThat(Day.next(Day.SUNDAY), is(Day.MONDAY));
	}

}
