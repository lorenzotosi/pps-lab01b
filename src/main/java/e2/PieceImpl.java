package e2;

public class PieceImpl implements Piece{

    private Pair<Integer, Integer> position;

    public PieceImpl(final int row, final int column){
        this.position = new Pair<>(row, column);
    }

    public PieceImpl(final Pair<Integer, Integer> position){
        this.position = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(final Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public Integer getX() {
        return position.getX();
    }

    @Override
    public Integer getY() {
        return position.getY();
    }
}
