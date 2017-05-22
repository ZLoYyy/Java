package com.shishpordenis;

import com.sun.net.httpserver.HttpServer;
import org.apache.fop.apps.FOPException;

import javax.print.PrintException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by ((ZLoY)) on 28.03.2017.
 */
public class Server {
    public static void main(String[] args) throws IOException, PrintException, TransformerException, FOPException {
        int port = 8765;

        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(port), 0);

        server.createContext("/", new ViewerPrinter());
        server.start();

        System.out.println("Server started localhost:" + port);

//        Converter converter = new Converter("R:/Projects/JavaConventer/hello.html");
//        converter.convertToPDF();





//        try {
//            Printers.print();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
