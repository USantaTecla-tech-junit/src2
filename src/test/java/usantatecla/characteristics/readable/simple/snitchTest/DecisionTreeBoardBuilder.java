package usantatecla.characteristics.readable.simple.snitchTest;

import java.util.HashMap;
import java.util.Map;

public class DecisionTreeBoardBuilder {

	private Map<Coordinate, Color> pieces;

	private Turn turn;

	public DecisionTreeBoardBuilder() {
		pieces = new HashMap<Coordinate, Color>();
		turn = new Turn();
	}

	public DecisionTreeBoardBuilder setWithAlternateColor(Coordinate coordinate) {
		pieces.put(coordinate, turn.take());
		turn.change();
		return this;
	}

	public DecisionTreeBoardBuilder setWithTicTacToeInRow(int row, Color color) {
		if (color != turn.take()) {
			turn.change();
		}
		int otherRow = row > 0 ? row - 1 : 2;
		for (int i = 0; i < 3; i++) {
			this.setWithAlternateColor(new Coordinate(row, i));
			if (i != 3 - 1) {
				this.setWithAlternateColor(new Coordinate(otherRow, i));
			}
		}
		return this;
	}

	public DecisionTreeBoardBuilder setWithTicTacToeInColumn(int column, Color color) {
		if (color != turn.take()) {
			turn.change();
		}
		int otherColumn = column > 0 ? column - 1 : 2;
		for (int i = 0; i < 3; i++) {
			this.setWithAlternateColor(new Coordinate(i, column));
			if (i != 3 - 1) {
				this.setWithAlternateColor(new Coordinate(i, otherColumn));
			}
		}
		return this;
	}

	public DecisionTreeBoard build() {
		DecisionTreeBoard decisionTreeBoard = new DecisionTreeBoard();
		for (Coordinate coordinate : pieces.keySet()) {
			decisionTreeBoard.put(coordinate, pieces.get(coordinate));
		}
		return decisionTreeBoard;
	}
}
