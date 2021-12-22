package usantatecla.characteristics.readable.simple.snitchTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DecisionTreeBoard extends Board {

	private Color[][] colors;

	public DecisionTreeBoard() {
		colors = new Color[Coordinate.DIMENSION][Coordinate.DIMENSION];
		this.clear();
	}

	@Override
	public Color getColor(Coordinate coordinate) {
		assert coordinate != null;
		return colors[coordinate.getRow()][coordinate.getColumn()];
	}

	@Override
	boolean complete() {
		int contTokens = 0;
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (colors[i][j] != Color.NONE) {
					contTokens++;
				}
			}
		}
		return contTokens == Coordinate.DIMENSION * 2;
	}

	@Override
	boolean existTicTacToe(Color color) {
		assert color != Color.NONE;
		if (colors[1][1] == color) {
			if (colors[0][0] == color) {
				return colors[2][2] == color;
			}
			if (colors[0][2] == color) {
				return colors[2][0] == color;
			}
			if (colors[0][1] == color) {
				return colors[2][1] == color;
			}
			if (colors[1][0] == color) {
				return colors[1][2] == color;
			}
			return false;
		}
		if (colors[0][0] == color) {
			if (colors[0][1] == color) {
				return colors[0][2] == color;
			}
			if (colors[1][0] == color) {
				return colors[2][0] == color;
			}
			return false;
		}
		if (colors[2][2] == color) {
			if (colors[1][2] == color) {
				return colors[0][2] == color;
			}
			if (colors[2][1] == color) {
				return colors[2][0] == color;
			}
			return false;
		}
		return false;
	}

	@Override
	boolean empty(Coordinate coordinate) {
		assert coordinate != null;
		return colors[coordinate.getRow()][coordinate.getColumn()] == Color.NONE;
	}

	@Override
	public void put(Coordinate coordinate, Color color) {
		assert coordinate != null;
		assert color != null;
		assert color != Color.NONE;
		assert this.empty(coordinate);
		assert !this.complete();
		colors[coordinate.getRow()][coordinate.getColumn()] = color;
	}

	@Override
	void remove(Coordinate coordinate, Color color) {
		assert coordinate != null;
		assert color != null;
		assert color != Color.NONE;
		assert this.getColor(coordinate) == color;
		colors[coordinate.getRow()][coordinate.getColumn()] = Color.NONE;
	}

	@Override
	boolean full(Coordinate coordinate, Color color) {
		assert coordinate != null;
		assert color != Color.NONE;
		return colors[coordinate.getRow()][coordinate.getColumn()] == color;
	}

	@Override
	void clear() {
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				colors[i][j] = Color.NONE;
			}
		}
	}
	
	@Override
	public String toString() {
		String result = "";
		for(int i=0; i<colors.length; i++){
			for(int j=0; j<colors[i].length; j++){
				char color = '.';
				if (colors[i][j] != null) {
					color = colors[i][j].name().charAt(0);
				}
				result += color + " ";
			}
			result += " \n";
		}
		return result;
	}
	
	public void writeFile(String name){
		PrintWriter out = null;
		try {
			out = new PrintWriter(name+ ".ttt");
			for(int i=0; i<colors.length; i++){
				for(int j=0; j<colors[i].length; j++){
					out.print(colors[i][j].ordinal()+" ");
				}
				out.println();
			}
		} catch (IOException ex) {
			System.out.println("IOException al escribir:" + ex.getMessage());
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void readFile(String name){
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(name+".ttt"));
			for(int i=0; i<colors.length; i++){
				String linea = in.readLine();
				Scanner scanner = new Scanner(linea);
				for(int j=0; j<colors[i].length; j++){
					colors[i][j] = Color.values()[scanner.nextInt()];
				}
				scanner.close();
			}
		} catch (IOException ex) {
			System.out.println("IOException al leer: " + ex.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
					System.out.println("IOException al cerrar: " + ex.getMessage());
				}
			}
		}
	}
}
