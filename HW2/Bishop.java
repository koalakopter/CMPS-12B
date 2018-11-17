class Bishop extends Chesspiece {
	public Bishop(int x, int y, boolean z) {
		super(x, y, z);
	}
	
	//This bishop isn't an Elector, unfortunately
	public String giveName() {
		if (this.colour) {
			return "b";
		} else
			return "B";
	}

	public boolean isAttacking(Chesspiece origin) {
		// bishops attack diagonally
		int a, b;
		// top right diagonal
		for (a = this.row, b = this.col; a <= 8 && b <= 8; a++, b++) {
			if (a == origin.checkRow() && b == origin.checkCol()) {
				// if the piece is the opposite colour, return true
				if (this.colour != origin.colour) {
					return true;
				}
			}
		}
		// top left diagonal
		for (a = this.row, b = this.col; a >= 0 && b <= 8; a--, b++) {
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
		for (a = this.row, b = this.col; a <= 8 && b >= 0; a++, b--) {
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