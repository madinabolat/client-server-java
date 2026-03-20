package org.example;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    private static final int PORT = 1234;
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", PORT);
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            dataOutputStream.writeUTF("hello from client!");

            clientSocket.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
