//Julian To / jcto@ucsc.edu
//CMPS 12B
//HW1: NQUEENS

//What it does:
//Taking an input of a text file, it takes in 3 numbers: size of chessboard, 
//and the row and column of the first queen
//It then outputs the results in an output file, in the format <

import java.io.*;
import java.util.*; //for stacks
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
		// System.out.println("Recursive call! " + col);

		if (col >= size) {
			return true;
		}
		// ignores placing a queen in the column with the pre-placed queen
		if (col == placedCol) {
			col = col + 1;
			if (col >= size) {
				return true;
			}
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
		/*
		 * for (int i = 0; i < size; i++) { for (int j = 0; j < size; j++) {
		 * System.out.print(board[i][j] + " "); } System.out.println(); }
		 * System.out.println("Returning false");
		 */
		return false;
	}

	// helper function that stores a local board and prints results from parsed
	// strings
	// to be used with placeQueen function
	static String findSolution(int n, int row, int col) {
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
		return answer; // returns the solution
	}
	
	//the NEW AND IMPROVED NQUEENS findSolution, 
	//takes in a string, parses it to find a solution
	//input is of the form 6 5 2 3 3
	//where the first number is the size of the board
	//and all subsequent pairs of numbers are pre-placed queens
	static String findSolution_v2 (String input)
	{
		String solution = "";
		//parse the input, splits string up after every space
		String[] parse = input.split(" ");
		int count = 0; 
		int boardSize = 0;
		//arrayLists for storing placed queens
		//int[] col = new int[13]; //max board size is 13
		//int[] row = new int[13];
		List<Integer> col = new ArrayList<>();
		List<Integer> row = new ArrayList<>();
		int queensToPlace = 0; //keeps track of how many queens need to be placed
		for (String x : parse)
		{
			//reads the size of the board
			if(count == 0)
			{
				boardSize = Integer.parseInt(x);
				queensToPlace = boardSize; 
				count = 1;
				continue;
			}
			//column of placed queen
			else if(count == 1)
			{
				col.add(Integer.parseInt(x));
				count = 2;
				continue;
			}
			//row of placed queen
			else if(count == 2)
			{
				row.add(Integer.parseInt(x));
				count = 1;
				queensToPlace--; //for every queen added to the board, need to place one less queen
				continue;
			}
		}
		
		//create the board
		int[][] board = new int[boardSize][boardSize];
		//add queens to the board
		for(int x = 0; x < col.size(); x++)
		{
			//its minus one because arrays start at zero
			board[col.get(x)][row.get(x)] = 1;//add queens to board
		}
		board[0][0] = 1;
		//solution = print(board, boardSize);
		
		return solution;
	}
	//solves NQueens using stacks
	//input: a board with some preplaced queens, size of board, and the columns of preplaced queens
	//output: a solved board (2-d arrays with 1's and 0's
	public static int[][] placeQueenStack(int[][] board, int size, ArrayList<Integer> col)
	{
		//make a stack
		Stack s = new Stack();
		int[][] output = board;
		
		
		return output;
	}
	
	
	//prints a visualization of the board
	public static String print(int[][] board, int boardSize)
	{
		String output = "";
		//prints the board for checking
		for(int i = boardSize - 1; i >= 0; i--)
		{
			for (int j = 0;  j < boardSize; j++)
			{
				output = output + board[i][j] + " ";
			}
			output = output + "\n";
		}
		return output;
	}

	public static void main(String[] args) throws IOException {

		// int lineNumber = 0;

		// check number of command line arguments is at least 2

	/*	
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

			/* OLD CODE FROM LAB 1
			for (int i = 0; i < n; i++) {
				// while(token.charAt(i) != " ");
				// System.out.println("" + token[i]);
				parse[x] = Integer.parseInt(token[i]);
				//System.out.println("" + parse[X]);
				x++;
				if (x == 3) {
					x = 0;
					// if 3 values have been read in, find a solution
					// size, col, row
					out.println(findSolution(parse[0], parse[1], parse[2]));
				}
			}
			
		}
		// close files
		in.close();
		out.close();
	}
	*/
		 
		
		// TESTING CORNER
		String input = "11 4 4 6 3";
		System.out.println(findSolution_v2(input));
	}
}

