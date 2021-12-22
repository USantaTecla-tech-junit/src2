package usantatecla.characteristics.executable.independent.hiddenDependencieTest;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class DecisionTreeBoardTest {

	@Test
	public void testWriteFile() {
		String path = "D:\\Dropbox\\Code\\pruebasUnitariasConJMockit\\data\\prueba";
		DecisionTreeBoard decisionTreeBoard = new DecisionTreeBoard();
		decisionTreeBoard.put(new Coordinate(1, 1), Color.XS);
		decisionTreeBoard.put(new Coordinate(2, 2), Color.OS);
		decisionTreeBoard.put(new Coordinate(1, 2), Color.XS);
		decisionTreeBoard.writeFile(path);
		int[][] recorded = readFile(path);
		int[][] expected = new int[][] { { 2, 2, 2, }, { 2, 0, 0, }, { 2, 2, 1, }, };
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				assertEquals("" + i + "-" + j, expected[i][j], recorded[i][j]);
			}
		}
	}

	private int[][] readFile(String path) {
		int[][] recorded = new int[3][3];
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(path + ".ttt"));
			for (int i = 0; i < 3; i++) {
				Scanner scanner = new Scanner(in.readLine());
				for (int j = 0; j < 3; j++) {
					recorded[i][j] = scanner.nextInt();
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
		return recorded;
	}

}
