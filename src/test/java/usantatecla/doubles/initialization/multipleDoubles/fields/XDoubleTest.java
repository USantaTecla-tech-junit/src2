package usantatecla.doubles.initialization.multipleDoubles.fields;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class XDoubleTest {

	@Mock
	Z z;

	@Mock
	Y y;

	@InjectMocks
	X x;

	@Before
  public void before() {
      initMocks(this);
	}
	
	@Test
	public void testM() {
		this.x.m();
	}
	
}
