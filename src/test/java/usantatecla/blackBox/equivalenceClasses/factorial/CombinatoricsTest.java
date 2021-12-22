package usantatecla.blackBox.equivalenceClasses.factorial;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Ignore;
import org.junit.Test;

public class CombinatoricsTest {

	@Test(expected = AssertionError.class)
	public void testFactorialWithNegativeValueExceptionrror(){
		Combinatorics.factorial(-5);
	}
	
	@Test(expected = AssertionError.class)
	public void testFactorialWithMaxValueExceptionrror(){
		Combinatorics.factorial(Combinatorics.FACTORIAL_MAX_VALUE+1);
	}
	
	@Test
	public void testFactorial() {
		assertThat(Combinatorics.factorial(0), is(1L));
		assertThat(Combinatorics.factorial(5), is(120L));
	}
	
	@Test
	@Ignore
	public void calulateFactorialMaxValue() {
		long max = Long.MAX_VALUE;
		long min = 0;
		long average = average(max, min);
		boolean isStable;
		do {
			isStable = isStable(average, max, min);
			try {
				System.out.print(average +  " entre ["+min+", "+max+"] con ... ");
				System.out.print(Combinatorics.factorial(average));
				if (!isStable) {
					System.out.println(" A por más");
					min = average;
				}
			} catch (AssertionError ex) {
				if (!isStable) {
					System.out.println("Un poco menos");
					max = average;
				}
			} finally {
				average = average(max, min);
			}
		} while (!isStable);
	}
 
	private static long average(long max, long min) {
		return min + (max-min)/2; 
	}
	
	private static boolean isStable(long average, long max, long min){
		return (average == min || average == max);
	}

}


