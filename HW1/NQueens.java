//Julian To / jcto@ucsc.edu
//CMPS 12B
//HW1: NQUEENS

//What it does:
//Taking an input of a text file, it takes in 3 numbers: size of chessboard, 
//and the row and column of the first queen
//It then outputs the results in an output file, in the format <

import java.io.*;
import static java.lang.System.out;
import java.util.Scanner;

//places queens from col 1 -> col N
public class NQueens {

	// checks if a queen is attacking another queen
	// takes in the x and y co-ordinate of the queen to be placed, and a 2D array
	// representing the board
	// also takes in the size of the board
	public static boolean safe(int x, int y, int board[][], int size) {
		// System.out.println("meme");

		// a is the column(x), b is the row(y)
		// checks for horizontal attacks
		for (int a = 0; a < size; a++) {
			// System.out.println(x + ", " + a);
			// returns false if something else is in the row
			if (board[x][a] != 0) {
				return false;
			}
		}
		// check diagonal attacks
		// System.out.println("diagonals");

		// check the top-left diagonal
		// loop stops if it hits the top or side of the board first
		for (int a = x, b = y; a > -1 && b < size; a--, b++) {
			// System.out.println(a + ", " +b);
			if (board[a][b] != 0) {
				return false;
			}
		}
		// check the top-right diagonal
		for (int a = x, b = y; a < size && b < size; a++, b++) {
			// System.out.println(a + ", " +b);
			if (board[a][b] != 0) {
				return false;
			}
		}
		// check the bot-left diagonal
		for (int a = x, b = y; a > -1 && b > -1; a--, b--) {
			// System.out.println(a + ", " +b);
			if (board[a][b] != 0) {
				return false;
			}
		}
		// check the bot-right diagonal
		for (int a = x, b = y; a < size && b > -1; a++, b--) {
			// System.out.println(a + ", " +b);
			if (board[a][b] != 0) {
				return false;
			}
		}

		// if no attacks found, return true
		// System.out.println("pass");
		return true;
	}

	// place Queen recursive function that takes in a board array that keeps track
	// of queens
	// with a column tracker, and an input for the already placed queen
	public static boolean placeQueen(int board[][], int placedCol, int col, int size) {
		// int[][] tempBoard = new int[size][size];
		// end case (if all columns are filled)
		if (col >= size) {
			return true;
		}
		// ignores placing a queen in the column with the pre-placed queen
		if (col == placedCol) {
			col = col + 1;
		}
		// i = rows
		for (int i = 0; i < size; i++) {
			// System.out.println(i + ", " + col);

			// check the placement of a queen in a theoretical spot
			if (safe(i, col, board, size) == true) {
				// place the queen in a copy of board just in case we need to backtrack...
				// tempBoard = board;
				board[i][col] = 1;
				// if true; make recursive call
				if (placeQueen(board, placedCol, col + 1, size) == true) {
					return true;
				}
				// no queen can be placed so...? remove that queen
				board[i][col] = 0;
			}
		}
		// if no queen can be placed in a column
		return false;
	}

	// helper function that stores a local board and prints results from parsed
	// strings
	// to be used with placeQueen function
	static String findSolution(int n, int row, int col) 
	{
		String answer = "";
		// creates a 2D Array/Board of size n
		int[][] board = new int[n][n];

		// subtract one from row/col since arrays start at 0
		row--;
		col--;
		board[row][col] = 1; // pre-placed queen

		// tests if there is a solution to the NQueens problem w/ given input
		boolean solution = placeQueen(board, col, 0, n);
		if (solution == false) {
			answer = "No solution";
			return answer;
		} else {
			// if there is a solution, print out the results from col 1->N

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 1) {
						// its +1 for all results since arrays start at 0
						answer = (answer + (i + 1) + " " + (j + 1) + " ");
					}
				}
			}
			 // new line to keep format correct
		}
		return answer; //returns the solution
	}

	public static void main(String[] args) throws IOException {

		//int lineNumber = 0;

		// check number of command line arguments is at least 2

		if (args.length < 2) {
			System.out.println("Usage: java -jar NQueens.jar <input file> <output file>");
			System.exit(1);
		}

		// Copied from Lab 2
		// open files
		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));

		// array to store values from parsing
		int parse[] = new int[3];
		int answer[] = new int[3];
		int x = 0;

		// read lines from in, extract and print tokens from each line
		while (in.hasNextLine()) {
			// lineNumber++; //what does this even do

			// trim leading and trailing spaces, then add one trailing space so
			// split works on blank lines
			String line = in.nextLine().trim() + " ";

			// split line around white space
			String[] token = line.split("\\s+");

			int n = token.length;

			for (int i = 0; i < n; i++) {
				// while(token.charAt(i) != " ");
				// System.out.println("" + token[i]);
				parse[x] = Integer.parseInt(token[i]);
				//System.out.println("" + parse[x]);
				x++;
				if (x == 3) {
					x = 0;
					// if 3 values have been read in, find a solution
					// size, col, row
					out.println(findSolution(parse[0], parse[1], parse[2]));
				}
			}
		}
		in.close();
		out.close();
	}
	// System.out.println("help plz" + f);
	// findSolution(7,3,2);
	/*
	 * int size = 8; int[][] board = new int[size][size]; board[0][3] = 1;
	 * //preplaced queen // starts at row 0 placeQueen(board, 3, 0, size);
	 * 
	 * // prints out 2d array for visual aid for (int i = 0; i < size; i++) { for
	 * (int j = 0; j < size; j++) { System.out.print(board[i][j] + " "); }
	 * System.out.println(); }
	 */
	// close files

}
