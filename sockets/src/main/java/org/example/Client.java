package org.example;

import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Random;

public class Client {
    private static final int PORT = 1234;
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", PORT);
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
//            dataOutputStream.writeUTF("hello from client!");
//            dataOutputStream.writeInt(1);
//            dataOutputStream.writeInt(2);

            Random random = new Random();
            int n = 3;
            int m = 3;
            int[][] matrix = new int[n][m];

            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    matrix[i][j] = random.nextInt(100);
                }
            }
//
//            for (int i = 0; i < n; i++){
//                for (int j = 0; j < m; j++){
//                    System.out.print(matrix[i][j]+" ");
//                }
//                System.out.println();
//            }


            dataOutputStream.flush();
            dataOutputStream.close();

            clientSocket.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
