package usantatecla.doubles.initialization.multipleDoubles.locals;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class XDoubleTest {

	@Mock
	Y y;

	@Mock
	Z z;

	@InjectMocks
	private X x;

	@Before
	public void before() {
		initMocks(this);
		this.x = spy(this.x);
	}

	@Test
	public void testM() {
		doReturn(0).when(this.y).m();
		doReturn(0).when(this.z).m();
		doReturn(this.y).when(x).createY();
		doReturn(this.z).when(x).createZ();
		this.x.m();
	}

}
