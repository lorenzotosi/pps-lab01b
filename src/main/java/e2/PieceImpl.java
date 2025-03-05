package e2;

public class PieceImpl implements Piece{

    private Pair<Integer, Integer> position;

    public PieceImpl(int row, int column){
        this.position = new Pair<>(row, column);
    }

    public PieceImpl(Pair<Integer, Integer> position){
        this.position = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Pair<Integer, Integer> position) {
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
