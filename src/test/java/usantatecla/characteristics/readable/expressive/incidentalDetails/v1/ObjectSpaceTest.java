package usantatecla.characteristics.readable.expressive.incidentalDetails.v1;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ObjectSpaceTest {

	private Ruby runtime;

	private ObjectSpace objectSpace;

	@Before
	public void setUp() throws Exception {
		runtime = Ruby.newInstance();
		objectSpace = new ObjectSpace();
	}

	@Test
	public void testObjectSpace() {
		IRubyObject o1 = runtime.newFixnum(10);
		IRubyObject o2 = runtime.newFixnum(20);
		IRubyObject o3 = runtime.newFixnum(30);
		IRubyObject o4 = runtime.newString("hello");
		objectSpace.add(o1);
		objectSpace.add(o2);
		objectSpace.add(o3);
		objectSpace.add(o4);
		List<IRubyObject> storedFixnums = new ArrayList<IRubyObject>(3);
		storedFixnums.add(o1);
		storedFixnums.add(o2);
		storedFixnums.add(o3);
		Iterator<Object> strings = objectSpace.iterator(runtime.getString());
		assertSame(o4, strings.next());
		assertNull(strings.next());
		Iterator<Object> numerics = objectSpace.iterator(runtime.getNumeric());
		for (int i = 0; i < 3; i++) {
			Object item = numerics.next();
			assertTrue(storedFixnums.contains(item));
		}
		assertNull(numerics.next());
	}
}
