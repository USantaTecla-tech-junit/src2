package usantatecla.factorial.v2.completeTest;

public class Math {

	static final long FACTORIAL_MAX_VALUE = 20;

	public static long factorial(long value){
		assert 0 <= value && value <= Math.FACTORIAL_MAX_VALUE;
		
		long acum = 1;
		for(int i=1; i<=value; i++){
			acum *= i;
			// if (acum < 0){
			// 	throw new AssertionError();
			// }
		}
		return acum;
	}
}
