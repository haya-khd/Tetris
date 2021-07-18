package tetris.game.pieces;

public class PieceTodo implements Piece {

	private boolean[][] PieceBody;
	private Point myPoint;
	private PieceType pices;
	
	private int Rotationtime;

	boolean[][] I_1 = { { true }, { true }, { true }, { true } };
	boolean[][] I_2 = { { true, true, true, true } };

	boolean[][] J_1 = { { false, true }, { false, true }, { true, true } };
	boolean[][] J_2 = { { true, false, false }, { true, true, true } };
	boolean[][] J_3 = { { true, true }, { true, false }, { true, false } };
	boolean[][] J_4 = { { true, true, true }, { false, false, true } };

	boolean[][] L_1 = { { true, false }, { true, false }, { true, true } };
	boolean[][] L_2 = { { true, true, true }, { true, false, false } };
	boolean[][] L_3 = { { true, true }, { false, true }, { false, true } };
	boolean[][] L_4 = { { false, false, true }, { true, true, true } };

	boolean[][] O_0 = { { true, true }, { true, true } };

	boolean[][] S_1 = { { false, true, true }, { true, true, false } };
	boolean[][] S_2 = { { true, false }, { true, true }, { false, true } };

	boolean[][] T_1 = { { true, true, true }, { false, true, false } };
	boolean[][] T_2 = { { false, true }, { true, true }, { false, true } };
	boolean[][] T_3 = { { false, true, false }, { true, true, true } };
	boolean[][] T_4 = { { true, false }, { true, true }, { true, false } };

	boolean[][] Z_1 = { { true, true, false }, { false, true, true } };
	boolean[][] Z_2 = { { false, true }, { true, true }, { true, false } };

	public PieceTodo(PieceType X, int Rotationtime) {
		this.pices = X;
		this.Rotationtime = Rotationtime;
		switch (X) {
		case I:
			switch (Rotationtime) {
			case 1:
				PieceBody = this.I_1;

				this.myPoint = new Point(1, 0);
				break;
			case 2:
				PieceBody = this.I_2;

				this.myPoint = new Point(0, 2);
				break;
			case 3:
				PieceBody = this.I_1;

				this.myPoint = new Point(2, 0);
				break;
			case 4:
				PieceBody = this.I_2;

				this.myPoint = new Point(0, 1);
				break;
			}
			break;
		case J:
			switch (Rotationtime) {
			case 1:
				PieceBody = J_1;
				this.myPoint = new Point(1, 1);
				break;
			case 2:
				PieceBody = J_2;

				this.myPoint = new Point(1, 1);
				break;
			case 3:
				PieceBody = J_3;

				this.myPoint = new Point(1, 0);
				break;
			case 4:
				PieceBody = J_4;

				this.myPoint = new Point(0, 1);
				break;
			}
           break;
		case L:
			switch (Rotationtime) {

			case 1:
				PieceBody = this.L_1;

				this.myPoint = new Point(1, 0);
				break;
			case 2:
				PieceBody = this.L_2;

				this.myPoint = new Point(0, 1);
				break;
			case 3:
				PieceBody = L_3;

				this.myPoint = new Point(1, 1);
				break;
			case 4:
				PieceBody = L_4;

				this.myPoint = new Point(1, 1);
				break;
			}
			break;
		case O:
			switch (Rotationtime) {

			case 1:
				PieceBody = O_0;
				
				this.myPoint = new Point(1, 1);
				break;
			case 2:
				PieceBody = O_0;

				this.myPoint = new Point(1, 0);
				break;
			case 3:
				PieceBody = O_0;

				this.myPoint = new Point(0, 0);
				break;
			case 4:
				PieceBody = O_0;

				this.myPoint = new Point(0, 1);
				break;
			}
			break;
		case S:
			switch (Rotationtime) {
			case 1:

				PieceBody = S_1;

				this.myPoint = new Point(1, 1);
				break;
			case 2:
				PieceBody = S_2;

				this.myPoint = new Point(1, 0);
				break;
			case 3:
				PieceBody = S_1;

				this.myPoint = new Point(0, 1);
				break;
			case 4:
				PieceBody = S_2;

				this.myPoint = new Point(1, 1);
				break;
			}
         break;
		case T:
			switch (Rotationtime) {
			case 1:
				PieceBody = T_1;

				this.myPoint = new Point(0, 1);
				break;
			case 2:
				PieceBody = T_2;
				this.myPoint = new Point(1, 1);
				break;
			case 3:
				PieceBody = T_3;

				this.myPoint = new Point(1, 1);
				break;
			case 4:
				PieceBody = T_4;

				this.myPoint = new Point(1, 0);
				break;

			}
        break;
		case Z:
			switch (Rotationtime) {
			case 1:
				PieceBody = Z_1;

				this.myPoint = new Point(1, 1);
				break;
			case 2:
				PieceBody = Z_2;

				this.myPoint = new Point(1, 0);
				break;
			case 3:
				PieceBody = Z_1;

				this.myPoint = new Point(0, 1);
				break;
			case 4:
				PieceBody = Z_2;

				this.myPoint = new Point(1, 1);
				break;

			}
			break;

		}

	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub

		return this.PieceBody[0].length;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub

		return this.PieceBody.length;
	}

	@Override
	public boolean[][] getBody() {
		// TODO Auto-generated method stub
		return this.PieceBody;
	}

	@Override
	public Piece getClockwiseRotation() {
		// TODO Auto-generated method stub

		PieceType myPieceType = getPieceType();
		switch (this.Rotationtime) {
		case 1:
			Piece newPiece = new PieceTodo(myPieceType, 2);
			return newPiece;

		case 2:
			Piece newPiece1 = new PieceTodo(myPieceType, 3);
			return newPiece1;

		case 3:
			Piece newPiece2 = new PieceTodo(myPieceType, 4);
			return newPiece2;

		case 4:
			Piece newPiece3 = new PieceTodo(myPieceType, 1);
			return newPiece3;

		}
		return null;
	}

	@Override
	public Piece getCounterClockwiseRotation() {
		// TODO Auto-generated method stub
		PieceType myPieceType = getPieceType();
		switch (this.Rotationtime) {
		case 1:
			Piece newPiece = new PieceTodo(myPieceType, 4);
			return newPiece;
			
		case 2:
			Piece newPiece1 = new PieceTodo(myPieceType, 1);
			return newPiece1;
		case 3:
			Piece newPiece2 = new PieceTodo(myPieceType, 2);
			return newPiece2;
		case 4:
			Piece newPiece3 = new PieceTodo(myPieceType, 3);
			return newPiece3;
		}
		return null;
	}



	@Override
	public boolean equals(Object pieceEquals) {
		// TODO Auto-generated method stub
		if (!(pieceEquals instanceof PieceTodo)) {
			return false;
		}
        Piece pEquals = (Piece) pieceEquals;
		
		if (this.getHeight() != (pEquals.getHeight()) || this.getWidth() != (pEquals.getWidth())){
			return false;
		}
		for (int i= 0; i < this.getHeight() ; i++) {
			for(int j=0; j< this.getWidth(); j++) {
				if(this.getBody()[i][j] != pEquals.getBody()[i][j]) {
					return false;
				}
			}
		}
		if (this.pices != pEquals.getPieceType()) {
			return false;
		}
		if (this.getRotationPoint().getColumn() != pEquals.getRotationPoint().getColumn() || 
				this.getRotationPoint().getRow() != pEquals.getRotationPoint().getRow() ) {
			return false;
		}
		
		
		return true;
		

	}

	@Override
	public Point getRotationPoint() {
		// TODO Auto-generated method stub
		return this.myPoint;
	}

	@Override
	public PieceType getPieceType() {
		// TODO Auto-generated method stub
		return this.pices;
	}

	@Override
	public Piece clone() {
		// TODO Auto-generated method stub

		Piece copyCLone = null;
		copyCLone = new PieceTodo(pices, Rotationtime);

		return copyCLone;
	}

}
