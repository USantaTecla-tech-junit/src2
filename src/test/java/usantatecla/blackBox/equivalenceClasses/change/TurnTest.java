package usantatecla.blackBox.equivalenceClasses.change;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TurnTest {

	private Turn turn;

	@Test
	public void testChange() {
		int size = 3;
		turn = new Turn(size);
		int loops = 2;
		List<Integer> resultValues = getResultValues(size, loops);
		List<Integer> expectedValues = getExpectedValues(size, loops, resultValues);
		assertThat(resultValues, is(expectedValues));
	}

	private List<Integer> getResultValues(int size, int loops) {
		List<Integer> resultValues = new ArrayList<Integer>();
		for (int i = 0; i < loops; i++) {
			for (int j = 0; j < size; j++) {
				resultValues.add(turn.next());
			}
		}
		return resultValues;
	}

	private List<Integer> getExpectedValues(int size, int loops, List<Integer> resultValues) {
		List<Integer> expectedValues = new ArrayList<Integer>();
		for (int i = 0; i < loops; i++) {
			for (int j = 0; j < size; j++) {
				expectedValues.add(j);
			}
		}
		while (resultValues.get(0) != expectedValues.get(0)) {
			expectedValues.add(expectedValues.remove(0));
		}
		return expectedValues;
	}

}
