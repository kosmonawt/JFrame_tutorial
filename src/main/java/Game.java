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
        if (gameOver()) return;

        openBox(coordinates);
        checkWinner();

    }

    private void openBox(Coordinates coordinates) {
        switch (flag.get(coordinates)) {
            case OPENED:
                setOpenBoxAroundNumber(coordinates);
                return;
            case FLAGGED:
                return;
            case CLOSED:
                switch (bomb.get(coordinates)) {
                    case BOMB:
                        openBomb(coordinates);
                        return;
                    case ZERO:
                        openEmptyBoxesAround(coordinates);
                        return;
                    default:
                        flag.setOpenedToBox(coordinates);
                }
        }
    }

    private void setOpenBoxAroundNumber(Coordinates coordinates) {

        if (bomb.get(coordinates) != Box.BOMB) {
            if (flag.getCounterOfFlagedBox(coordinates) == bomb.get(coordinates).ordinal()) {
                for (Coordinates around : Ranges.getCoordinatesAroundBomb(coordinates)) {
                    if (flag.get(coordinates) == Box.CLOSED) {
                        openBox(around);
                    }
                }
            }
        }

    }

    private void openBomb(Coordinates bombed) {

        gameState = GameState.BOMBED;
        flag.setBombedToBox(bombed);

        for (Coordinates coordinates : Ranges.getAllCoordinates()
        ) {
            if (bomb.get(coordinates) == Box.BOMB) {
                flag.setOpenedBoxToBomb(coordinates);
            } else
                flag.setNoBombToSafeBox(coordinates);

        }

    }

    private void checkWinner() {
        if (gameState == GameState.PLAYED) {
            if (flag.getClosedBoxes() == bomb.getTotalBomb()) {
                gameState = GameState.WINNER;
            }
        }
    }

    private void openEmptyBoxesAround(Coordinates coordinates) {
        flag.setOpenedToBox(coordinates);

        for (Coordinates around : Ranges.getCoordinatesAroundBomb(coordinates)
        ) {
            openBox(around);
        }
    }

    public void rightButtonPressed(Coordinates coordinates) {
        if (gameOver()) return;

        flag.toggleFlaggedToBox(coordinates);
    }

    private boolean gameOver() {

        if (gameState == GameState.PLAYED) {
            return false;
        }
        start();
        return true;
    }
}
