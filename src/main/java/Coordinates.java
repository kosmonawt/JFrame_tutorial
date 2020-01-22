import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof Coordinates) {
            Coordinates to = (Coordinates) o;
            return to.getX() == x && to.getY() == y;
        }

        return super.equals(o);
    }

}
