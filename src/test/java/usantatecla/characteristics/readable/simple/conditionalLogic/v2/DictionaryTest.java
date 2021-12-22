package usantatecla.characteristics.readable.simple.conditionalLogic.v2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {

	private Dictionary dictionary;

	@Before
	public void before() {
		dictionary = new Dictionary();
	}

	@Test
	public void returnsAnIteratorForContents() throws Exception {
		Pair[] pairs = new Pair[] { 
				new Pair("A", new Long(3)), 
				new Pair("B", "21") 
			};
		for (Pair pair : pairs) {
			dictionary.add(pair);
		}
		for (Pair pair : pairs) {
			assertContains(pair);
		}
		assertThat(dictionary.size(), is(pairs.length));
	}

	private void assertContains(Pair expectedPair) {
		Pair resultPair = null;
		Iterator<Pair> iterator = dictionary.iterator();
		while (iterator.hasNext() && !expectedPair.equals(resultPair = iterator.next()))
			;
		assertEquals(expectedPair, resultPair);
	}

}