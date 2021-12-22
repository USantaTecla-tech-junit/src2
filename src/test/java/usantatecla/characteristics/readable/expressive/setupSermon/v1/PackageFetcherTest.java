package usantatecla.characteristics.readable.expressive.setupSermon.v1;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

public class PackageFetcherTest {
	
	private PackageFetcher fetcher;
	
	private Map<Integer, Resource> downloads;
	
	private File tempDir;

	@Before
	public void setUp() throws Exception {
		String systemTempDir = System.getProperty("java.io.tmpdir");
		tempDir = new File(systemTempDir, "downloads");
		tempDir.mkdirs();
		String filename = "/manifest.xml";
		InputStream xml = getClass().getResourceAsStream(filename);
		Document manifest = XOM.parse(IO.streamAsString(xml));
		PresentationList presentations = new PresentationList();
		presentations.parse(manifest.getDocumentElement());
		PresentationStorage db = new PresentationStorage();
		List<Resource> list = presentations.getResourcesMissingFrom(null, db);
		fetcher = new PackageFetcher();
		downloads = fetcher.extractDownloads(list);
	}

	@After
	public void tearDown() throws Exception {
		IO.delete(tempDir);
	}

	@Test
	public void downloadsAllResources() {
		fetcher.download(downloads, tempDir, new MockConnector());
		assertEquals(4, tempDir.list().length);
	}
}
