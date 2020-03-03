import lombok.Getter;

class Flag {


    private Matrix flagMap;
    @Getter
    private int closedBoxes;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
        this.closedBoxes = Ranges.getSize().getX() * Ranges.getSize().getY();
    }

    Box get(Coordinates coordinates) {
        return flagMap.get(coordinates);
    }

    void setOpenedToBox(Coordinates coordinates) {
        flagMap.set(coordinates, Box.OPENED);
        closedBoxes--;
    }

    void setFlagedToBox(Coordinates coordinates) {

        flagMap.set(coordinates, Box.FLAGGED);

    }

    void toggleFlaggedToBox(Coordinates coordinates) {

        switch (flagMap.get(coordinates)) {

            case FLAGGED:
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

    void setBombedToBox(Coordinates bombedToBox) {
        flagMap.set(bombedToBox, Box.BOMBED);
    }

    void setOpenedBoxToBomb(Coordinates coordinates) {

        if (flagMap.get(coordinates) == Box.CLOSED) {
            flagMap.set(coordinates, Box.BOMB);
        }
    }

    void setNoBombToSafeBox(Coordinates coordinates) {
        if (flagMap.get(coordinates) == Box.FLAGGED) {
            flagMap.set(coordinates, Box.NOBOMB);
        }
    }



    int getCounterOfFlagedBox(Coordinates coordinates) {
        int counter = 0;
        for (Coordinates around : Ranges.getCoordinatesAroundBomb(coordinates)
        ) {
            if (flagMap.get(around) == Box.FLAGGED) {
                counter++;
            }

        }
        return counter;
    }
}
