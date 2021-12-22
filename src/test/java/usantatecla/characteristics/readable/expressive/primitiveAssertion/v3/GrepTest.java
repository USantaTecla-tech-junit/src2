package usantatecla.characteristics.readable.expressive.primitiveAssertion.v3;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class GrepTest {

	private Grep grep;
	
	@Test
	public void before() {
		grep = new Grep();
	}
	
	@Test
	public void outputHasLineNumbers() {
		String content = "1st xxx on #1\nand\n2nd xxx on #3";
		String out = grep.grep("xxx", "test.txt", content);
		assertThat(out.contains("test.txt:1 1st xxx on #1"), is(equals(true)));
		assertThat(out.contains("test.txt:2"), is(equals(false)));
		assertThat(out.contains("test.txt:3 2nd xxx on #3"), is(equals(true)));
	}
}
