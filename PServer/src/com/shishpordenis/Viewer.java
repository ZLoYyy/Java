//package com.shishpordenis;
//
//import com.sun.net.httpserver.HttpExchange;
//import freemarker.template.TemplateException;
//
//import javax.xml.transform.TransformerConfigurationException;
//import java.io.IOException;
//import java.io.OutputStream;
//
///**
// * Created by ((ZLoY)) on 23.05.2017.
// */
//public class Viewer extends TemplatedController {
//
//    public Viewer() throws IOException {
//        super();
//    }
//
//    @Override
//    public void handle(HttpExchange httpExchange) throws IOException {
//
//        Printers printers = new Printers();
//        String view = printers.get();
//
//        byte[] bytes = view.getBytes();
//        httpExchange.sendResponseHeaders(200, bytes.length);
//
//        OutputStream os = httpExchange.getResponseBody();
//        os.write(bytes);
//        os.close();
//
//        try {
//            this.respond(view);
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//
//
//    @Override
//    protected String getTemplateName() {
//        return "view.ftl";
//    }
//}
