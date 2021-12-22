package usantatecla.characteristics.readable.simple.splitPersonality.v2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public abstract class ConfigurationTest {

	protected Configuration configuration;

	@Before
	public void before() throws InvalidArgumentException {
		configuration = new Configuration();
		configuration.processArguments(args());
	}

	protected String[] args() {
		return new String[] {};
	}
}

class DefaultValuesConfigurationTest extends ConfigurationTest {

	@Test
	public void testConfiguration() {
		assertFalse(configuration.isDebuggingEnabled());
		assertFalse(configuration.isWarningsEnabled());
		assertFalse(configuration.isVerbose());
		assertFalse(configuration.shouldShowVersion());
	}
}

class CorrectValuesConfigurationTest extends ConfigurationTest {

	@Override
	protected String[] args() {
		return new String[] { "-f", "hello.txt", "-v", "-d", "-w", "--version" };
	}

	@Test
	public void testProcessArguments() {
		assertEquals("hello.txt", configuration.getFileName());
		assertTrue(configuration.isDebuggingEnabled());
		assertTrue(configuration.isWarningsEnabled());
		assertTrue(configuration.isVerbose());
		assertTrue(configuration.shouldShowVersion());
	}
}

class ErrorValuesConfigurationTest extends ConfigurationTest {

	@Override
	protected String[] args() {
		return new String[] { "-f" };
	}

	@Test(expected = InvalidArgumentException.class)
	public void missingArgumentRaisesAnError() {
	}
}