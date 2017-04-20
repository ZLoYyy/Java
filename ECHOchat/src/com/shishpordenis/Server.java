package com.shishpordenis;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private static int port = 8080;
    private String message;
    private Socket socket;
    private int number;
    private InputStream inputStream;
    private OutputStream outputStream;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.connection();
    }

    public Server() {
    }

    public Server(int number, Socket socket) {
        this.number = number;
        this.socket = socket;

        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }

    private void connection() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started, port: " + port);

        int id = 0;
        while (true) {
            new Server(id , serverSocket.accept());
            System.out.println("The client is connected, id: " + id);
            System.out.println();
            id++;
        }
    }

    @Override
    public void run() {
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            dataInputStream = new DataInputStream(inputStream);
            dataOutputStream = new DataOutputStream(outputStream);

            message = dataInputStream.readUTF();
            System.out.println("The client sent this message : " + message);
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
            System.out.println("Waiting next message");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
