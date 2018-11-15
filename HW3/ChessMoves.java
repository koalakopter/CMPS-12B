//Julian To
//Jcto@ucsc.edu
//HW 3: ChessMoves

import java.io.*;
import java.lang.String;

public class ChessMoves {
	//makes a chesspiece!
	public static Chesspiece makePiece(String x, int row, int col) {
		// makes "x" into a char
		char c = x.charAt(0);
		boolean checkColor = Character.isUpperCase(c);
		// just a bunch of if statments....
		// make a king
		if (c == 'k' || c == 'K') {
			Chesspiece output = new King(row, col, !checkColor);
			return output;
		} // make a queen
		else if (c == 'q' || c == 'Q') {
			Chesspiece output = new Queen(row, col, !checkColor);
			return output;
		} // make a rook
		else if (c == 'r' || c == 'R') {
			Chesspiece output = new Rook(row, col, !checkColor);
			return output;
		} // make a bishop
		else if (c == 'b' || c == 'B') {
			Chesspiece output = new Bishop(row, col, !checkColor);
			return output;
		} // make a knight
		else if (c == 'n' || c == 'N') {
			Chesspiece output = new Knight(row, col, !checkColor);
			return output;
		}
		// else, its a pawn or you have bad input (which there shouldn't be any of)
		Chesspiece output = new Pawn(row, col, checkColor);
		return output;
	}
	//does everything really
	//returns the properly formatted string
	//input is the string read from the file
	public static String makeList(String input)
	{
		//splits string around the colon
		String[] split = input.split(":", 0);

		// split[0] will contain the pieces
		// split[1] contains the moves
		split[0] = split[0].replaceAll("\\s+",""); //removes the whitespace
		split[1] = split[1].replaceAll("\\s+","");
		
		//make the board
		int i = 0; //keeps track of which character is being parsed
		String loop[] = new String[3]; //from HW2
		LinkedList list = new LinkedList(); //where all the pieces are gonna be stored
		
		for(int x = 0; x < split[0].length(); x++)
		{
			//piece type
			if(i == 0)
			{
				loop[0] = split[0].substring(x,x+1);
			}
			//row
			else if(i == 1)
			{
				loop[2] = split[0].substring(x,x+1);
			}
			//col and make piece
			else if(i == 2)
			{
				loop[1] = split[0].substring(x, x+1);
				list.addNode(makePiece(loop[0], Integer.parseInt(loop[1]), Integer.parseInt(loop[2])));
				i = -1;
			}
			i++;
		}
		
		//handles the commands (1st 2 digits represent the piece you wish to move)
		//2nd pair represent the position you wish to move it to
		i = 0; //iterator counter
		int commands[] = new int[4]; //array of ints, length 4 to hold commands
		for(int y = 0; y < split[1].length(); y++)
		{
			//System.out.println("thing being parsed: " + split[1].substring(y, y+1));
			//x coordinate of piece to move (aka the col)
			if(i == 0)
			{
				commands[0] = Integer.parseInt(split[1].substring(y, y+1));
			}
			//y coordinate (row)
			else if(i == 1)
			{
				commands[1] = Integer.parseInt(split[1].substring(y, y+1));
			}
			//x coordinate of place to move to (col)
			else if(i == 2)
			{
				commands[2] = Integer.parseInt(split[1].substring(y, y+1));
			}
			// y coordinate (row) and then check if valid move
			// if invalid, returns the invalid command + "illegal"
			else if(i == 3)
			{
				commands[3] = Integer.parseInt(split[1].substring(y, y+1));
				//this hunky if statement finds the piece at the target square
				//then sees if it can move to the destination square
				//if true, then sweet
				//if false, then illegal move
				
				System.out.println(list.print());
				System.out.println("moving " + commands[0] + commands[1] + " to " + commands[2] + commands[3]);
				if(!list.canMove(list.traverse(list.find(commands[1], commands[0])), 
						commands[3], commands[2]))
				{
					return commands[0] + " " + commands[1] + " " + commands[2] + " " +  commands[3] + " illegal";
				}
				i = -1;
			}
			i++;
		}
		//legal sequence of moves!
		return "Legal";
	}
	public static void main(String[] args)
	{
		/*
		//me test me smart
		LinkedList koala = new LinkedList();
		Chesspiece one = new Rook(6, 7, false);
		Chesspiece two = new Bishop(6,5, false);
		Chesspiece three = new Queen(4,6, false);
		Chesspiece four = new Knight(6,5, false);
		Chesspiece five = new King(7,7, true);
		Chesspiece six = new King(7,5, false);
		
		koala.addNode(one);
		koala.addNode(two);
		koala.addNode(three);
		koala.addNode(four);
		koala.addNode(five);
		koala.addNode(six);
		
		System.out.println(koala.print());
		System.out.println(two.isAttacking(three));
		//koala.delete(four);
		//boolean test = koala.isLegalMove(three, 6, 6);
		//System.out.println("is it legal? " + test);
		//System.out.println("is something in de way? " + koala.inTheWay(one, 7, 7));
		//System.out.println("Is the king ok? " + koala.kingSafe(five)); 
		System.out.println("can I move here? " + koala.canMove(six, 7,4));
		System.out.println(koala.print());
		*/
		///*
		String input = "k 1 1 r 2 1 q 3 4 B 2 4 K 5 5: 3 4 2 4 2 4 3 5";
		//input = input.replaceAll("\\s+","");
		System.out.println(makeList(input));
		//System.out.println(input.substring(20, 21));
		//*/
		
	}
}
