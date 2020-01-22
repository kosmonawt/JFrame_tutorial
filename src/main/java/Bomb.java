class Bomb {
    private Matrix bombMap;
    private int totalBomb;

    Bomb(int totalBomb) {
        this.totalBomb = totalBomb;
        fixBombs();
    }


    void start() {
        bombMap = new Matrix(Box.ZERO);

        for (int i = 0; i < totalBomb; i++) {
            placeBomb();
        }
    }

    Box get(Coordinates coordinates) {
        return bombMap.get(coordinates);
    }

    private void fixBombs() {
        int maxBobms = Ranges.getSize().getX() * Ranges.getSize().getY() / 2;
        if (totalBomb > maxBobms) {
            totalBomb = maxBobms;
        }
    }

    private void placeBomb() {

        while (true) {
            Coordinates coordinates = Ranges.getRandomCoordinates();
            if (Box.BOMB == bombMap.get(coordinates)) {
                continue;
            }
            bombMap.set(coordinates, Box.BOMB);
            incNumAroundBomb(coordinates);
            break;
        }
    }

    private void incNumAroundBomb(Coordinates coordinates) {

        for (Coordinates around : Ranges.getCoordinatesAroundBomb(coordinates)) {
            if (Box.BOMB != bombMap.get(around)) {
                bombMap.set(around, bombMap.get(around).getNextNumberBox());
            }
        }

    }

}
