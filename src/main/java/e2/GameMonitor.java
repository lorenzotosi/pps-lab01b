package e2;

public interface GameMonitor {
    void checkMoveIsNotOutOfBounds(int row, int col, int boardSize);

    boolean isKnightMoveValid(int row, int col, Piece knight);

    boolean checkGameOver(Piece pawn, Piece knight);
}
