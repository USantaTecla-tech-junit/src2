package usantatecla.doubles.initialization.multipleDoubles.parameters;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class XDoubleTest {

	@Mock
	private Y y;
	
	@Mock
	private Z z;

	@InjectMocks
	private X x;

	@Before
	public void before() {
		initMocks(this);
	}
	
	@Test
	public void testM()	{
	   this.x.m(this.y, new Y(), new Z(), this.z);
	}
	
}
