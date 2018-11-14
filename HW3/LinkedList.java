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
				//System.out.println(head.data.toString() + compare.data.toString());
				//System.out.println("is: " + head.data.row + head.data.col + " equal to " + compare.data.row + compare.data.col);
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
		//checks the end node too
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
			output = output + " " + head.data.giveName();
			head = head.next;
		}
		// can't forget the last one
		output = output + " " + head.data.giveName();
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
	//target is the Chesspiece you wish to delete
	public void delete(Chesspiece target)
	{
		Node head = front; 
		//if target is the head, change front
		if (target == head.data)
		{
			front = front.next;
			return;
		}
		//else traverse until you find it
		while (head.next != null)
		{
			//System.out.println("AM I alive");
			if(head.next.data == target)
			{
				//if the next thing head points to is the target
				//change the next to point to target's next instead
				
				//if the node you are deleting is the end of the list, set next to null instead
				if(head.next.next == null)
				{
					//System.out.println("AM I ok");
					head.next = null;
					return;
				}
				//System.out.println("AM I dead");
				head.next = head.next.next;
				return;
			}
			head = head.next;
		}
	}
	
	//given an input of row/col (of a piece moving there)
	//checks then if the piece can legally move there 
	public boolean isOccupied(int row, int col, boolean colour) //true is white, black is false
	{
		Node head = front;
		//checks the head first
		if(head.data.row == row && head.data.col == col && head.data.colour == colour)
		{
			return true;
		}
		//traverse
		while(head.next != null)
		{
			if(head.data.row == row && head.data.col == col && head.data.colour == colour)
			{
				return true;
			}
			head = head.next;
		}
		return false;
	}
	
	//checks if a piece can make a certain move (ex. a rook can't move diagonally)
	//row and col are destination, target is the piece you are trying to move
	public boolean isLegalMove(Chesspiece target, int row, int col)
	{
		//creates a silly dummy pawn and tests if attacking (how lazy!)
		Chesspiece dummy = new Pawn(row, col, !target.colour);
		if (target.isAttacking(dummy))
		{
			return true;
		}
		return false;
	}
}