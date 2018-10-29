//JULIAN TO
//jcto@ucsc.edu
//HW2: CHESSBOARD

//defines a superclass that encompasses all chesspieces
abstract class Chesspiece {
	int row, col; // every chesspiece will occupy a row/col square
	boolean colour; // determines white or black (white is true, black is false)

	// determine if the chosen piece in the argument field attacks another piece
	public abstract boolean isAttacking(Chesspiece origin);
	
	//returns a certain piece's name as a String
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
	
	public String giveName()
	{
		return "king";
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
	
	//this is da kween
	public String giveName()
	{
		return "queen";
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

	public String giveName()
	{
		return "rook";
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
	
	public String giveName()
	{
		return "bishop";
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
	
	public String giveName()
	{
		return "knight";
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
	
	public String giveName()
	{
		return "pawn";
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
		//if black, negative row direction
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
class linkedList
{
	Node front;
	//creates a new LinkedList
	public linkedList(Chesspiece piece)
	{
		front = new Node(piece);
	}
	//adds a Chesspiece to the list pointed to by the "head" input
	public void addNode(Node head, Chesspiece input)
	{
		//traverses the list until it reaches the end
		while(head.next != null)
		{
			//if at the end of the list, create linkedList item
			if(head.next == null)
			{
				Node newNode = new Node(input);
				head.next = newNode;
			}
			head.next = head;
			
		}
	}
}

//base node for linked list
class Node
{
	Chesspiece data;
	Node next;
	//constructor: takes a Chesspiece and stores it in the node
	public Node(Chesspiece input)
	{
		this.data = input;
		next = null;
	}
}

public class Chessboard {
	public static void main(String[] args) {
		/*
		System.out.println("we are good");
		Chesspiece piece1 = new Bishop(4, 4, true);
		Chesspiece piece2 = new Pawn(2, 2, false);

		boolean test = piece1.isAttacking(piece2);
		System.out.println("is this piece attacking the other piece? " + test);
		*/
		Chesspiece piece1 = new King(3,3, true);
		linkedList fun = new linkedList(piece1);
		System.out.println(piece1.giveName());
	}
}
