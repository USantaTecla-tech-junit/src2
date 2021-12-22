package usantatecla.factorial.v1.incompleteTest;

public class Math {

	public static long factorial(long value){
		assert 0 <= value;
		long acum = 1;
		for(int i=1; i<=value; i++){
			acum *= i;
		}
		return acum;
	}
}
