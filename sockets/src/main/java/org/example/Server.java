package org.example;

import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            System.out.println("Starting a server...");

            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port" + PORT);

            Socket client = server.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
            String input = dataInputStream.readUTF();
            System.out.println(input);

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
