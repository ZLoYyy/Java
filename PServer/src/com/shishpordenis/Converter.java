package com.shishpordenis;

import org.apache.avalon.framework.logger.ConsoleLogger;
import org.apache.avalon.framework.logger.Logger;
import org.apache.fop.apps.Driver;
import org.apache.fop.tools.DocumentInputSource;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import java.io.*;

/**
 * Created by ((ZLoY)) on 23.05.2017.
 */
public class Converter {

    Converter(String htmlFileName) throws TransformerConfigurationException {

        Executor executor = new Executor();
        FileInputStream inputHtml = null;
        try {
            inputHtml = new FileInputStream(htmlFileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + htmlFileName);
        }

        String xslFile = "./Templates/xhtml2fo.xsl";

        Tidy tidy = new Tidy();
        Document xmlDoc = tidy.parseDOM(inputHtml, null);
        Document foDoc = xml_to_FO(xmlDoc, xslFile);


        String pdfFileName = htmlFileName.substring(0, htmlFileName.indexOf(".")) + ".pdf";

        try {
            OutputStream pdf = new FileOutputStream(new File(pdfFileName));
            pdf.write(fo_to_PDF(foDoc));
            pdf.close();
            executor.setPDFName(pdfFileName);
        } catch (FileNotFoundException e) {
            System.out.println("Error creating PDF: " + pdfFileName);
        } catch (IOException e) {
            System.out.println("Error writing PDF: " + pdfFileName);
        }

    }
    //
    private Document xml_to_FO(Document xml, String styleSheet) {

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
    //
    private byte[] fo_to_PDF(Document foDocument) throws FileNotFoundException {

        DocumentInputSource fopInputSource = new DocumentInputSource(foDocument);

        try {

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Logger log = new ConsoleLogger(ConsoleLogger.LEVEL_WARN);

            Driver driver = new Driver(fopInputSource, out);
            driver.setLogger(log);
            driver.setRenderer(Driver.RENDER_PDF);
            driver.run();

            return out.toByteArray();

        } catch (Exception ex) {
            return null;
        }
    }
    //
    private Transformer getTransformer(String styleSheet) {

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


//    private String toString(Document document) {
//        try {
//            StringWriter stringWriter = new StringWriter();
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//
//            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
//            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
//            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//
//            transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
//            return stringWriter.toString();
//        } catch (Exception e) {
//            throw new RuntimeException("Error converting to String", e);
//        }
//    }
//
//    public Document loadXMLFrom(String xml) throws TransformerException {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder;
//        try
//        {
//            builder = factory.newDocumentBuilder();
//            Document doc = builder.parse( new InputSource( new StringReader( xml ) ) );
//            return doc;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }



}
