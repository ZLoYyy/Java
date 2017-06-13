package com.shishpordenis;

import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Created by ((ZLoY)) on 02.06.2017.
 */
public class ViewController extends TemplatedController {
    public ViewController() throws IOException {
    }

    @Override
    protected String getTemplateName() {
        return "view.ftl";
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        Executor executor = new Executor();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String htmlName = reader.readLine();//"R:/Projects/JavaConventer/Free Online .html"
            Printers printers = new Printers();
            String view = printers.get();

            byte[] bytes = view.getBytes();
            httpExchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = httpExchange.getResponseBody();
            os.write(bytes);

            this.respond(view);




            new Converter(htmlName);
            Printers.print(executor.getPDFName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
