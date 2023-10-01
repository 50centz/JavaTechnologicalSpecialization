import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {

    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_POSX = 1000;
    private static final int WINDOW_POSY = 600;

    private JButton btnLogin, btnSend;

    private TextField loginField;



    public ClientGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Client Window");
        setResizable(false);


        JPanel mainPanel = new JPanel(new GridLayout(2, 3));
        mainPanel.add((panelSocket()));
        mainPanel.add(panelLoginPass());

        add(mainPanel, BorderLayout.NORTH);

        setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServerWindow serverWindow = new ServerWindow("");
                int statusServer = serverWindow.getStatusServer();
                if (statusServer == 0){
                    new StatusServer();
                }else {
                    startСommunication(loginField.getText());
                }
            }
        });


    }

    private Component panelSocket(){
        JPanel panelSocket = new JPanel(new GridLayout(1, 2));
        TextField ipField = new TextField("Enter ip server");
        TextField portField = new TextField("Enter port");
        panelSocket.add(ipField);
        panelSocket.add(portField);

        return panelSocket;
    }

    private Component panelLoginPass(){
        JPanel panelLoginPass = new JPanel(new GridLayout(1, 3));
        loginField = new TextField("Enter your login");
        JPasswordField passwordField = new JPasswordField("Enter your password");
        passwordField.setEchoChar('*');
        btnLogin = new JButton("Login");
        panelLoginPass.add(loginField);
        panelLoginPass.add(passwordField);
        panelLoginPass.add(btnLogin);

        return panelLoginPass;
    }

    private void startСommunication(String user){

        getContentPane().removeAll();

        JPanel panelTextBottom = new JPanel(new GridLayout(1, 2));
        TextField sendMessage = new TextField("");
        btnSend = new JButton("Send");
        panelTextBottom.add(sendMessage);
        panelTextBottom.add(btnSend);

        add(panelTextBottom, BorderLayout.SOUTH);

        setVisible(true);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendServer(user + ": " + sendMessage.getText() + "\n");
                sendMessage.setText("");
            }
        });

    }

    private void sendServer(String message){
        ServerWindow serverWindow = new ServerWindow("");
        serverWindow.setText(message);
    }
}
