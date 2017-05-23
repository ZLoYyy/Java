package com.shishpordenis;

import com.sun.net.httpserver.HttpHandler;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ((ZLoY)) on 23.05.2017.
 */
public abstract class TemplatedController implements HttpHandler {

    protected final Configuration configuration;

    public TemplatedController() throws IOException {
        configuration = new Configuration(Configuration.VERSION_2_3_25);
        configuration.setDirectoryForTemplateLoading(new File("./templates"));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);

    }

    protected void respond(String printer) throws IOException, TemplateException {
        Template template = configuration.getTemplate(getTemplateName());
        Map root = new HashMap();
        root.put("printers", printer);
//        Product latest = new Product();
//        latest.setUrl("products/greenmouse.html");
//        latest.setName("green mouse");
//        root.put("latestProduct", latest);
        Writer out = new OutputStreamWriter(System.out);
        template.process(root, out);
    }

    protected abstract String getTemplateName();
}
