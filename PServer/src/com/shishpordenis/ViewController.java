package com.shishpordenis;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

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

            new Converter("R:/Projects/JavaConventer/Free Online .html");
            Printers.print(executor.getPDFName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
