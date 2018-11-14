class Knight extends Chesspiece {
	public Knight(int x, int y, boolean z) {
		super(x, y, z);
	}

	//Knight of Knights!
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