import javax.swing.*;

public class MyException extends JFrame {

    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 500;

    public MyException(String message){

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Error");

        JLabel label = new JLabel(message);
        add(label);

        setVisible(true);

    }
}
