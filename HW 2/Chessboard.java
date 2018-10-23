//JULIAN TO
//jcto@ucsc.edu
//HW2: CHESSBOARD

//defines a superclass that encompasses all chesspieces
abstract class Chesspiece
{
	int row, col; //every chesspiece will occupy a row/col square
	
	//determine if the chosen piece in the argument field attacks another piece
	public abstract boolean isAttacking(Chesspiece origin);
}

class King extends Chesspiece
{
	public boolean isAttacking(Chesspiece origin)
	{
		return false;
	}
}

class Queen extends Chesspiece
{
	public boolean isAttacking(Chesspiece origin)
	{
		return false;
	}
}

class Rook extends Chesspiece
{
	public boolean isAttacking(Chesspiece origin)
	{
		return false;
	}
}

class Bishop extends Chesspiece
{
	public boolean isAttacking(Chesspiece origin)
	{
		return false;
	}
}

class Knight extends Chesspiece
{
	public boolean isAttacking(Chesspiece origin)
	{
		return false;
	}
}

class Pawn extends Chesspiece
{
	public boolean isAttacking(Chesspiece origin)
	{
		return false;
	}
}

public class Chessboard {
	public static void main(String[] args)
	{
		System.out.print("we are good");
	}
}
