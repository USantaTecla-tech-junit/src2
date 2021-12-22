package usantatecla.characteristics.executable.repeatable.abundantLeftoversTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;

import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TurnSharedTest {

	private static Turn OUTTurn;

	@BeforeClass
	public static void beforeClass(){
		OUTTurn = new Turn();
	}	
	
	@Test		
	public void testTurn() {
		assertEquals(Color.XS, OUTTurn.take());
	}
	
	@Test	
	public void testChange() {
		OUTTurn.change();
		assertEquals(Color.OS, OUTTurn.take());
		OUTTurn.change();
		assertEquals(Color.XS, OUTTurn.take());
		OUTTurn.change();
		assertEquals(Color.OS, OUTTurn.take());
		OUTTurn.change();
		assertEquals(Color.XS, OUTTurn.take());
	}
	
}
