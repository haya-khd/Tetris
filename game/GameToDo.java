package tetris.game;

//import java.util.Random;



import tetris.game.pieces.FactoryTodo;
import tetris.game.pieces.Piece;


public class GameToDo implements TetrisGame {
	private Piece MyPiece;
	private Board BoardHelp;
	private long totalpoints;
//	private Random r;
	private int Row;
	private int Column;
	private FactoryTodo myFactory;

	private int n; 
	private boolean testGameOver;
	private GameObserver observer;
	boolean haya;

	public GameToDo(FactoryTodo myFac, Board board) {

		this.myFactory = myFac;
		this.MyPiece = myFac.getNextRandomPiece();
		this.BoardHelp = board;
		this.totalpoints = 0;
        this.n= 0;
        this.testGameOver= false;
        this.haya= false;
	}

	@Override
	public void addObserver(GameObserver observer) {
		// TODO Auto-generated method stub
		this.observer= observer;

	}

	@Override
	public void removeObserver(GameObserver observer) {
		// TODO Auto-generated method stub
		this.observer = null;
		observer = this.observer;
		

	}

	@Override
	public Piece getCurrentPiece() {
		// TODO Auto-generated method stub

		return MyPiece;
	}

	@Override
	public Board getBoard() {
		return this.BoardHelp;
	}

	@Override
	public Piece getNextPiece() {
		// TODO Auto-generated method stub
		if(newPiece()) {
//			this.n =0;
		Piece nextPiece = this.myFactory.getNextRandomPiece();
			this.MyPiece = nextPiece;
		}
		
		return this.MyPiece;
	}

	@Override
	public int getNumberOfCompletedRows() {
		// TODO Auto-generated method stub
		int ComletedRows = 0;
		int ob= 0;
		boolean RowisFull = true;
		for (int i = BoardHelp.getNumberOfRows() - 1; i >= 0; i--) {
			for (int j = 0; j < BoardHelp.getNumberOfColumns(); j++) {
				if (BoardHelp.getBoard()[i][j] == null) {
					RowisFull = false;
					break;
				}
			}
			if (RowisFull) {
				ComletedRows++;
				ob ++;
			}
			RowisFull = true;
		}
		while(ob ==0) {
			if(this.observer != null) {
				this.observer.rowsCompleted();
			}
			ob --;
			
		}

		return ComletedRows;
	}

	@Override
	public int getPieceColumn() {
		// TODO Auto-generated method stub

		return this.Column;
	}

	@Override
	public int getPieceRow() {
		// TODO Auto-generated method stub

		return this.Row;
	}

	@Override
	public long getPoints() {
		// TODO Auto-generated method stub
	

		long X1 = 0;
		if (this.n == 1) {
			X1 = 100;
		} else {
			if (this.n == 2) {
				X1 = 300;
			} else {
				if (this.n == 3) {
					X1 = 500;
				} else {
					if (this.n == 4) {
						X1 = 1000;
					}
				}
			}
		}

		this.totalpoints += X1;
		return this.totalpoints;

	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		// do nextpiece first and then check if the Game is over or not

		if (this.testGameOver) {
			return true;
		}
		else
		{
		return false;
		}
	}

	@Override
	public boolean moveDown() {
		// TODO Auto-generated method stub
		
		
		
		boolean TrueoderFalse = true;
		try {
				if (this.BoardHelp.canRemovePiece(this.MyPiece, this.Row, this.Column)) {
				this.BoardHelp.removePiece(this.MyPiece, this.Row, this.Column);
				this.Row++;
				if (this.BoardHelp.canAddPiece(this.MyPiece, this.Row, this.Column)) {
					this.BoardHelp.addPiece(this.MyPiece, this.Row, this.Column);
					if(this.observer != null) {
						this.observer.piecePositionChanged();
					}
					TrueoderFalse &= true;
				} else {
					this.Row--;
					this.BoardHelp.addPiece(this.MyPiece, this.Row, this.Column);
					TrueoderFalse &= false;
				}
			}
		} catch (IllegalArgumentException e) {
			return false;
		}
	

		return TrueoderFalse;
	}


	@Override
	public boolean moveLeft() {
		// TODO Auto-generated method stub
		boolean TrueoderFalse = true;
		try {
			if (this.Column - 1 < 0) {
				return false;
			}
			if (this.BoardHelp.canRemovePiece(this.MyPiece, this.Row, this.Column)) {
				this.BoardHelp.removePiece(this.MyPiece, this.Row, this.Column);
				this.Column--;
				if (this.BoardHelp.canAddPiece(this.MyPiece, this.Row, this.Column)) {
					this.BoardHelp.addPiece(this.MyPiece, this.Row, this.Column);
					if(this.observer != null) {
						this.observer.piecePositionChanged();
					}
					TrueoderFalse &= true;
				} else {
					this.BoardHelp.addPiece(this.MyPiece, this.Row, this.Column++);
					TrueoderFalse &= false;
				}
			}
		} catch (IllegalArgumentException e) {
			return false;
		}
		
		

		return TrueoderFalse;

	}

	@Override
	public boolean moveRight() {
		// TODO Auto-generated method stub
		boolean TrueOderFalse = true;
		try {
			if (this.Column + 1 > this.BoardHelp.getNumberOfColumns()) {
				return false;
			}
			if (this.BoardHelp.canRemovePiece(this.MyPiece, this.Row, this.Column)) {
				this.BoardHelp.removePiece(this.MyPiece, this.Row, this.Column);
				this.Column++;
				if (this.BoardHelp.canAddPiece(this.MyPiece, this.Row, this.Column)) {
					this.BoardHelp.addPiece(this.MyPiece, this.Row, this.Column);
					TrueOderFalse &= true;
				} else {
					this.BoardHelp.addPiece(this.MyPiece, this.Row, this.Column++);
					TrueOderFalse &= false;
				}
			}
		} catch (IllegalArgumentException e) {
			return false;
		}
		if(this.observer != null) {
			this.observer.piecePositionChanged();
		}
		return TrueOderFalse;

	}

	@Override
	public boolean newPiece() {
		boolean TrueoderFalse = true;
		try {

			if (getNumberOfCompletedRows() == 0) {
//			MyPiece = getNextPiece();
				this.Row = 2;
				this.Column = BoardHelp.getNumberOfColumns() / 2;
				if (this.BoardHelp.canAddPiece(MyPiece, this.Row, this.Column)) {
					this.BoardHelp.addPiece(MyPiece, this.Row, this.Column);
					TrueoderFalse &= true;
					
				} else {
					TrueoderFalse &= false;
					this.testGameOver= true;
					setGameOver();
				}
			} else {
				this.n = this.BoardHelp.deleteCompleteRows();
				this.Row = 2;
				this.Column = BoardHelp.getNumberOfColumns() / 2;
				if (this.BoardHelp.canAddPiece(MyPiece, this.Row, this.Column)) {
					this.BoardHelp.addPiece(MyPiece, this.Row, this.Column);
					TrueoderFalse &= true;
					
				} else {
					this.testGameOver= true;
					setGameOver();
				}
			}

		} catch (IllegalArgumentException e) {
			return false;
		}
		return TrueoderFalse;
	}

	@Override
	public boolean rotatePieceClockwise() {
		// TODO Auto-generated method stub
		Piece MyPiece2 = MyPiece.getClockwiseRotation();
		boolean TrueOderFalse = true;
		
		if (this.BoardHelp.canAddPiece(MyPiece2, this.Row, this.Column)) {
			this.BoardHelp.addPiece(MyPiece2, this.Row, this.Column);
			TrueOderFalse &= true;
		} else {
			TrueOderFalse &= false;
		}

		return TrueOderFalse;
	}

	@Override
	public boolean rotatePieceCounterClockwise() {
		// TODO Auto-generated method stub
		Piece MyPiece2 = MyPiece.getCounterClockwiseRotation();
		boolean TrueoderFalse = true;
		if (this.BoardHelp.canAddPiece(MyPiece2, this.Row, this.Column)) {
			this.BoardHelp.addPiece(MyPiece2, this.Row, this.Column);
			TrueoderFalse &= true;
		} else {
			TrueoderFalse &= false;
		}
		if(this.observer != null) {
			this.observer.piecePositionChanged();
		}
		
		return TrueoderFalse;
	}

	@Override
	public void setGameOver() {
		// TODO Auto-generated method stub
       if(isGameOver()) {
    	if(observer != null) {
    		observer.gameOver();
    	}
       }
		
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
       if(getCurrentPiece() == null) {
    	   newPiece();
       }
       else {
		if (moveDown()) {}
		

        if(observer != null && haya==true) {
        
       	this.observer.pieceLanded();
        }
        haya = true;
			if (newPiece()) {
				
			}
       }
       
	
	}
	}


