import lombok.Getter;
import java.util.ArrayList;
import java.util.Random;

public class Ranges {
    @Getter
    private static Coordinates size;
    @Getter
    private static ArrayList<Coordinates> allCoordinates;
    private static Random random = new Random();


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

        return coordinates.getX() >= 0 && coordinates.getX() < size.getX() &&
                coordinates.getY() >= 0 && coordinates.getY() < size.getY();
    }

    static Coordinates getRandomCoordinates() {
        return new Coordinates(random.nextInt(size.getX()), random.nextInt(size.getY()));
    }

    static ArrayList<Coordinates> getCoordinatesAroundBomb(Coordinates coordinates) {

        Coordinates around;
        ArrayList<Coordinates> list = new ArrayList<>();
        for (int x = coordinates.getX() - 1; x <= coordinates.getX() + 1; x++) {
            for (int y = coordinates.getY() - 1; y <= coordinates.getY() + 1; y++) {
                if (inRange(around = new Coordinates(x, y))) {
                    if (!around.equals(coordinates)) {
                        list.add(around);
                    }
                }
            }
        }
        return list;
    }
}
