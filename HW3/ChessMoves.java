public class ChessMoves {
	public static void main(String[] args)
	{
		//me test me smart
		LinkedList koala = new LinkedList();
		Chesspiece one = new Rook(1, 1, true);
		Chesspiece two = new Bishop(2,2, false);
		Chesspiece three = new Queen(3,3, true);
		Chesspiece four = new Knight(4,3, false);
		koala.addNode(one);
		koala.addNode(two);
		koala.addNode(three);
		koala.addNode(four);
		System.out.println(koala.print());
		System.out.println(two.isAttacking(three));
		//koala.delete(four);
		//System.out.println(koala.print());
		boolean test = koala.isLegalMove(three, 6, 6);
		System.out.println("is it legal? " + test);
		System.out.println("is something in de way? " + koala.inTheWay(three, 7, 3));
		
	}
}
