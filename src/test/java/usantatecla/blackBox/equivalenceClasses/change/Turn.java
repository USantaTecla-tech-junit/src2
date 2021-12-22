package usantatecla.blackBox.equivalenceClasses.change;

import java.util.Random;

class Turn {

	private final int SIZE;
	
	private int value;
	
	public Turn(int size) {
		assert size > 0;
		SIZE = size;
		value = randomFrom0UntilNonInclusiveMax(size);
	}
	
	private int randomFrom0UntilNonInclusiveMax(int max){
		return new Random(System.currentTimeMillis()).nextInt(SIZE);
	}

	public int next() {
		int result = value;
		value++;
		value %= SIZE;
		return result;
	}
	
}
