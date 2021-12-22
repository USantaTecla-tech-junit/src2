package usantatecla.characteristics.readable.expressive.primitiveAssertion.v4;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class GrepTest {

	private Grep grep;
	
	@Test
	public void outputHasLineNumbers() {
		String content = "1st match on #1\nand\n2nd match on #3";
		String out = grep.grep("match", "test.txt", content);
		assertThat(out, containsString("test.txt:1 1st match"));
		assertThat(out, containsString("test.txt:1 2nd match"));
	}
}
