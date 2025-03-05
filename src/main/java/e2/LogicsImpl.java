package e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Piece pawn;
	private final Piece knight;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(final int size){
    	this.size = size;
        this.pawn = new PieceImpl(this.randomEmptyPosition());
        this.knight = new PieceImpl(this.randomEmptyPosition());
    }

	public LogicsImpl(final Piece pawn, final Piece knight, final int size){
		this.pawn = pawn;
		this.knight = knight;
		this.size = size;
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		checkMoveIsNotOutOfBounds(row, col);
		// Below a compact way to express allowed moves for the knight
		int x = row-this.knight.getX();
		int y = col-this.knight.getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			setPieceNewPosition(new Pair<>(row,col), this.knight);
			return this.pawn.getPosition().equals(this.knight.getPosition());
		}
		return false;
	}

	private void checkMoveIsNotOutOfBounds(int row, int col) {
		if (row <0 || col <0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
	}

	private void setPieceNewPosition(final Pair<Integer,Integer> position, final Piece piece){
		piece.setPosition(position);
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(new Pair<>(row,col));
	}
}
