import javax.swing.*;

import java.awt.*;
import java.lang.reflect.GenericArrayType;


public class Sweeper extends JFrame {
    private Game game;
    private JPanel panel;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int imageSize = 50;

    public Sweeper() {
        game = new Game(COLS, ROWS);
        game.start();
        setImages();
        initPanel();
        initFrame();

    }

    private void initPanel() {

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coordinates coordinates : Ranges.getAllCoordinates()
                ) {


                    g.drawImage((Image) game.getBox(coordinates).image,
                            coordinates.getX() * imageSize, coordinates.getY() * imageSize, this)
                    ;
                }
            }
        };

        panel.setPreferredSize(new Dimension(
                Ranges.getSize().getX() * imageSize,
                Ranges.getSize().getY() * imageSize));
        add(panel);

    }

    private void initFrame() {

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));

    }

    private void setImages() {
        for (Box box : Box.values()) {
            box.image = getImage(box.name());
        }
    }

    private Image getImage(String name) {

        String fileName = "img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();

    }

}
