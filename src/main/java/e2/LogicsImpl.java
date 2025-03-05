package e2;

public class LogicsImpl implements Logics {
	
	private final Piece pawn;
	private final Piece knight;
	private final GameMonitor gameMonitor = new GameMonitorImpl();
	private final PositionsHandler gamePositions = new PositionsHandlerImpl();
	private final int size;

    public LogicsImpl(final int size){
    	this.size = size;
        this.pawn = new PieceImpl(gamePositions.randomEmptyPosition(size));
        this.knight = new PieceImpl(gamePositions.randomKnightPosition(pawn, size));
    }

	public LogicsImpl(final Piece pawn, final Piece knight, final int size){
		this.pawn = pawn;
		this.knight = knight;
		this.size = size;
	}

	@Override
	public boolean hit(final int row, final int col) {
		gameMonitor.checkMoveIsNotOutOfBounds(row, col, size);
		if (gameMonitor.isKnightMoveValid(row, col, knight)) {
			gamePositions.setPieceNewPosition(new Pair<>(row,col), this.knight);
			return gameMonitor.checkGameOver(pawn, knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return gamePositions.isPieceOnThisPosition(knight, row, col);
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return gamePositions.isPieceOnThisPosition(pawn, row, col);
	}
}
