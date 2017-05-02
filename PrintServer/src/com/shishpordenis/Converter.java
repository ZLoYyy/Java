package com.shishpordenis;

import org.apache.avalon.framework.logger.ConsoleLogger;
import org.apache.avalon.framework.logger.Logger;
import org.apache.fop.apps.Driver;
import org.apache.fop.tools.DocumentInputSource;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import java.io.*;

public class Converter {

    public static void main(String[] args) throws Exception {
             //getURL
//        String content = null;
//        URLConnection connection = null;
//        try {
//            connection =  new URL("https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html").openConnection();
//            Scanner scanner = new Scanner(connection.getInputStream());
//            scanner.useDelimiter("\\Z");
//            content = scanner.next();
//        }catch ( Exception ex ) {
//            ex.printStackTrace();
//        }
//        System.out.println(content);






        FileInputStream inputHtml = null;
        FileInputStream inputXsl = null;

        String htmlFileName = "R:/Projects/JavaConventer/hello.html";
        try {
            inputHtml = new FileInputStream(htmlFileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + htmlFileName);
        }

        String xslFile = "./Templates/xhtml2fo.xsl";
        try {
            inputXsl = new FileInputStream(xslFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + xslFile);
        }

        Tidy tidy = new Tidy();
        Document xmlDoc = tidy.parseDOM(inputHtml, null);
        Document foDoc = xml2FO(xmlDoc, inputXsl);

        if (foDoc == null) {
            System.out.println("Document is null");
        }

        String pdfFileName = htmlFileName.substring(0, htmlFileName.indexOf(".")) + ".pdf";
        try {
            OutputStream pdf = new FileOutputStream(new File(pdfFileName));
            pdf.write(fo2PDF(foDoc));
        } catch (FileNotFoundException e) {
            System.out.println("Error creating PDF: " + pdfFileName);
        } catch (IOException e) {
            System.out.println("Error writing PDF: " + pdfFileName);
        }




    }

    private static Document xml2FO(Document xml, InputStream styleSheet) throws TransformerConfigurationException {
        DOMSource xmlDomSource = new DOMSource(xml);
        DOMResult domResult = new DOMResult();

        Transformer transformer = getTransformer(styleSheet);

        if (transformer == null) {
            System.out.println("Error creating transformer for " + styleSheet);
            System.exit(1);
        }
        try {
            transformer.transform(xmlDomSource, domResult);
        } catch (TransformerException e) {
            return null;
        }
        return (Document) domResult.getNode();

    }

    private static byte[] fo2PDF(Document foDocument) {
        DocumentInputSource fopInputSource = new DocumentInputSource(foDocument);

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Logger logger = new ConsoleLogger(ConsoleLogger.LEVEL_DEBUG);

            Driver driver = new Driver(fopInputSource, out);
            driver.setLogger(logger);
            driver.setRenderer(Driver.RENDER_PDF);
            driver.run();

            return out.toByteArray();
        } catch (Exception ex) {
            return null;
        }



    }
    //
    private static Transformer getTransformer(InputStream styleSheet) {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();

            dFactory.setNamespaceAware(true);



            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
            Document xslDoc = dBuilder.parse(styleSheet);
            DOMSource xslDomSource = new DOMSource(xslDoc);

            return tFactory.newTransformer(xslDomSource);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        } catch (SAXException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            return null;
        }

    }
}
