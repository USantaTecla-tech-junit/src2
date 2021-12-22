package usantatecla.blackBox.equivalenceClasses.ratings;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	NominalRateTest.class, 
	RateTest.class, 
	SingleExamTest.class,
	CompositeExamTest.class,
})
public class AllTests {

}
