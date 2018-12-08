class Pawn extends Chesspiece {
	public Pawn(int x, int y, boolean z) {
		super(x, y, z);
	}

	//"In chess, the pawns go first" - Magneto
	public String giveName() {
		if (this.colour) {
			return "p";
		} else
			return "P";
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