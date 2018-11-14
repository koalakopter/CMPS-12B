//JULIAN TO
//jcto@ucsc.edu
//HW2: CHESSBOARD

import java.io.*;
//import static java.lang.System.out;
import java.util.Scanner;

//main PROGRAM 
public class ChessBoard {
	// makes a chesspiece from the information provided from the input.txt file
	public static Chesspiece makePiece(String x, int row, int col) {
		// makes "x" into a char
		char c = x.charAt(0);
		boolean checkColor = Character.isUpperCase(c);
		// just a bunch of if statments....
		// make a king
		if (c == 'k' || c == 'K') {
			Chesspiece output = new King(row, col, checkColor);
			return output;
		} // make a queen
		else if (c == 'q' || c == 'Q') {
			Chesspiece output = new Queen(row, col, checkColor);
			return output;
		} // make a rook
		else if (c == 'r' || c == 'R') {
			Chesspiece output = new Rook(row, col, checkColor);
			return output;
		} // make a bishop
		else if (c == 'b' || c == 'B') {
			Chesspiece output = new Bishop(row, col, checkColor);
			return output;
		} // make a knight
		else if (c == 'n' || c == 'N') {
			Chesspiece output = new Knight(row, col, checkColor);
			return output;
		}
		// else, its a pawn or you have bad input (which there shouldn't be any of)
		Chesspiece output = new Pawn(row, col, checkColor);
		return output;
	}

	// do stuff function that builds the board out of chesspieces and makes nodes
	// and returns the final string
	public static String makeList(String input) {
		// split input around colon
		String[] split = input.split(":", 0);

		// split[0] will contain the command
		// split[1] contains the board instructions

		String[] command = split[0].split(" ", 0);
		split[1] = split[1].trim(); // trim the leading space off of the 2nd part
		// System.out.println(split[1]);
		String[] board = split[1].split(" ", 0);
		int i = 0;
		int row = 0;
		int col = 0;

		// char array to store each piece
		// 0: is piece type, 1: is row, 2: is col
		String[] loop = new String[3];
		// list that will be used
		LinkedList list = new LinkedList();
		//System.out.println("command: " + split[0]);
		// System.out.println(split[1]);
		for (String x : board) {
			x = x.trim(); // trim the spaces
			//System.out.println("input!: " + x);
			// first character denotes the type of piece
			if (i == 0) {
				loop[0] = x;
			} else if (i == 1) {
				loop[1] = x;
				// System.out.println(loop[1]);
				row = Integer.parseInt(loop[1]);
			} else if (i == 2) {
				loop[2] = x;
				col = Integer.parseInt(x);
				//System.out.println("Making this piece: " + loop[0] + row + col);
				list.addNode(makePiece(loop[0], row, col));
				i = -1; //reset the counter
			}
			i++;
		}
		//System.out.println("Your list is: " + list.print());
		// check validity
		if (!list.isValid()) {
			return "Invalid";
		}

		// finds a piece and returns the position of that piece in the list:
		int position = list.find(Integer.parseInt(command[0]), Integer.parseInt(command[1]));
		// if no piece found
		if (position == 0) {
			return "-";
		}

		Node temp = list.front; // temp head so we don't muck with other stuff
		while (temp != null) {
			// System.out.println(list.traverse(position).giveName() + " is attacking " +
			// temp.data.giveName());
			if (list.traverse(position).isAttacking(temp.data)) {
				return list.traverse(position).giveName() + " y"; // yes case
			}
			temp = temp.next;
		}
		return list.traverse(position).giveName() + " n"; // no case

		// this should never happen
		// return list.print();
	}
	public static void main(String[] args) throws IOException {

		//int lineNumber = 0;

		// check number of command line arguments is at least 2

			//String meme = "8 2: q 4 3 k 4 4 r 8 2 R 8 8 b 1 1 K 4 8 N 7 7";
			/*
			 * String[] meme2 = meme.split(" ", 0); for (String x : meme2) {
			 * System.out.println(x); }
			 */
			//System.out.println(makeList(meme));

	if(args.length<2)
	{
		System.out.println("Usage: java -jar Chessboard.jar <input file> <output file>");
		System.exit(1);
	}
	//System.out.println("Am I working?");
	// Copied from Lab 2
	// open files
	Scanner in = new Scanner(new File(args[0]));
	PrintWriter out = new PrintWriter(new FileWriter(args[1]));

	// read lines from in, extract and print tokens from each line
	while(in.hasNextLine())
	{
		// lineNumber++; //what does this even do

		// trim leading and trailing spaces, then add one trailing space so
		// split works on blank lines
		String line = in.nextLine().trim() + " ";

		// split line around white space
		String[] token = line.split("\\r?\\n\"");

		int n = token.length;

		for (int i = 0; i < n; i++) {
			//System.out.println(token[i]);
			out.println(makeList(token[i]));
		}
	}
	in.close();
	out.close();
	}	
}