//LinkedList of Nodes
class LinkedList {
	Node front;

	// creates a new LinkedList
	public LinkedList() {
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
				// System.out.println(head.data.toString() + compare.data.toString());
				// System.out.println("is: " + head.data.row + head.data.col + " equal to " +
				// compare.data.row + compare.data.col);
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
		// checks the end node too
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
			output = output + " " + head.data.giveName() + " (" + head.data.col + "," + head.data.row + ")";
			head = head.next;
		}
		// can't forget the last one
		output = output + " " + head.data.giveName() + " (" + head.data.col + "," + head.data.row + ")";
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

	// target is the Chesspiece you wish to delete
	public void delete(Chesspiece target) {
		Node head = front;
		// if target is the head, change front
		if (target == head.data) {
			front = front.next;
			return;
		}
		// else traverse until you find it
		while (head.next != null) {
			// System.out.println("AM I alive");
			if (head.next.data == target) {
				// if the next thing head points to is the target
				// change the next to point to target's next instead

				// if the node you are deleting is the end of the list, set next to null instead
				if (head.next.next == null) {
					// System.out.println("AM I ok");
					head.next = null;
					return;
				}
				// System.out.println("AM I dead");
				head.next = head.next.next;
				return;
			}
			head = head.next;
		}
	}

	// given an input of row/col (of a piece moving there)
	// checks then if the piece can legally move there by capturing a piece
	public boolean isOccupied(int row, int col, boolean colour) // true is white, black is false
	{
		Node head = front;
		// checks the head first
		if (head.data.row == row && head.data.col == col && head.data.colour == colour) {
			return true;
		}
		// traverse
		while (head.next != null) {
			if (head.data.row == row && head.data.col == col && head.data.colour == colour) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	// checks if a piece can make a certain move (ex. a rook can't move diagonally)
	// row and col are destination, target is the piece you are trying to move
	public boolean isLegalMove(Chesspiece target, int row, int col) {
		// creates a silly dummy pawn and tests if attacking (how lazy!)
		Chesspiece dummy = new Pawn(row, col, !target.colour);

		// checks if the move is to itself (can't do that)
		// ex: cant move from (3,3) to (3,3)
		// System.out.println("Im trying to move from " + target.row + "," + target.col
		// + " to: " + row + ", " + col);
		if (target.row == row && target.col == col) {
			return false;
		}
		if (target.isAttacking(dummy)) {
			return true;
		}
		// pawn check since pawns do things differently sometimes
		if (target.giveName() == "p" || target.giveName() == "P") {
			// white pawns move in the positive row
			if (target.colour) {
				// pawns can move 2 squares on the first move
				if (target.row == 2) {
					if (row == 3 || row == 4) {
						return true;
					}
				} else {
					if (row == target.row + 1) {
						return true;
					}
				}
			} else {
				if (target.row == 7) {
					if (row == 6 || row == 5) {
						return true;
					}
				} else {
					if (row == target.row - 1) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// checks if something is in the path of the piece as it moves to a target
	// square
	// target is the piece being moved
	// row and column are the destination of target piece
	// input assumes a legal move
	public boolean inTheWay(Chesspiece target, int row, int col) {
		// if you input the same square, returns false because
		// you cannot be in the way of yourself
		if (target.row == row && target.col == col) {
			return false;
		}
		// function ignores knights/pawns/kings
		// knights ignore blocking, pawns and kings can only attack one square away so
		// this is irrelevant
		if (target.giveName() == "n" || target.giveName() == "N" || target.giveName() == "k" || target.giveName() == "K"
				|| target.giveName() == "p" || target.giveName() == "P") {
			return false;
		}

		// keeps track of the squares the piece travels across
		int path_row = row; // destination row
		int path_col = col; // destination column
		// if moving horizontally, check the columns in the path
		if (target.row == row) {
			// check right
			if (target.col > path_col) {
				path_col++; // ignore the square you are trying to move to
				while (target.col > path_col) {

					// if a piece is not found, function returns zero, so non zero means piece
					// exists
					if (this.find(path_row, path_col) != 0) {
						return true;
					}
					path_col++;
				}
			}
			// check left
			else if (target.col < path_col) {
				path_col--; // go one less to ignore the square you are trying to move to
				// System.out.println("wheeee");
				while (target.col < path_col) {
					// System.out.println("comparing: " + target.row + target.col + " and " +
					// path_row + path_col);
					// if a piece is not found, function returns zero, so non zero means piece
					// exists
					if (this.find(path_row, path_col) != 0) {
						return true;
					}
					path_col--;
				}
			}
		}
		// check for vertical pathing
		else if (target.col == col) {
			// check up
			if (target.row > path_row) {
				path_row++;
				while (target.row > path_row) {

					// if a piece is not found, function returns zero, so non zero means piece
					// exists
					if (this.find(path_row, path_col) != 0) {
						return true;
					}
					path_row++;
				}
			}
			// check down
			else if (target.row < path_row) {
				path_col--;
				while (target.row < path_row) {
					// if a piece is not found, function returns zero, so non zero means piece
					// exists
					if (this.find(path_row, path_col) != 0) {
						return true;
					}
					path_row--;
				}
			}
		}

		// diagonal checkers
		else {
			// top left diagonal check
			if (target.row - path_row > 0 && target.col - path_col < 0) {
				path_row++;
				path_col--;
				while (target.row != path_row) {
					if (this.find(path_row, path_col) != 0) {
						return true;
					}
					path_row++;
					path_col--;
				}

			}
			// top right diagonal check
			else if (target.row - path_row > 0 && target.col - path_col > 0) {
				path_row++;
				path_col++;
				while (target.row != path_row) {
					// System.out.println("comparing " + target.row + target.col + " and " +
					// path_row + path_col);
					if (this.find(path_row, path_col) != 0) {
						return true;
					}
					path_row++;
					path_col++;
				}

			}
			// bottom left diagonal check
			else if (target.row - path_row < 0 && target.col - path_col < 0) {
				path_row--;
				path_col--;
				while (target.row != path_row) {
					// System.out.println("comparing " + target.row + target.col + " and " +
					// path_row + path_col);
					if (this.find(path_row, path_col) != 0) {
						return true;
					}
					path_row--;
					path_col--;
				}

			}
			// bottom right diagonal check
			else if (target.row - path_row > 0 && target.col - path_col < 0) {
				path_row--;
				path_col++;
				while (target.row != path_row) {
					if (this.find(path_row, path_col) != 0) {
						return true;
					}
					path_row--;
					path_col++;
				}

			}
		}
		return false;
	}

	// checks if the king is safe after a move (cannot put your own king in check)
	// returns false if not safe
	// input is the king you want to check
	public boolean kingSafe(Chesspiece king) {
		Node head = front;
		//System.out.println("memes");
		if(king == null) //why would you do this
		{
			return false;
		}
		// System.out.println(head.data.giveName() + " in the way? " +
		// !this.inTheWay(head.data, king.row , king.col));
		// check if head is attacking King AND not blocked
		if (head.data.isAttacking(king) && !this.inTheWay(head.data, king.row, king.col)) {
			return false;
		}
		// next, traverse the list like normal
		while (head.next != null) {
			// System.out.println(head.data.giveName() + " in the way? " +
			// !this.inTheWay(head.data, king.row , king.col));
			if (head.data.isAttacking(king) && !this.inTheWay(head.data, king.row, king.col)) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	// finds the king of a certain colour in a list
	// true = White, false = Black
	// there should always be a king
	// for use with isKingSafe
	public Chesspiece findKing(boolean colour) {
		Node head = front;
		
		while (head.next != null) {
			//System.out.println("looking at: " + head.data.toString());
			// checks for the name of the piece and then the colour
			if (head.data.colour == colour && (head.data.giveName() == "k" || head.data.giveName() == "K")) {
				//System.out.println("found king at: " + head.data.col + head.data.row);
				return head.data;
			}
			head = head.next;
		}
		//check the last node too
		if (head.data.colour == colour && (head.data.giveName() == "k" || head.data.giveName() == "K")) {
			//System.out.println("found king at: " + head.data.col + head.data.row);
			return head.data;
		}
		return null; // no king found? why would this happen? We're better than this
	}

	// checks if a move is legal (all parameters)
	// inputs are the piece and its destination
	public boolean canMove(Chesspiece target, int endRow, int endCol) {
		// check 1: is it a legal move (or rather, is this how your piece should move)?
		if (!this.isLegalMove(target, endRow, endCol)) {
			//System.out.println("fail here?");
			return false;
		}
		//check 2: is something in the way?
		//if true, then return false;
		if(this.inTheWay(target, endRow, endCol))
		{
			//System.out.println("or here?");
			return false;
		}
		//check 3: check for occupied square
		if(this.isOccupied(endRow, endCol, target.colour))
		{
			return false;
		}
		//check 4: is your King in check after this move?
		int tempRow = target.row;
		int tempCol = target.col;
		
		//moves the piece to the destination square
		target.row = endRow;
		target.col = endCol;
		//System.out.println("perhaps here?");
		if(!this.kingSafe(this.findKing(target.colour)))
		{
			//System.out.println("maybe here?");
			//if false, move the piece back
			target.row = tempRow;
			target.col = tempCol; 
			return false;
		}
		//passed all tests, piece can stay where it is :)
		return true;
	}
}
