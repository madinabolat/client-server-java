package org.example;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            System.out.println("Starting a server...");

            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port" + PORT);

            Socket clientConnection = server.accept();
            System.out.println("Client connected");

            ObjectInputStream objectInputStream = new ObjectInputStream(clientConnection.getInputStream());
            int[][] matrix = (int[][]) objectInputStream.readObject();
            System.out.println("Server received matrix.");
            int n = matrix.length;
            int m = matrix[0].length;

            int sum = 0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    sum += matrix[i][j];
                }
            }

            DataOutputStream dataOutputStream = new DataOutputStream(clientConnection.getOutputStream());
            dataOutputStream.writeInt(sum);
            System.out.println("Matrix sum sent to client.");
            clientConnection.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
