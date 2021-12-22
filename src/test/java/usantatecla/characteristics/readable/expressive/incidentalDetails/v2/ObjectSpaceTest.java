package usantatecla.characteristics.readable.expressive.incidentalDetails.v2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ObjectSpaceTest {

	private Ruby runtime;

	private ObjectSpace space;

	private IRubyObject string;

	private List<IRubyObject> fixnums;

	@Before
	public void setUp() throws Exception {
		runtime = Ruby.newInstance();
		space = new ObjectSpace();
		string = runtime.newString("hello");
		fixnums = new ArrayList<IRubyObject>();
		fixnums.add(runtime.newFixnum(10));
		fixnums.add(runtime.newFixnum(20));
		fixnums.add(runtime.newFixnum(30));
	}

	@Test
	public void testObjectSpace() {
		addTo(space, string);
		addTo(space, fixnums);
		Iterator<Object> strings = space.iterator(runtime.getString());
		assertContainsExactly(strings, string);
		Iterator<Object> numerics = space.iterator(runtime.getNumeric());
		assertContainsExactly(numerics, fixnums);
	}

	private void addTo(ObjectSpace space, Object... values) {
	}

//	private void addTo(ObjectSpace space, List<Object> values) {
//	}

	private void assertContainsExactly(Iterator<Object> i, Object... values) {
	}

//	private void assertContainsExactly(Iterator<Object> i, List values) {
//	}
}