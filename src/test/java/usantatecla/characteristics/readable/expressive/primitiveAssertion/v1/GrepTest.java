package usantatecla.characteristics.readable.expressive.primitiveAssertion.v1;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrepTest {

	private Grep grep;
	
	@Test
	public void outputHasLineNumbers() {
		String content = "1st match on #1\nand\n2nd match on #3";
		String out = grep.grep("match", "test.txt", content);
		assertTrue(out.indexOf("test.txt:1 1st match") != -1);
		assertTrue(out.indexOf("test.txt:1 2nd match") != -1);
	}
}
