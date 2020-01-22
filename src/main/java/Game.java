import lombok.Getter;

public class Game {

    Bomb bomb;
    Flag flag;
    @Getter
    GameState gameState;

    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Coordinates(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    }

    public void start() {
        bomb.start();
        flag.start();
        gameState = GameState.PLAYED;
    }

    public Box getBox(Coordinates coordinates) {
        if (flag.get(coordinates) == Box.OPENED) {
            return bomb.get(coordinates);
        } else
            return flag.get(coordinates);
    }

    public void leftButtonPressed(Coordinates coordinates) {

        flag.setOpenedToBox(coordinates);

    }

    public void rightButtonPressed(Coordinates coordinates) {

        flag.toggleFlaggedToBox(coordinates);
    }
}
