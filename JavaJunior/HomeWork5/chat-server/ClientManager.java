package ru.geekbrains.chat.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {

    private final Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    public final static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        this.socket = socket;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.println(name + " подключился к чату.");
            broadcastMessage("Server: " + name + " подключился к чату.");
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }


    }

    @Override
    public void run() {
        String massageFromClient;

        while (socket.isConnected()) {
            try {
                massageFromClient = bufferedReader.readLine();
                /*if (massageFromClient == null){
                    // для  macOS
                    closeEverything(socket, bufferedReader, bufferedWriter);
                    break;
                }*/
                String[] names = massageFromClient.split(":");
                String name = names[1].toLowerCase().trim();
                massageFromClient = names[0] + ":" + names[2];

                if (name.equals("all")) {
                    broadcastMessage(massageFromClient);
                } else {
                    sendMessageUser(massageFromClient, name, names[0].toLowerCase());
                }

            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    public void sendMessageUser(String message, String name, String from) {
        int count = 0;
        try {
            for (ClientManager clientManager : clients) {
                if (clientManager.name.toLowerCase().equals(name)) {
                    clientManager.bufferedWriter.write(message);
                    clientManager.bufferedWriter.newLine();
                    clientManager.bufferedWriter.flush();
                    count++;
                }
            }
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }

        if (count == 0){
            String msg = "Пользователь с таким именем не в сети";
            try
            {
                for (ClientManager clientManager : clients) {
                    if (clientManager.name.toLowerCase().equals(from)) {
                        clientManager.bufferedWriter.write(msg);
                        clientManager.bufferedWriter.newLine();
                        clientManager.bufferedWriter.flush();
                        count++;
                    }
                }
            }catch (IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    private void broadcastMessage(String message) {

        for (ClientManager client : clients) {
            try {
                if (!client.name.equals(name)) {
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }


    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        // Удаление клиента из коллекции
        removeClient();
        try {
            // Завершаем работу буфера на чтение данных
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            // Завершаем работу буфера для записи данных
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            // Закрытие соединения с клиентским сокетом
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClient() {
        clients.remove(this);
        System.out.println(name + " покинул чат.");
        broadcastMessage("Server: " + name + " покинул чат.");
    }

}
