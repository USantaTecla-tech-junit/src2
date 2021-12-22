package usantatecla.characteristics.readable.expressive.magicNumbers.v1;

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
		roll(10, 12); // magic
		assertThat(game.score(), is(equalTo(300)));
	}

	private void roll(int i, int j) {		
	}
}
