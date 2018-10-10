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
		//System.out.println("meme");

		// a is the column(x), b is the row(y)
		// checks for horizontal attacks
		for (int a = 0; a < size; a++) {
			// returns false if something else is in the row
			if (board[x][a] != 0) {
				return false;
			}
		}
		// check diagonal attacks
		
		// check the top-left diagonal
		// loop stops if it hits the top or side of the board first
		for (int a = x, b = y; a < 0 && b > size; a--, b++) {
			System.out.println(a + ", "  +b);
			if (board[a][b] != 0) {
				return false;
			}
		}
		//check the top-right diagonal
		for (int a = x, b = y; a > size && b > size; a++, b++) {
			System.out.println(a + ", "  +b);
			if (board[a][b] != 0) {
				return false;
			}
		}
		//check the bot-left diagonal
		for (int a = x, b = y; a < 0 && b < 0; a--, b--) {
			System.out.println(a + ", "  +b);
			if (board[a][b] != 0) {
				return false;
			}
		}
		//check the bot-right diagonal
		for (int a = x, b = y; a > size && b < 0; a++, b--) {
			System.out.println(a + ", "  +b);
			if (board[a][b] != 0) {
				return false;
			}
		}
		
		//if no attacks found, return true
		return true;
	}
	
	//place Queen recursive function that takes in a board array that keeps track of queens
	//and a row/col tracker integer
	public static boolean placeQueen(int board[][], int row, int col, int size)
	{
		//end case (if all columns are filled)
		if(col > size)
		{
			return true;
		}
		//i = rows
		for(int i = 1; i < size; i++)
		{
			//place a queen
			board[i][col] = 1;
			//check the placement
			if(safe(i, col, board, size) == true)
			{
				//if true; make recursive call
				placeQueen(board, row, col+1, size);
			}
			else {
				
			}
		}
		//if no queen can be placed
		return false;
	}

	public static void main(String[] args) throws IOException {

		int lineNumber = 0;

		// check number of command line arguments is at least 2
		/*if (args.length < 2) {
			System.out.println("Usage: java -jar NQueens.jar <input file> <output file>");
			System.exit(1);
		}*/
		//testing
		int[][] board = new int[][] {{0, 1, 0}, {0, 0, 0}, {0, 0, 0}};
		
		//board looks like this
		// 0 0 0
		// 0 0 0
		// 0 1 0
		System.out.println("" + board[0][1]);
		boolean koala = safe(1, 0, board, 3);
		System.out.println("" + koala);
		
	}
}
