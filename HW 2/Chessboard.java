//JULIAN TO
//jcto@ucsc.edu
//HW2: CHESSBOARD

//defines a superclass that encompasses all chesspieces
abstract class Chesspiece {
	int row, col; // every chesspiece will occupy a row/col square

	// determine if the chosen piece in the argument field attacks another piece
	public abstract boolean isAttacking(Chesspiece origin);

	// returns the value of the piece's row/col
	public int checkRow() {
		return this.row;
	}

	public int checkCol() {
		return this.col;
	}

	// constructor, simply assigns a piece to a place on the board
	public Chesspiece(int x, int y) {
		this.row = x;
		this.col = y;
	}
}

class King extends Chesspiece {
	public King(int x, int y) {
		super(x, y);
	}

	public boolean isAttacking(Chesspiece origin) {
		// king attacks one square around itself
		// split up for debug purposes
		if ((this.row + 1 == origin.row && this.col == origin.col)
				|| (this.row - 1 == origin.row && this.col == origin.col)) {
			return true;
		}
		if ((this.col + 1 == origin.col && this.row == origin.row)
				|| (this.col - 1 == origin.col && this.row == origin.row)) {
			return true;
		}
		// diagonal attack checks
		if (((this.col + 1 == origin.col) && (this.row - 1 == origin.row || this.row + 1 == origin.row))
				|| ((this.col - 1 == origin.col) && (this.row - 1 == origin.row || this.row + 1 == origin.row))) {
			return true;
		}
		return false;
	}
}

class Queen extends Chesspiece {
	public Queen(int x, int y) {
		super(x, y);
	}

	public boolean isAttacking(Chesspiece origin) {
		//queens attack in all 8 directions
		if (this.row == origin.row || this.col == origin.col) {
			return true;
		}
		int a, b;
		// top right diagonal
		for (a = this.row, b = this.col; a < 8 && b < 8; a++, b++) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				return true;
			}
		}
		// top left diagonal
		for (a = this.row, b = this.col; a >= 0 && b < 8; a--, b++) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				return true;
			}
		}
		// bottom left diagonal
		for (a = this.row, b = this.col; a >= 0 && b >= 0; a--, b--) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				return true;
			}
		}
		// bottom right diagonal
		for (a = this.row, b = this.col; a < 8 && b >= 0; a++, b--) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				return true;
			}
		}
		return false;
	}
}

class Rook extends Chesspiece {
	public Rook(int x, int y) {
		super(x, y);
	}

	public boolean isAttacking(Chesspiece origin) {
		// rooks attack in straight lines
		if (this.row == origin.row || this.col == origin.col) {
			return true;
		}

		return false;
	}
}

class Bishop extends Chesspiece {
	public Bishop(int x, int y) {
		super(x, y);
	}

	public boolean isAttacking(Chesspiece origin) {
		// bishops attack diagonally
		int a, b;
		// top right diagonal
		for (a = this.row, b = this.col; a < 8 && b < 8; a++, b++) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				return true;
			}
		}
		// top left diagonal
		for (a = this.row, b = this.col; a >= 0 && b < 8; a--, b++) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				return true;
			}
		}
		// bottom left diagonal
		for (a = this.row, b = this.col; a >= 0 && b >= 0; a--, b--) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				return true;
			}
		}
		// bottom right diagonal
		for (a = this.row, b = this.col; a < 8 && b >= 0; a++, b--) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				return true;
			}
		}
		return false;
	}
}

class Knight extends Chesspiece {
	public Knight(int x, int y) {
		super(x, y);
	}

	public boolean isAttacking(Chesspiece origin) {
		return false;
	}
}

class Pawn extends Chesspiece {
	public Pawn(int x, int y) {
		super(x, y);
	}

	public boolean isAttacking(Chesspiece origin) {
		// pawns only attack diagonlly directly in front of them (except for en passant
		// lol)
		if ((this.row + 1 == origin.row) && (this.col + 1 == origin.col || this.col - 1 == origin.col)) {
			return true;
		}
		return false;
	}
}

public class Chessboard {
	public static void main(String[] args) {
		System.out.print("we are good");
	}
}
