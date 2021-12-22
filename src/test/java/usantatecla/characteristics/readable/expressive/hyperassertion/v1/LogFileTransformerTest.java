package usantatecla.characteristics.readable.expressive.hyperassertion.v1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LogFileTransformerTest {

	private String logFile;
	
	private String expectedOutput;

	@Before
	public void setUpBuildLogFile() {
		StringBuilder string = new StringBuilder();
		string.append("[2005-05-23 21:20:33] LAUNCHED");
		string.append("[2005-05-23 21:20:33] session-id###SID");
		string.append("[2005-05-23 21:20:33] user-id###UID");
		string.append("[2005-05-23 21:20:33] presentation-id###PID");
		string.append("[2005-05-23 21:20:35] screen1");
		string.append("[2005-05-23 21:20:36] screen2");
		string.append("[2005-05-23 21:21:36] screen3");
		string.append("[2005-05-23 21:21:36] screen4");
		string.append("[2005-05-23 21:22:00] screen5");
		string.append("[2005-05-23 21:22:48] STOPPED");
		logFile = string.toString();
	}

	@Before
	public void setUpBuildTransformedFile() {
		StringBuilder string = new StringBuilder();
		string.append("session-id###SID");
		string.append("presentation-id###PID");
		string.append("user-id###UID");
		string.append("started###2005-05-23 21:20:33");
		string.append("screen1###1");
		string.append("screen2###60");
		string.append("screen3###0");
		string.append("screen4###24");
		string.append("screen5###48");
		string.append("finished###2005-05-23 21:22:48");
		expectedOutput = string.toString();
	}

	@Test
	public void transformationGeneratesRightStuffIntoTheRightFile()
			throws Exception {
		TempFile input = TempFile.withSuffix(".src.log").append(logFile);
		TempFile output = TempFile.withSuffix(".dest.log");
		new LogFileTransformer().transform(input.file(), output.file());
		assertTrue("Destination file was not created", output.exists());
		assertEquals(expectedOutput, output.content());
	}

}
