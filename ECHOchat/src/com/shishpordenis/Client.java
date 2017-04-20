package com.shishpordenis;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by ((ZLoY)) on 20.04.2017.
 */
public class Client extends Thread {
    private final int serverPort = 8080;
    private String ip = "127.0.0.1";
    private String message;
    private String answer;
    private InputStream inputStream;
    private OutputStream outputStream;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;



    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.connection();
    }

    private void connection() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        InetAddress address = InetAddress.getByName(ip);
        Socket socket = new Socket(address, serverPort);
        System.out.println("Connection to the server was successful.");

        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();

        dataInputStream = new DataInputStream(inputStream);
        dataOutputStream = new DataOutputStream(outputStream);

        while (true) {
            System.out.print("Enter message: ");
            message = reader.readLine();
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
            answer = dataInputStream.readUTF();
            System.out.println("Server responded: " + answer);
            System.out.println();
        }
    }


}
