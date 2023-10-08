package server;

import server.client.ClientGUI;
import server.server.ServerWindow;
import server.server.Storage;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage("src/server/log.txt");
        ServerWindow serverWindow = new ServerWindow(storage);
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
