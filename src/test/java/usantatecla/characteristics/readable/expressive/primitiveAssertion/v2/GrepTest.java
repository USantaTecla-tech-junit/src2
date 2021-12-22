package usantatecla.characteristics.readable.expressive.primitiveAssertion.v2;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;

public class GrepTest {

	private Grep grep;
	
	@Test
	public void outputHasLineNumbers() {
		String content = "1st match on #1\nand\n2nd match on #3";
		String out = grep.grep("match", "test.txt", content);
		assertThat(out.indexOf("test.txt:1 1st match"), is(not(-1)));
		assertThat(out.indexOf("test.txt:1 2nd match"), is(not(-1)));
	}
}
