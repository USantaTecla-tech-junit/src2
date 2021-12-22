package usantatecla.blackBox.equivalenceClasses.closedInterval;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class ClosedIntervalTest {

	private ClosedInterval closedInterval;
	
	@Test(expected = AssertionError.class)
	public void testClosedIntervalWithInverseError() {
		closedInterval = new ClosedInterval(20, -30);
	}
	
	@Test
	public void testClosedInterval() {
		closedInterval = new ClosedInterval(-20, 30);
		assertThat(closedInterval.getLength(), is(50.0));
		assertThat(closedInterval.getMiddlePoint(), is(5.0));
	}
	
	@Test
	public void testIncludesDouble(){
		closedInterval = new ClosedInterval(17, 71);
		assertThat(closedInterval.includes(-3), is(false));
		assertThat(closedInterval.includes(50), is(true));
		assertThat(closedInterval.includes(99), is(false));
	}
	
	@Test(expected=AssertionError.class)
	public void testIncludesClosedIntervalWithNullError(){
		closedInterval = new ClosedInterval(-1, 1);
		closedInterval.includes(null);
	}
	
	@Test
	public void testIncludesClosedInterval(){
		closedInterval = new ClosedInterval(-5, 5);
		assertThat(closedInterval.includes(new ClosedInterval(-7, -6)), is(false));
		assertThat(closedInterval.includes(new ClosedInterval(-7, 0)), is(false));
		assertThat(closedInterval.includes(new ClosedInterval(-1, 1)), is(true));
		assertThat(closedInterval.includes(new ClosedInterval(0, 7)), is(false));
		assertThat(closedInterval.includes(new ClosedInterval(7, 9)), is(false));
		assertThat(closedInterval.includes(new ClosedInterval(-3, 8)), is(false));
	}
	
	@Test(expected=AssertionError.class)
	public void testIntersectedWhitNullError() {
		closedInterval = new ClosedInterval(-1, 1);
		closedInterval.intersected(null);
	}
	
	@Test
	public void testIntersected(){
		closedInterval = new ClosedInterval(10, 20);
		assertThat(closedInterval.intersected(new ClosedInterval(-10, 0)), is(false));
		assertThat(closedInterval.intersected(new ClosedInterval(5, 15)), is(true));
		assertThat(closedInterval.intersected(new ClosedInterval(10, 20)), is(true));
		assertThat(closedInterval.intersected(new ClosedInterval(15, 25)), is(true));
		assertThat(closedInterval.intersected(new ClosedInterval(30, 40)), is(false));
		assertThat(closedInterval.intersected(new ClosedInterval(0, 30)), is(true));	
	}

}
