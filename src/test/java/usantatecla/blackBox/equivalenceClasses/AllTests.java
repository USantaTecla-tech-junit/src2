package usantatecla.blackBox.equivalenceClasses;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	usantatecla.blackBox.equivalenceClasses.abs.MathTest.class,
	usantatecla.blackBox.equivalenceClasses.round.MathTest.class,
	usantatecla.blackBox.equivalenceClasses.planets.PlanetTest.class,
	usantatecla.blackBox.equivalenceClasses.days.DayTest.class,
	usantatecla.blackBox.equivalenceClasses.sqrt.MathTest.class,
	usantatecla.blackBox.equivalenceClasses.factorial.CombinatoricsTest.class,
	usantatecla.blackBox.equivalenceClasses.change.TurnTest.class,
	usantatecla.blackBox.equivalenceClasses.closedInterval.ClosedIntervalTest.class,
	// usantatecla.blackBox.equivalenceClasses.date.DateTest.class,
	usantatecla.blackBox.equivalenceClasses.ratings.AllTests.class,
})
public class AllTests {

}
