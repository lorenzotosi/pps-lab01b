package e2;

public interface Piece {

    Pair<Integer, Integer> getPosition();

    void setPosition(Pair<Integer, Integer> position);

    Integer getX();

    Integer getY();
}
