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