import java.awt.event.MouseAdapter;

class Matrix {

     Box[][] matrix;


     Matrix(Box defaultBox) {

        matrix = new Box[Ranges.getSize().getX()][Ranges.getSize().getY()];

        for (Coordinates coordinates : Ranges.getAllCoordinates()
        ) {

            matrix[coordinates.getX()][coordinates.getY()] = defaultBox;
        }
    }

    Box get(Coordinates coordinates) {
        if (Ranges.inRange(coordinates))
            return matrix[coordinates.getX()][coordinates.getY()];
        return null;
    }

    void set(Coordinates coordinates, Box box) {
        if (Ranges.inRange(coordinates))
        matrix[coordinates.getX()][coordinates.getY()] = box;
    }

}
