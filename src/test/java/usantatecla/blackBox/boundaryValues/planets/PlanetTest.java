package usantatecla.blackBox.boundaryValues.planets;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class PlanetTest {

	@Test(expected=AssertionError.class)
	public void testNextWithNullError() {
		Planet.next(null);
	}
	
	@Test(expected=AssertionError.class)
	public void testNextWithLastError() {
	    Planet.next(lastPlanet());
	}
	
	private static Planet lastPlanet() {
		return Planet.values()[Planet.values().length-1];
	}
	
	@Test
	public void testNext() {
		assertThat(Planet.next(Planet.MERCURY), is(Planet.VENUS));
		assertThat(Planet.next(Planet.URANUS), is(Planet.NEPTUNE));
	}

}
