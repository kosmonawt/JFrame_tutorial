import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {

    private JFrame setup;
    private JButton button;
    private JLabel label;
    private Rectangle button1;
    private Rectangle button2;
    private Rectangle button3;


    public MainWindow() {
        initWindow();
        initButtons();
        initText();


    }

    private void initWindow() {
        setup = new JFrame("Mine Sweeper");
        setup.setSize(300, 500);
        setup.setResizable(false);
        setup.setLayout(null);
        setup.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setup.setVisible(true);
    }

    private void initText() {
        label = new JLabel("Choose difficult", SwingConstants.CENTER);
        label.setBounds(50, 20, 200, 30);
        setup.add(label);
    }


    private void initButtons() {

        button = new JButton();
        button.setText("9x9");
        button.setBounds(100, 150, 100, 20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Sweeper sweeper = new Sweeper(10,10,16);


            }
        });
        setup.add(button);

    }
}
