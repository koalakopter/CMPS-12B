class King extends Chesspiece {
	public King(int x, int y, boolean z) {
		super(x, y, z);
	}
	
	//God Save the King
	public String giveName() {
		if (this.colour) {
			return "k";
		} else
			return "K";
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