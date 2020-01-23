import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.GenericArrayType;


public class Sweeper extends JFrame {
    private Game game;
    private JPanel panel;
    private JLabel label;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int imageSize = 50;
    private final int bombs = 10;

    public Sweeper() {
        game = new Game(COLS, ROWS, bombs);
        game.start();
        setImages();
        initLabel();
        initPanel();
        initFrame();

    }

    private void initLabel() {
        label = new JLabel("Welcome");

        add(label, BorderLayout.SOUTH);
    }

    private void initPanel() {

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coordinates coordinates : Ranges.getAllCoordinates()
                ) {
                    g.drawImage((Image) game.getBox(coordinates).image,
                            coordinates.getX() * imageSize, coordinates.getY() * imageSize, this);
                }
            }
        };


        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / imageSize;
                int y = e.getY() / imageSize;
                Coordinates coordinates = new Coordinates(x, y);

                if (e.getButton() == MouseEvent.BUTTON1) {
                    game.leftButtonPressed(coordinates);
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    game.rightButtonPressed(coordinates);
                }
                if (e.getButton() == MouseEvent.BUTTON2) {
                    game.start();
                }
                label.setText(getMessage());
                panel.repaint();
            }
        });

        panel.setPreferredSize(new Dimension(
                Ranges.getSize().getX() * imageSize,
                Ranges.getSize().getY() * imageSize));
        add(panel);

    }

    private String getMessage() {

        switch (game.getGameState()) {
            case PLAYED:
                return "Think twice before move ! ";
            case BOMBED:
                return "Looser !";
            case WINNER:
                return "Congratulation";
            default:
                return "Welcome";
        }
    }

    private void initFrame() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sweeper");
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
        pack();
        setLocationRelativeTo(null);
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
