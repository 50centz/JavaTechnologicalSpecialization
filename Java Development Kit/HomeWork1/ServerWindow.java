import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class ServerWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_POSX = 300;
    private static final int WINDOW_POSY = 600;

    private LocalDate localDate;
    private LocalTime localTime;

    private static JTextArea textArea;

    private static int statusServer = 0;

    public ServerWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server Window");
        setResizable(false);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(textArea);

        JPanel btnPanel = new JPanel(new GridLayout(1, 2));
        JButton btnStart = new JButton("Start");
        JButton btnStop = new JButton("Stop");
        btnStop.setBackground(Color.RED);
        btnStart.setBackground(Color.GREEN);
        btnPanel.add(btnStart);
        btnPanel.add(btnStop);

        add(jScrollPane);
        add(btnPanel, BorderLayout.SOUTH);

        setVisible(true);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopServer();
            }
        });
    }

    public ServerWindow(String text){

    }

    private void startServer(){
        if (statusServer == 0){
            readLog();
            localDate = LocalDate.now();
            localTime = LocalTime.now();
            textArea.append(localDate + " " + localTime.withNano(0) + ": Server started\n");
            recLog(localDate + " " + localTime.withNano(0) + ": Server started\n");
            statusServer = 1;
        }else if (statusServer == 1){
            localDate = LocalDate.now();
            localTime = LocalTime.now();
            textArea.append(localDate + " " + localTime.withNano(0) +
                    ": Server is already running\n");
            recLog(localDate + " " + localTime.withNano(0) +
                    ": Server is already running\n");
        }
    }

    private void stopServer(){
        if (statusServer == 1){
            localDate = LocalDate.now();
            localTime = LocalTime.now();
            textArea.append(localDate + " " + localTime.withNano(0) + ": Server stopped\n");
            recLog(localDate + " " + localTime.withNano(0) + ": Server stopped\n");
            statusServer = 0;
        }else if (statusServer == 0){
            localDate = LocalDate.now();
            localTime = LocalTime.now();
            textArea.append(localDate + " " + localTime.withNano(0) +
                    ": Server was stopped\n");
            recLog(localDate + " " + localTime.withNano(0) +
                    ": Server was stopped\n");
        }
    }

    public int getStatusServer() {
        return statusServer;
    }

    public void setText(String message){
        textArea.append(message);
        recLog(message);
    }

    private void recLog(String message){
        try(FileWriter writer = new FileWriter("logs.txt", true))
        {
            writer.write(message);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void readLog(){
        List<String> array = new ArrayList<>();
        try{
            File file = new File("logs.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String message = bufferedReader.readLine();
            while (message != null){
                array.add(message);
                message = bufferedReader.readLine();
            }

        }catch (Exception e){
            new MyException(e.getMessage());
        }

        for (int i = 0; i < array.size(); i++) {
            textArea.append(array.get(i) + "\n");
        }
    }
}
