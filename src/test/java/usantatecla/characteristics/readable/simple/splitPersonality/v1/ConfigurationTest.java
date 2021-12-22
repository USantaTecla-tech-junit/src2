package usantatecla.characteristics.readable.simple.splitPersonality.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConfigurationTest {

	@Test(expected = InvalidArgumentException.class)
	public void testProcessArguments() throws InvalidArgumentException {
		Configuration configuration;
		configuration = new Configuration();
		configuration.processArguments(new String[] {});
		assertFalse(configuration.isDebuggingEnabled());
		assertFalse(configuration.isWarningsEnabled());
		assertFalse(configuration.isVerbose());
		assertFalse(configuration.shouldShowVersion());
		String file = "hello.txt";
		configuration.processArguments(new String[] { "-f", file, "-v", "--version" });
		assertEquals(file, configuration.getFileName());
		assertFalse(configuration.isDebuggingEnabled());
		assertFalse(configuration.isWarningsEnabled());
		assertTrue(configuration.isVerbose());
		assertTrue(configuration.shouldShowVersion());
		configuration = new Configuration();
		configuration.processArguments(new String[] { "-f" });
	}
}
