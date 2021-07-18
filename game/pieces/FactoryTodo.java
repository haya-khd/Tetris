package tetris.game.pieces;

import java.util.Random;

import tetris.game.pieces.Piece.PieceType;
import tetris.game.pieces.PieceTodo;

public class FactoryTodo implements PieceFactory {
	private Random random;

	
	public FactoryTodo(Random r) {
		// TODO Auto-generated constructor stub
		this.random = r;
	}
	
	
	@Override
	public Piece getIPiece() {
		// TODO Auto-generated method stub
		
		Piece X = new PieceTodo(PieceType.I, 1);
		return X;
	}

	@Override
	public Piece getJPiece() {
		// TODO Auto-generated method stub
		
		Piece X = new PieceTodo(PieceType.J,1);
		return X;
	}

	@Override
	public Piece getLPiece() {
		// TODO Auto-generated method stub
		
		Piece X = new PieceTodo(PieceType.L,1);
		return X;
	}

	@Override
	public Piece getOPiece() {
		// TODO Auto-generated method stub
		
		Piece X = new PieceTodo(PieceType.O,1);
		return X;
	}

	@Override
	public Piece getSPiece() {
		// TODO Auto-generated method stub
		
		Piece X = new PieceTodo(PieceType.S,1);
		return X;
	}

	@Override
	public Piece getZPiece() {
		// TODO Auto-generated method stub
		
		Piece X = new PieceTodo(PieceType.Z,1);
		return X;
	}

	@Override
	public Piece getTPiece() {
		// TODO Auto-generated method stub
		
		Piece X = new PieceTodo(PieceType.T,1);
		return X;
	}

	@Override
	public Piece getNextRandomPiece() {
		// TODO Auto-generated method stub
		
		int n = this.random.nextInt(7);
		switch(n) {
		case 0:
			return getIPiece();
		case 1:
			return getJPiece();
		case 2:
			return getLPiece();
		case 3:
			return getOPiece();
		case 4:
			return getSPiece();
		case 5:
			return getTPiece();
		case 6:
			return getZPiece();
		}
		return null;
	}

}
