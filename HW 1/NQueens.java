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
	public boolean safe(int x, int y, int board[][], int size) {

		// a is the column(x), b is the row(y)
		// checks for horizontal attacks
		for (int a = 1; a < size; a++) {
			// returns false if something else is in the row
			if (board[x][a] != 0) {
				return false;
			}
		}
		// check diagonal attacks
		
		// check the top-left diagonal
		// loop stops if it hits the top or side of the board first
		for (int a = x, b = y; a == 0 || b == size; a--, b++) {
			if (board[a][b] != 0) {
				return false;
			}
		}
		//check the top-right diagonal
		for (int a = x, b = y; a == size || b == size; a++, b++) {
			if (board[a][b] != 0) {
				return false;
			}
		}
		//check the bot-left diagonal
		for (int a = x, b = y; a == 0 || b == 0; a--, b--) {
			if (board[a][b] != 0) {
				return false;
			}
		}
		//check the bot-right diagonal
		for (int a = x, b = y; a == size || b == 0; a++, b--) {
			if (board[a][b] != 0) {
				return false;
			}
		}
		
		//if no attacks found, return true
		return true;
	}

	public static void main(String[] args) throws IOException {

		int lineNumber = 0;

		// check number of command line arguments is at least 2
		if (args.length < 2) {
			System.out.println("Usage: java -jar NQueens.jar <input file> <output file>");
			System.exit(1);
		}
	}
}
