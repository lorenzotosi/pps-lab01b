package e2;

public interface PositionsHandler {
    void setPieceNewPosition(Pair<Integer, Integer> position, Piece piece);

    Pair<Integer,Integer> randomKnightPosition(Piece pawn, int size);

    Pair<Integer,Integer> randomEmptyPosition(int size);

    boolean isPieceOnThisPosition(Piece piece, int row, int col);
}
