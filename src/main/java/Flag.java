class Flag {


    private Matrix flagMap;

    void start() {
        flagMap = new Matrix(Box.CLOSED);

    }

    Box get(Coordinates coordinates) {
        return flagMap.get(coordinates);
    }

    void setOpenedToBox(Coordinates coordinates) {
        flagMap.set(coordinates, Box.OPENED);
    }

    void setFlagedToBox(Coordinates coordinates) {

        flagMap.set(coordinates, Box.FLAGED);

    }

    void toggleFlaggedToBox(Coordinates coordinates) {

        switch (flagMap.get(coordinates)) {

            case FLAGED:
                setClosedToBox(coordinates);
                break;
            case CLOSED:
                setFlagedToBox(coordinates);
                break;
        }


    }

    void setClosedToBox(Coordinates coordinates) {
        flagMap.set(coordinates, Box.CLOSED);
    }
}
