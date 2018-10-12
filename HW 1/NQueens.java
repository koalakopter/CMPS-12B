
//Julian To / jcto@ucsc.edu
//CMPS 12B
//HW1: NQUEENS

import java.io.*;
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
			//System.out.println(i + ", " + col);

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
	
	//helper function that stores a local board and prints results from parsed strings
	//to be used with placeQueen function
	static void findSolution(int n, int row, int col)
	{
		//creates a 2D Array/Board of size n
		int[][] board = new int[n][n];
		board[row][col] = 1; //pre-placed queen
		
		//tests if there is a solution to the NQueens problem w/ given input
		boolean solution = placeQueen(board, col, 0,  n);
		if (solution == false)
		{
			System.out.println("No Solution");
		}
	}
	

	public static void main(String[] args) throws IOException {

		int lineNumber = 0;

		// check number of command line arguments is at least 2

		if (args.length < 2) {
			System.out.println("Usage: java -jar NQueens.jar <input file> <output file>");
			System.exit(1);
		}

		// Copied from Lab 2
		// open files
		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));

		int f = 0;
		boolean koala = true;
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
				//System.out.println("" + token[i]);
				if (koala) {
					f = Integer.parseInt(token[i+1]);
					koala = false;
				}
			}
		}
		System.out.println("help plz" + f);
		findSolution(3, 0, 0);
		/*
		 * int size = 8; 
		 * int[][] board = new int[size][size]; 
		 * board[0][3] = 1;
		 * //preplaced queen 
		 * // starts at row 0 
		 * placeQueen(board, 3, 0, size);
		 * 
		 * // prints out 2d array for visual aid 
		 * for (int i = 0; i < size; i++) 
		 * { 
		 * 	for (int j = 0; j < size; j++) 
		 * 	{ 
		 * 	System.out.print(board[i][j] + " "); 
		 * 	}
		 * 	System.out.println(); 
		 * }
		 */

	}
}
