public class Game {

    Matrix bombMap;

    public Game(int cols, int rows) {
        Ranges.setSize(new Coordinates(cols, rows));
    }

    public void start() {
        bombMap = new Matrix(Box.BOMB);
    }

    public Box getBox(Coordinates coordinates) {
        return Box.values()[(coordinates.getX() + coordinates.getY()) % Box.values().length];
    }

}
