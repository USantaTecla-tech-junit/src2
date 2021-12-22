package usantatecla.blackBox.boundaryValues;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	usantatecla.blackBox.boundaryValues.abs.MathTest.class,
	usantatecla.blackBox.boundaryValues.round.MathTest.class,
	usantatecla.blackBox.boundaryValues.planets.PlanetTest.class,
	usantatecla.blackBox.boundaryValues.days.DayTest.class,
	// usantatecla.blackBox.boundaryValues.date.DateTest.class,
	usantatecla.blackBox.boundaryValues.factorial.CombinatoricsTest.class,
	usantatecla.blackBox.boundaryValues.sqrt.MathTest.class,
})
public class AllTests {

}
