import javax.swing.*;
import java.awt.*;

public class Sweeper extends JFrame {

    private JPanel panel;
    private final int COLS = 15;
    private final int ROWS = 1;
    private final int imageSize = 50;

    public Sweeper() {
        initPanel();
        initFrame();

    }

    private void initPanel() {

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(getImage("bomb"), 0, 0, this);
            }
        };
        panel.setPreferredSize(new Dimension(
                COLS * imageSize, ROWS * imageSize));
        add(panel);

    }

    private void initFrame() {

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    private Image getImage(String name) {

        String fileName = "img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();

    }

}
