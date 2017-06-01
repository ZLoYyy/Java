package com.shishpordenis;

import org.apache.avalon.framework.logger.ConsoleLogger;
import org.apache.avalon.framework.logger.Logger;
import org.apache.fop.apps.Driver;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Created by ((ZLoY)) on 23.05.2017.
 */
public class Converter {

//    public static void main(String[] args) {
//
//
//
//        FileInputStream input = null;
//        String htmlFileName = "R:/Projects/JavaConventer/hello.html";
//
//        try {
//
//            input = new FileInputStream(htmlFileName);
//
//        }
//        catch (java.io.FileNotFoundException e) {
//            System.out.println("File not found: " + htmlFileName);
//        }
//
//        Tidy tidy = new Tidy();
//        Document xmlDoc = tidy.parseDOM(input, null);
//
//        Document foDoc = xml2FO(xmlDoc, "./Templates/xhtml2fo.xsl");
//
//        String pdfFileName = htmlFileName.substring(0, htmlFileName.indexOf(".")) + ".pdf";
//        try {
//            OutputStream pdf = new FileOutputStream(new File(pdfFileName));
//            pdf.write(fo2PDF(foDoc));
//        }
//        catch (java.io.FileNotFoundException e) {
//            System.out.println("Error creating PDF: " + pdfFileName);
//        }
//        catch (java.io.IOException e) {
//            System.out.println("Error writing PDF: " + pdfFileName);
//        }
//
//
//    }

    Converter(String htmlFileName) throws TransformerConfigurationException {

        FileInputStream inputHtml = null;
        try {
            inputHtml = new FileInputStream(htmlFileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + htmlFileName);
        }

        String xslFile = "./Templates/xhtml2fo.xsl";

        Tidy tidy = new Tidy();
        Document xmlDoc = tidy.parseDOM(inputHtml, null);
        Document foDoc = xml2FO(xmlDoc, xslFile);

        String fo = toString(foDoc);
        String pdfFileName = htmlFileName.substring(0, htmlFileName.indexOf(".")) + ".pdf";
        try {

            loadXMLFrom(fo);







            OutputStream pdf = new FileOutputStream(new File(pdfFileName));
            pdf.write(fo2PDF(foDoc));
        } catch (FileNotFoundException e) {
            System.out.println("Error creating PDF: " + pdfFileName);
        } catch (IOException e) {
            System.out.println("Error writing PDF: " + pdfFileName);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
    private static Document xml2FO(Document xml, String styleSheet) {

        DOMSource xmlDomSource = new DOMSource(xml);
        DOMResult domResult = new DOMResult();

        Transformer transformer = getTransformer(styleSheet);

        if (transformer == null) {
            System.out.println("Error creating transformer for " + styleSheet);
            System.exit(1);
        }
        try {
            transformer.transform(xmlDomSource, domResult);
        }
        catch (javax.xml.transform.TransformerException e) {
            return null;
        }
        return (Document) domResult.getNode();

    }

    private static byte[] fo2PDF(Document foDocument) throws FileNotFoundException {

        FileInputStream dd = new FileInputStream(new File("./Templates/foDoc.fo"));

//        DocumentInputSource fopInputSource = new DocumentInputSource(foDocument);
        InputSource s = new InputSource(dd);

        try {

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Logger log = new ConsoleLogger(ConsoleLogger.LEVEL_WARN);

            Driver driver = new Driver(s, out);
            driver.setLogger(log);
            driver.setRenderer(Driver.RENDER_PDF);
            driver.run();

            return out.toByteArray();

        } catch (Exception ex) {
            return null;
        }
    }
    //
    private static Transformer getTransformer(String styleSheet) {

        try {

            TransformerFactory tFactory = TransformerFactory.newInstance();

            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();

            dFactory.setNamespaceAware(true);

            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
            Document xslDoc = dBuilder.parse(styleSheet);
            DOMSource xslDomSource = new DOMSource(xslDoc);

            return tFactory.newTransformer(xslDomSource);

        }
        catch (javax.xml.transform.TransformerException e) {
            e.printStackTrace();
            return null;
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
        catch (javax.xml.parsers.ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        }
        catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static String toString(Document document) {
        try {
            StringWriter stringWriter = new StringWriter();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error converting to String", e);
        }
    }

    public static Document loadXMLFrom(String xml) throws TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try
        {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse( new InputSource( new StringReader( xml ) ) );
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
