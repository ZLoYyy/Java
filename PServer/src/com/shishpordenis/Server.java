package com.shishpordenis;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {

    private static int port = 8765;

    public static void main(String[] args) throws IOException {



        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(port), 0);
        server.createContext("/", new ViewController());
//        server.createContext("/print", (HttpHandler) new Printers());
        server.start();

        System.out.println("Server started localhost:" + port);

    }


}
