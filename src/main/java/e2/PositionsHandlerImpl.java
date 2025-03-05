package e2;

import java.util.Random;

public class PositionsHandlerImpl implements PositionsHandler {

    private final Random random = new Random();

    @Override
    public void setPieceNewPosition(final Pair<Integer, Integer> position, final Piece piece){
        piece.setPosition(position);
    }

    @Override
    public final Pair<Integer,Integer> randomKnightPosition(final Piece pawn, final int size){
        Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
        return pawn!=null && pawn.getPosition().equals(pos) ? randomKnightPosition(pawn, size) : pos;
    }

    @Override
    public final Pair<Integer,Integer> randomEmptyPosition(final int size){
        return new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    }

    @Override
    public boolean isPieceOnThisPosition(final Piece piece, final int row, final int col) {
        return piece.getPosition().equals(new Pair<>(row,col));
    }
}
