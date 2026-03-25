package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Random;

public class Client {
    private static final int PORT = 1234;
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", PORT);

            Random random = new Random();
            int n = 3;
            int m = 3;
            int[][] matrix = new int[n][m];

            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    matrix[i][j] = random.nextInt(100);
                }
            }

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            objectOutputStream.writeObject(matrix);

            System.out.println("Sent matrix to server: ");

            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            int sum = dataInputStream.readInt();
            System.out.println("Received sum from server.");
            System.out.println("The sum is " + sum);

            clientSocket.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
