package usantatecla.characteristics.readable.expressive.magicNumbers.v2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class BowlingGameTest {
	
	private Game game;
	
	@Before
	public void before(){
		game = new Game();
	}
	
	@Test
	public void perfectGame() throws Exception {
		roll(pins(10), times(12));
		assertThat(game.score(), is(equalTo(300)));
	}

	private static int pins(int n) {
		return n;
	}

	private static int times(int n) {
		return n;
	}
	
	private void roll(int pins, int times) {
	}

}