package usantatecla.characteristics.readable.simple.snitchTest;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class DecisionTreeBoardTest {

	@Test
	public void testExistTicTacToe() {
		testExistTicTacToe(new DecisionTreeBoardBuilder()
				.setWithTicTacToeInRow(row(0), Color.XS).build(), Color.XS);
		testExistTicTacToe(new DecisionTreeBoardBuilder()
				.setWithTicTacToeInColumn(column(2), Color.OS).build(), Color.OS);
		// ...
	}
	
	private void testExistTicTacToe(DecisionTreeBoard decisionTreeBoard, Color winner) {
		assertThat("with " + decisionTreeBoard, decisionTreeBoard.complete(), is(false));
		for(Color color : new Color[] {Color.XS, Color.OS}) {
			assertThat("with " + decisionTreeBoard + " and " + color, decisionTreeBoard.existTicTacToe(color), is(winner==color));
		}
	}
	
	public static int row(int row) {
		return row;
	}
	
	public static int column(int column) {
		return column;
	}

}
