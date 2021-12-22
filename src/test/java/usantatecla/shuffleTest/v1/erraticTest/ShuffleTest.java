package usantatecla.shuffleTest.v1.erraticTest;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ShuffleTest {

	@Test
	public void testShuffle() {
		List<Integer> out = Arrays.asList(new Integer[] {0,1,2,3,4,5,6,7,8});
		Collections.shuffle(out);
		int samePositionCount = 0;
		for (int i = 0; i < out.size(); i++) {
			if (out.get(i)==i) {
				samePositionCount++;
			}
		}
		System.out.println("samePositionCount: "+samePositionCount);
		double samePositionPercent = (double)samePositionCount/(double)out.size();
		assertThat(0.3, is(greaterThan(samePositionPercent)));
	}

}
