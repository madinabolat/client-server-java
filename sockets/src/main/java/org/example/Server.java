package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        //do with try use so that socket closes.
        //research try use. 
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true){
                try{
                    Socket socket = server.accept();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}
