package usantatecla.characteristics.readable.simple.conditionalLogic.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
		dictionary.add(new Pair("A", new Long(3L)));
		dictionary.add(new Pair("B", "21"));
		for (Iterator<Pair> iterator = dictionary.iterator(); iterator.hasNext();) {
			Pair pair = iterator.next();
			if ("A".equals(pair.getKey())) {
				assertEquals(3L, pair.getValue());
			} else if ("B".equals(pair.getKey())) {
				assertEquals("21", pair.getValue());
			} else {
				fail();
			}
		}
	}
}