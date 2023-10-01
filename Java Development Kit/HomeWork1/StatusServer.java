import javax.swing.*;
import java.awt.*;

public class StatusServer extends JFrame {

    private static final int WINDOW_HEIGHT = 100;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POSX = 1000;
    private static final int WINDOW_POSY = 600;
    public StatusServer(){
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Status Server");
        setResizable(false);


        JLabel label = new JLabel("The server is not running, start the server via the Start button");
        add(label);
        setVisible(true);

    }
}
