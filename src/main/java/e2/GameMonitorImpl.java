package e2;

public class GameMonitorImpl implements GameMonitor {

    @Override
    public void checkMoveIsNotOutOfBounds(final int row, final int col, final int boardSize) {
        if (row < 0 || col < 0 || row >= boardSize || col >= boardSize) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean isKnightMoveValid(final int row, final int col, final Piece knight) {
        int x = row - knight.getX();
        int y = col - knight.getY();
        return (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3);
    }

    @Override
    public boolean checkGameOver(final Piece pawn, final Piece knight) {
        return pawn.getPosition().equals(knight.getPosition());
    }
}
