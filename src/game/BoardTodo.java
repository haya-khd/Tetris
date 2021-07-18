package tetris.game;

import tetris.game.pieces.Piece;

import tetris.game.pieces.Piece.PieceType;
import tetris.game.pieces.Point;

public class BoardTodo implements Board {
	private PieceType[][] myBoard;
	private int Row;
	private int Column;

	public BoardTodo(int row, int column) {
		// TODO Auto-generated constructor stub
		this.Row = row;
		this.Column = column;
		this.myBoard = new PieceType[row][column];
	}

	@Override
	public PieceType[][] getBoard() {
		// TODO Auto-generated method stub

		return this.myBoard;
	}

	@Override
	public int getNumberOfRows() {
		// TODO Auto-generated method stub
		return this.Row;
	}

	@Override
	public int getNumberOfColumns() {
		// TODO Auto-generated method stub
		return this.Column;
	}

	@Override
	public void addPiece(Piece piece, int row, int column) {
		// TODO Auto-generated method stub
		if (canAddPiece(piece, row, column)) {
			Point getpoint = piece.getRotationPoint();
			boolean[][] bodyPoint = piece.getBody();
			int w = piece.getWidth();
			int h = piece.getHeight();
			int r = getpoint.getRow();
			int c = getpoint.getColumn();
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (bodyPoint[i][j]) {
						int i1 = i - r + row;
						int j1 = j - c + column;
						this.myBoard[i1][j1] = piece.getPieceType();
					}
				}
			}
		} else {
			throw new IllegalArgumentException();
		}

	}

	@Override
	public boolean canAddPiece(Piece piece, int row, int column) {
		// TODO Auto-generated method stub
		if (row >= this.Row || column >= this.Column || piece == null) {
			return false;
		}

//		Point getpoint = piece.getRotationPoint(); // Find the Rotation Point
		boolean TrueOderFalse = true; // Help function
		boolean[][] bodyPoint = piece.getBody(); // get the Body of the current Piece
		int w = piece.getWidth(); // get the Width of the current Piece
		int h = piece.getHeight(); // get the Height of the current Piece
		int r = piece.getRotationPoint().getRow(); // Find the Row of the current Rotation Point
		int c = piece.getRotationPoint().getColumn(); // Find the Column of the current Rotation Point

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (bodyPoint[i][j]) {
					int i1 = i - r + row;
					int j1 = j - c + column;
					if (i1 < 0 || j1 < 0 || i1 >= myBoard.length || j1 >= myBoard[0].length) {
						TrueOderFalse &= false;
						break;
					} else {

						if (this.myBoard[i1][j1] == null) {
							TrueOderFalse &= true;
						} else {
							TrueOderFalse &= false;
						}
					}
				}
			}

		}
		return TrueOderFalse;

	}

	@Override
	public void removePiece(Piece piece, int row, int column) {
		// TODO Auto-generated method stub
		if (canRemovePiece(piece, row, column)) {
			Point getpoint = piece.getRotationPoint();
//			boolean[][] bodyPoint = piece.getBody();
			int w = piece.getWidth();
			int h = piece.getHeight();
			int X1 = getpoint.getRow();
			int Y1 = getpoint.getColumn();
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {

					int i1 = i - X1 + row;
					int j1 = j - Y1 + column;
					this.myBoard[i1][j1] = null;
				}
			}
		} else {
			throw new IllegalArgumentException();
		}

	}

	@Override
	public boolean canRemovePiece(Piece piece, int row, int column) {
		// TODO Auto-generated method stub
		if (row >= this.Row || column >= this.Column || piece == null) {
			return false;
		}
		Point getpoint = piece.getRotationPoint();
		boolean TrueoderFalse = true;
		boolean[][] bodyPoint = piece.getBody();
		int w = piece.getWidth();
		int h = piece.getHeight();
		int X1 = getpoint.getRow();
		int Y1 = getpoint.getColumn();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (bodyPoint[i][j]) {
					int i1 = i - X1 + row;
					int j1 = j - Y1 + column;
					if (i1 < 0 || j1 < 0 || i1 >= myBoard.length || j1 >= myBoard[0].length) {
						return false;
					} else {
						if (this.myBoard[i1][j1] != null) {
							TrueoderFalse &= true;
						} else {
							TrueoderFalse &= false;
						}
					}
				}
			}
		}
		return TrueoderFalse;
	}

	@Override
	public int deleteCompleteRows() {

		int letzte = 4;

		int ergenbniss = 0;

		int reihe = Row - 1;

		for (int r = 0; r < Row; r++) {
			boolean pass = true;
			for (int i = 0; i < Column; i++) {
				if (myBoard[reihe][i] == null) {
					pass = false;
					break;
				} else {
					pass &= true;
				}
			}

			if (pass) {
				for (int i = 0; i < Column; i++) {
					myBoard[reihe][i] = null;
				}
				if (letzte == 0) {
					break;
				}
				for (int j = 0; j < Column; j++) {
					myBoard[reihe][j] = myBoard[reihe - 1][j];
				}

				for (int i = reihe - 1; i > 0; i--) {
					for (int j = 0; j < Column; j++) {
						myBoard[i][j] = myBoard[i - 1][j];
						if (i == 1) {
							myBoard[0][j] = null;
						}
					}
					if (i == 1) {
						break;
					}
				}

				ergenbniss++;
				letzte--;
			} else {
				reihe--;

			}

		}
		return ergenbniss;
	}

	@Override
	public Board clone() {
		// TODO Auto-generated method stub
		Board copyBoard = null;
		copyBoard = new BoardTodo(this.Row, this.Column);
		return copyBoard;
	}

}
