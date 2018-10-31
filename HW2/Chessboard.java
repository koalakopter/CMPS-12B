
//JULIAN TO
//jcto@ucsc.edu
//HW2: CHESSBOARD

import java.io.*;
import static java.lang.System.out;
import java.util.Scanner;

//defines a superclass that encompasses all chesspieces
abstract class Chesspiece {
	int row, col; // every chesspiece will occupy a row/col square
	boolean colour; // determines white or black (white is true, black is false)

	// determine if the chosen piece in the argument field attacks another piece
	public abstract boolean isAttacking(Chesspiece origin);

	// returns a certain piece's name as a String
	public abstract String giveName();

	// returns the value of the piece's row/col
	public int checkRow() {
		return this.row;
	}

	public int checkCol() {
		return this.col;
	}

	// constructor, simply assigns a piece to a place on the board
	public Chesspiece(int x, int y, boolean z) {
		this.row = x;
		this.col = y;
		this.colour = z;
	}
}

class King extends Chesspiece {
	public King(int x, int y, boolean z) {
		super(x, y, z);
	}

	public String giveName() {
		if (this.colour) {
			return "K";
		} else
			return "k";
	}

	public boolean isAttacking(Chesspiece origin) {
		// king attacks one square around itself
		// split up for debug purposes
		if ((this.row + 1 == origin.row && this.col == origin.col)
				|| (this.row - 1 == origin.row && this.col == origin.col)) {
			// if the piece is the opposite colour, return true
			if (this.colour != origin.colour) {
				return true;
			}
		}
		if ((this.col + 1 == origin.col && this.row == origin.row)
				|| (this.col - 1 == origin.col && this.row == origin.row)) {
			// if the piece is the opposite colour, return true
			if (this.colour != origin.colour) {
				return true;
			}
		}
		// diagonal attack checks
		if (((this.col + 1 == origin.col) && (this.row - 1 == origin.row || this.row + 1 == origin.row))
				|| ((this.col - 1 == origin.col) && (this.row - 1 == origin.row || this.row + 1 == origin.row))) {
			// if the piece is the opposite colour, return true
			if (this.colour != origin.colour) {
				return true;
			}
		}
		return false;
	}
}

class Queen extends Chesspiece {
	public Queen(int x, int y, boolean z) {
		super(x, y, z);
	}

	// this is da kween
	public String giveName() {
		if (this.colour) {
			return "Q";
		} else
			return "q";
	}

	public boolean isAttacking(Chesspiece origin) {
		// queens attack in all 8 directions
		if (this.row == origin.row || this.col == origin.col) {
			// if the piece is the opposite colour, return true
			if (this.colour != origin.colour) {
				return true;
			}
		}
		int a, b;
		// top right diagonal
		for (a = this.row, b = this.col; a < 8 && b < 8; a++, b++) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				// if the piece is the opposite colour, return true
				if (this.colour != origin.colour) {
					return true;
				}
			}
		}
		// top left diagonal
		for (a = this.row, b = this.col; a >= 0 && b < 8; a--, b++) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				// if the piece is the opposite colour, return true
				if (this.colour != origin.colour) {
					return true;
				}
			}
		}
		// bottom left diagonal
		for (a = this.row, b = this.col; a >= 0 && b >= 0; a--, b--) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				// if the piece is the opposite colour, return true
				if (this.colour != origin.colour) {
					return true;
				}
			}
		}
		// bottom right diagonal
		for (a = this.row, b = this.col; a < 8 && b >= 0; a++, b--) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				// if the piece is the opposite colour, return true
				if (this.colour != origin.colour) {
					return true;
				}
			}
		}
		return false;
	}
}

class Rook extends Chesspiece {
	public Rook(int x, int y, boolean z) {
		super(x, y, z);
	}

	public String giveName() {
		if (this.colour) {
			return "R";
		} else
			return "r";
	}

	public boolean isAttacking(Chesspiece origin) {
		// rooks attack in straight lines
		if (this.row == origin.row || this.col == origin.col) {
			// if the piece is the opposite colour, return true
			if (this.colour != origin.colour) {
				// if the piece is the opposite colour, return true
				if (this.colour != origin.colour) {
					return true;
				}
			}
		}

		return false;
	}
}

class Bishop extends Chesspiece {
	public Bishop(int x, int y, boolean z) {
		super(x, y, z);
	}

	public String giveName() {
		if (this.colour) {
			return "B";
		} else
			return "b";
	}

	public boolean isAttacking(Chesspiece origin) {
		// bishops attack diagonally
		int a, b;
		// top right diagonal
		for (a = this.row, b = this.col; a < 8 && b < 8; a++, b++) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				// if the piece is the opposite colour, return true
				if (this.colour != origin.colour) {
					return true;
				}
			}
		}
		// top left diagonal
		for (a = this.row, b = this.col; a >= 0 && b < 8; a--, b++) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				// if the piece is the opposite colour, return true
				if (this.colour != origin.colour) {
					return true;
				}
			}
		}
		// bottom left diagonal
		for (a = this.row, b = this.col; a >= 0 && b >= 0; a--, b--) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				// if the piece is the opposite colour, return true
				if (this.colour != origin.colour) {
					return true;
				}
			}
		}
		// bottom right diagonal
		for (a = this.row, b = this.col; a < 8 && b >= 0; a++, b--) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				// if the piece is the opposite colour, return true
				if (this.colour != origin.colour) {
					return true;
				}
			}
		}
		return false;
	}
}

class Knight extends Chesspiece {
	public Knight(int x, int y, boolean z) {
		super(x, y, z);
	}

	public String giveName() {
		if (this.colour) {
			return "N";
		} else
			return "n";
	}

	public boolean isAttacking(Chesspiece origin) {
		// knights attack in an L pattern
		// or 2 rows and 1 col OR 1 row and 2 col away

		// 2 row 1 col attack
		if ((this.row == (origin.row + 2) || (this.row == origin.row - 2))
				&& ((this.col == origin.col + 1) || (this.col == origin.col - 1))) {
			// if the piece is the opposite colour, return true
			if (this.colour != origin.colour) {
				return true;
			}
		}
		// 2 col 1 row attack
		if ((this.col == (origin.col + 2) || (this.col == origin.col - 2))
				&& ((this.row == origin.row + 1) || (this.row == origin.row - 1))) {
			// if the piece is the opposite colour, return true
			if (this.colour != origin.colour) {
				return true;
			}
		}
		return false;
	}
}

class Pawn extends Chesspiece {
	public Pawn(int x, int y, boolean z) {
		super(x, y, z);
	}

	public String giveName() {
		if (this.colour) {
			return "P";
		} else
			return "p";
	}

	public boolean isAttacking(Chesspiece origin) {
		// pawns only attack diagonlly directly in front of them (except for en passant)

		// if pawn is white, it attacks in the positive row direction
		if (this.colour == true) {
			if ((this.row + 1 == origin.row) && (this.col + 1 == origin.col || this.col - 1 == origin.col)) {
				// if the piece is the opposite colour, return true
				if (this.colour != origin.colour) {
					return true;
				}
			}
		}
		// if black, negative row direction
		else {
			if ((this.row - 1 == origin.row) && (this.col + 1 == origin.col || this.col - 1 == origin.col)) {
				// if the piece is the opposite colour, return true
				if (this.colour != origin.colour) {
					return true;
				}
			}
		}
		return false;
	}
}

//linkedList class
class linkedList {
	Node front;

	// creates a new LinkedList
	public linkedList() {
		// front = new Node(piece);
		front = null;
	}

	// adds a Chesspiece to the list pointed to by the "head" input
	public void addNode(Chesspiece input) {
		// if at the head, just slap that node right there
		Node head = front;
		if (front == null) {
			Node newNode = new Node(input);
			// head.next = newNode;
			newNode.next = null;
			// set newNode as the front
			front = newNode;
			return;
		}
		// otherwise, traverse the list until it reaches the end
		while (head.next != null) {
			// if at the end of the list, create linkedList item
			head = head.next;
		}
		// add the node at the end of the list
		Node newNode = new Node(input);
		head.next = newNode;
		return;
	}

	// checks if the chessboard is valid
	public boolean isValid() {
		Node head = front;
		Node compare = head.next;
		// two nested loop compare every single node with each other to make sure no two
		// are on the same square
		while (head != null) {
			compare = head.next;
			while (compare != null) {
				//System.out.println(head.data.toString() + compare.data.toString());
				//System.out.println("is: " + head.data.row + head.data.col + " equal to " + compare.data.row + compare.data.col);
				if (head.data.row == compare.data.row && head.data.col == compare.data.col) {
					
					return false;
				}
				compare = compare.next;
			}
			head = head.next;
		}
		return true;
	}

	// checks if a certain piece attacks any other piece
	public boolean attacks(Chesspiece input) {
		Node head = front;
		// two nested loop compare every single node with each other to make sure no two
		// are on the same square
		while (head.next != null) {
			if (input.isAttacking(head.data)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	// method that find a certain piece on a square, and then returns that piece's
	// position in the list, starting from one
	public int find(int row, int col) {
		Node head = front;
		int position = 1;
		while (head.next != null) {
			if (head.data.col == col && head.data.row == row) {
				// if a match is found, returns the position of the piece
				return position;
			}
			head = head.next;
			position++;
		}
		//checks the end node too
		if (head.data.col == col && head.data.row == row) {
			// if a match is found, returns the position of the piece
			return position;
		}
		return 0; // no piece found
	}

	// test function to visually see what's in the list
	public String print() {
		Node head = front;
		String output = "";
		while (head.next != null) {
			output = output + " " + head.data.giveName();
			head = head.next;
		}
		// can't forget the last one
		output = output + " " + head.data.giveName();
		return output;
	}

	// traverses a list to find a certain Chesspiece: for use with find
	public Chesspiece traverse(int x) {
		Node head = front;
		// System.out.println("what is head? " + head.data.giveName());
		int i = 1;
		while (head.next != null) {
			// System.out.println("is " + i + " equal to " + x);
			// System.out.println(head.data.giveName());
			if (i == x) {
				// System.out.println("who am i? " + head.data.toString());
				return head.data;
			}
			i++;
			head = head.next;
		}
		// this should really never happen if this function is used properly
		return head.data;
	}
}

//base node for linked list
class Node {
	Chesspiece data;
	Node next;

	// constructor: takes a Chesspiece and stores it in the node
	public Node(Chesspiece input) {
		this.data = input;
		next = null;
	}
}

//main PROGRAM 
public class Chessboard {
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
		linkedList list = new linkedList();
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
