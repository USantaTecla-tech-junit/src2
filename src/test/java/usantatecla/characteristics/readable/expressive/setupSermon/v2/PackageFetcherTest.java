package usantatecla.characteristics.readable.expressive.setupSermon.v2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
		fetcher = new PackageFetcher();
		tempDir = createTempDir("downloads");
		downloads = extractMissingDownloadsFrom("/manifest.xml");
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

	private File createTempDir(String name) {
		String systemTempDir = System.getProperty("java.io.tmpdir");
		File dir = new File(systemTempDir, name);
		dir.mkdirs();
		return dir;
	}

	private Map<Integer, Resource> extractMissingDownloadsFrom(String path) {
		PresentationStorage db = new PresentationStorage();
		PresentationList list = null;
		try {
			list = createPresentationListFrom(path);
		} catch (Exception e) {
			fail();
		}
		List<Resource> downloads = list.getResourcesMissingFrom(null, db);
		return fetcher.extractDownloads(downloads);
	}

	private PresentationList createPresentationListFrom(String path)
			throws Exception {
		PresentationList list = new PresentationList();
		list.parse(readManifestFrom(path).getDocumentElement());
		return list;
	}

	private Document readManifestFrom(String path) throws Exception {
		InputStream xml = getClass().getResourceAsStream(path);
		return XOM.parse(IO.streamAsString(xml));
	}
}