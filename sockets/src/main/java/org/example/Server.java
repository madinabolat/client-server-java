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
            int num1 = dataInputStream.readInt();
            int num2 = dataInputStream.readInt();
            int sum = num1 + num2;

            System.out.println("The sum is " + sum);
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
