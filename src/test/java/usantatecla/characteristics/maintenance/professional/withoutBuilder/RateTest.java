package usantatecla.characteristics.maintenance.professional.withoutBuilder;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class RateTest {

	@Test(expected = AssertionError.class)
	public void testRateWithLessThanMinimunError() {
		new RateBuilder().minimum(-1).build();
	}

	@Test(expected = AssertionError.class)
	public void testRateWithGreatThanMinimunError() {
		new RateBuilder().minimum(14).build();
	}

	@Test(expected = AssertionError.class)
	public void testRateWithLessThanPercentError() {
		new RateBuilder().percent(-0.1).build();
	}

	@Test(expected = AssertionError.class)
	public void testRateWithGreatThanPercentError() {
		new RateBuilder().percent(1.3).build();
	}

	@Test
	public void testIsQualifiable() {
		assertThat(new RateBuilder().minimum(3).value(5).build()
				.isQualifiable(), is(true));
		assertThat(new RateBuilder().minimum(3).value(2).build()
				.isQualifiable(), is(false));
	}

	@Test(expected = AssertionError.class)
	public void testGetResultNotIsQualifiable() {
		new RateBuilder().minimum(5).value(4).build().getResult();
	}

	@Test
	public void testGetResult() {
		assertThat(new RateBuilder().percent(0.3).value(5.0).build().getResult(),
				is(1.5));
	}

}
