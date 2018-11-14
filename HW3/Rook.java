class Rook extends Chesspiece {
	public Rook(int x, int y, boolean z) {
		super(x, y, z);
	}
	
	//Pass these plates around
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