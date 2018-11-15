//Julian To
//Jcto@ucsc.edu
//HW 3: ChessMoves

import java.io.*;

public class ChessMoves {
	public static void main(String[] args)
	{
		//me test me smart
		LinkedList koala = new LinkedList();
		Chesspiece one = new Rook(7, 1, false);
		Chesspiece two = new Bishop(2,2, false);
		Chesspiece three = new Queen(3,3, true);
		Chesspiece four = new Knight(6,5, true);
		Chesspiece five = new King(7,7, true);
		
		koala.addNode(one);
		koala.addNode(two);
		koala.addNode(three);
		koala.addNode(four);
		koala.addNode(five);
		
		System.out.println(koala.print());
		System.out.println(two.isAttacking(three));
		//koala.delete(four);
		//System.out.println(koala.print());
		boolean test = koala.isLegalMove(three, 6, 6);
		System.out.println("is it legal? " + test);
		System.out.println("is something in de way? " + koala.inTheWay(two, 2, 2));
		System.out.println("Is the king ok? " + koala.kingSafe(five));
		
	}
}
