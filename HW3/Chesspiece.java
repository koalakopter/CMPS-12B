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