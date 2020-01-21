import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Ranges {
    @Getter
    private static Coordinates size;
    @Getter
    private static ArrayList<Coordinates> allCoordinates;


    public static void setSize(Coordinates coordinates) {
        size = coordinates;
        allCoordinates = new ArrayList<>();
        for (int y = 0; y < getSize().getY(); y++) {

            for (int x = 0; x < getSize().getX(); x++) {
                allCoordinates.add(new Coordinates(x, y));
            }
        }
    }


    static boolean inRange(Coordinates coordinates) {

        return  coordinates.getX() >= 0 && coordinates.getX() < size.getX() &&
                coordinates.getY() >= 0 && coordinates.getY() < size.getY();

    }
}
