package usantatecla.characteristics.readable.expressive.hyperassertion.v2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LogFileTransformerTest {
	
	private static final String START = "2005-05-23 21:20:33";
	
	private static final String END = "2005-05-23 21:21:37";
	
	private LogFile logFile;

	@Before
	public void prepareLogFile() {
		logFile = new LogFile(START, END);
	}

	@Test
	public void overallFileStructureIsCorrect() throws Exception {
		StringBuilder string = new StringBuilder();
		string.append("session-id###SID");
		string.append("presentation-id###PID");
		string.append("user-id###UID");
		string.append("started###"+START);
		string.append("finished###"+END);
		assertEquals(string.toString(), transform(logFile.toString()));
	}

	@Test
	public void screenDurationsGoBetweenStartedAndFinished() throws Exception {
		logFile.addContent("[2005-05-23 21:20:35] screen1");
		String out = transform(logFile.toString());
		assertTrue(out.indexOf("started") < out.indexOf("screen1"));
		assertTrue(out.indexOf("screen1") < out.indexOf("finished"));
	}

	@Test
	public void screenDurationsAreRenderedInSeconds() throws Exception {
		logFile.addContent("[2005-05-23 21:20:35] screen1");
		logFile.addContent("[2005-05-23 21:21:35] screen2");
		logFile.addContent("[2005-05-23 21:21:36] screen3");
		String output = transform(logFile.toString());
		assertTrue(output.contains("screen1###0"));
		assertTrue(output.contains("screen2###61"));
		assertTrue(output.contains("screen3###1"));
	}

	private String transform(String log) {
		return null;
	}

}