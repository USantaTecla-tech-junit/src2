package usantatecla.characteristics.readable.simple.overprotectiveTests.v2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProjectTest {

	private Project project;
	
	@Before
	public void before() {
		project = new Project();
	}
	
	@Test
	public void testCount() {
		Data data = project.getData();
		assertEquals(4, data.count());
	}
}
