//JULIAN TO
//jcto@ucsc.edu
//HW2: CHESSBOARD

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
	public linkedList(Chesspiece piece) {
		front = new Node(piece);
	}

	// adds a Chesspiece to the list pointed to by the "head" input
	public void addNode(Chesspiece input) {
		//if at the head, just slap that node right there
		Node head = front;
		if (head.next == null) {
			Node newNode = new Node(input);
			head.next = newNode;
			return;
		}
		
		//otherwise,  traverse the list until it reaches the end
		while (head.next != null) {
			// if at the end of the list, create linkedList item
			head = head.next;
		}
		//add the node at the end of the list
		Node newNode = new Node(input);
		head.next = newNode;
		return;
	}

	// checks if the chessboard is valid
	public boolean isValid() {
		Node head = front;
		Node compare;
		// two nested loop compare every single node with each other to make sure no two
		// are on the same square
		while (head.next != null) {
			compare = head.next;
			while (compare != null) {
				System.out.println(head.data.toString() + compare.data.toString());
				if (head.data.row == compare.data.row && head.data.col == compare.data.col) {
					return false;
				}
				compare = compare.next;
			}
			head = head.next;
		}
		
		return true;
	}

	// finds a certain piece on a certain square
	public String find(Node head, int row, int col) {
		while (head.next != null) {
			if (head.data.col == col && head.data.row == row) {
				// if a match is found, returns the name of the piece
				return head.data.giveName();
			}
			head = head.next;
		}
		return "-"; // no piece found
	}

	// test function to visually see what's in the list
	public String print() {
		Node head = front;
		String output = "";
		while (head.next != null) {
			output = output + " " + head.data.giveName();
			head = head.next;
		}
		//can't forget the last one
		output = output + " " + head.data.giveName();
		return output;
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

public class Chessboard {
	public static void main(String[] args) {

		System.out.println("we are good");
		Chesspiece piece1 = new Bishop(4, 4, true);
		Chesspiece piece2 = new Pawn(3, 3, false);

		boolean test = piece1.isAttacking(piece2);
		System.out.println("is this piece attacking the other piece? " + test);

		Chesspiece piece3 = new King(3, 4, true);
		Chesspiece piece4 = new Queen(5,3, false);
		linkedList fun = new linkedList(piece1);
		fun.addNode(piece2);
		fun.addNode(piece3);
		fun.addNode(piece4);
		//System.out.println(piece1.giveName());
	 	//System.out.println(fun.front.next.next.data.giveName());
		System.out.println(fun.print());
		System.out.println(fun.isValid());
	}
}
