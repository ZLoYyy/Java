//package com.shishpordenis;
//
//import org.apache.fop.apps.FOPException;
//import org.apache.fop.apps.Fop;
//import org.apache.fop.apps.FopFactory;
//import org.apache.fop.apps.MimeConstants;
//import org.w3c.dom.Document;
//import org.w3c.tidy.Tidy;
//import org.xml.sax.SAXException;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.*;
//import javax.xml.transform.dom.DOMResult;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.sax.SAXResult;
//import java.io.*;
//
//public class ссссссс {
//
//    public static void main(String[] args) throws Exception {
//        //getURL
////        String content = null;
////        URLConnection connection = null;
////        try {
////            connection =  new URL("https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html").openConnection();
////            Scanner scanner = new Scanner(connection.getInputStream());
////            scanner.useDelimiter("\\Z");
////            content = scanner.next();
////        }catch ( Exception ex ) {
////            ex.printStackTrace();
////        }
////        System.out.println(content);
//
//
//
//
//
////        Converter converter = new Converter();
////        try {
////            converter.convertToFO();
////        } catch (IOException e) {
////            e.printStackTrace();
////        } catch (TransformerException e) {
////            e.printStackTrace();
////        }
//
//
//
////        FileInputStream input = null;
////
////        String htmlFileName = "R:\\Projects\\JavaConventer\\hello.html";
////        try {
////            input = new FileInputStream(htmlFileName);
////        } catch (FileNotFoundException e) {
////            System.out.println("File not found " + htmlFileName);
////        }
////
////        Tidy tidy = new Tidy();
////        Document xmlDoc = tidy.parseDOM(input, null);
////        Document foDoc = xml2FO(xmlDoc, "com/shishpordenis/resourse/xhtml2fo.xsl");
////
////        if (foDoc == null) {
////            System.out.println("Document is null");
////        }
////
////        String pdfFileName = htmlFileName.substring(0, htmlFileName.indexOf(".")) + ".pdf";
////        try {
////            OutputStream pdf = new FileOutputStream(new File(pdfFileName));
////            pdf.write(fo2PDF(foDoc));
////        } catch (FileNotFoundException e) {
////            System.out.println("Error creating PDF: " + pdfFileName);
////        } catch (IOException e) {
////            System.out.println("Error writing PDF: " + pdfFileName);
////        }
//
//
//
//        /*Other*/
//        Document xml = getXML("./Convert/hello.html");
//        Document fo = xml2FO(xml);
//        OutputStream pdf = new FileOutputStream("./Convert/cPDF.pdf");
//        pdf.write(fo2PDF(fo, Converter.class.getResourceAsStream("com/shishpordenis/resourse/xhtml2fo.xsl")));
//        pdf.close();
//    }
//    /*Other*/
//    private static Document getXML(String html) throws IOException, ParserConfigurationException {
////        InputStream file = Converter.class.getResourceAsStream("com/shishpordenis/resourse/hello.html");
////        if (file == null) {
////            System.out.println("файл не найдет");
////        }
////        HtmlCleaner cleaner = new HtmlCleaner();
////        CleanerProperties properties = cleaner.getProperties();
////        DomSerializer serializer = new DomSerializer(properties, true);
////        TagNode tagNode = cleaner.clean(file);
////        return serializer.createDOM(tagNode);
//
//        Tidy tidy = new Tidy();
//        FileInputStream input =null;
//        try {
//            input = new FileInputStream(html);
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found " + html);
//        }
//        Document xmlDoc = tidy.parseDOM(input, null);
//
//        return xmlDoc;
//    }
//
//    private static Document xml2FO(Document xml/*, String styleSheet*/) throws TransformerConfigurationException {
////        DOMSource xmlDomSource = new DOMSource(xml);
////        DOMResult domResult = new DOMResult();
////
////        XsltURIResolver xsltURIResolver = new XsltURIResolver();
////
////        Transformer transformer = xsltURIResolver.getTransformer(styleSheet); /*getTransformer(styleSheet);*/
////
////        if (transformer == null) {
////            System.out.println("Error creating transformer for " + styleSheet);
////            System.exit(1);
////        }
////        try {
////            transformer.transform(xmlDomSource, domResult);
////        } catch (TransformerException e) {
////            return null;
////        }
////        return (Document) domResult.getNode();
//
//        /*Other*/
//        DOMSource xmlDomSource = new DOMSource(xml);
//        DOMResult domResult = new DOMResult();
//
//        TransformerFactory tFactory = TransformerFactory.newInstance();
//        Transformer transformer = tFactory.newTransformer();
//
//        if (transformer == null) {
//            System.out.println("Error creating transformer");
//            System.exit(1);
//        }
//
//        try {
//            transformer.transform(xmlDomSource, domResult);
//        } catch (TransformerException e) {
//            e.printStackTrace();
//        }
//        return (Document) domResult.getNode();
//    }
//
//    private static byte[] fo2PDF(Document foDocument, InputStream styleSheet) {
////        DocumentInputSource fopInputSource = new DocumentInputSource(foDocument);
////
////        try {
////            ByteArrayOutputStream out = new ByteArrayOutputStream();
////            Logger logger = new ConsoleLogger(ConsoleLogger.LEVEL_DEBUG);
////
////            Driver driver = new Driver(fopInputSource, out);
////            driver.setLogger(logger);
////            driver.setRenderer(Driver.RENDER_PDF);
////            driver.run();
////
////            return out.toByteArray();
////        } catch (Exception ex) {
////            return null;
////        }
//
//
//            /*Other*/
//        FopFactory fopFactory = FopFactory.newInstance();
//
//        try {
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
//            Transformer transformer = getTransformer(styleSheet);
//
//            Source source = new DOMSource(foDocument);
//            Result result = new SAXResult(fop.getDefaultHandler());
//
//            transformer.transform(source, result);
//            return out.toByteArray();
//        } catch (FOPException e) {
//            e.printStackTrace();
//            return null;
//        } catch (TransformerException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//
//    }
//    //
//    private static Transformer getTransformer(InputStream styleSheet) {
//        try {
//            TransformerFactory tFactory = TransformerFactory.newInstance();
//            //tFactory.setURIResolver(new XsltURIResolver());
//            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
//
//            dFactory.setNamespaceAware(true);
//
//
//
//            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
//            Document xslDoc = dBuilder.parse(styleSheet);
//            DOMSource xslDomSource = new DOMSource(xslDoc);
//
//            return tFactory.newTransformer(xslDomSource);
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//            return null;
//        } catch (SAXException e) {
//            e.printStackTrace();
//            return null;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        } catch (TransformerConfigurationException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
////    public void convertToPDF() throws IOException, FOPException, TransformerException {
////        File xsltFile = new File("R:\\Temp\\template.xsl");
////        StreamSource xmlSource = new StreamSource(new File("R:\\Temp\\Employees.xml"));
////        FopFactory fopFactory = FopFactory.newInstance();
////        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
////        OutputStream out = new FileOutputStream("R:\\Temp\\Employees.pdf");
////
////        try {
////            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
////
////            TransformerFactory factory = TransformerFactory.newInstance();
////            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
////
////            Result result = new SAXResult(fop.getDefaultHandler());
////
////            transformer.transform(xmlSource, result);
////        } finally {
////            out.close();
////        }
////    }
////
////    public void convertToFO() throws IOException, TransformerException {
////
////        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
////
////        File xsltFile = new File("R:\\Temp\\template.xsl");
////        StreamSource xmlSource = new StreamSource(new File("R:\\Temp\\Employees.xml"));
////        OutputStream out = new FileOutputStream("R:\\Temp\\temp.fo");
////
////        try {
////            TransformerFactory factory = TransformerFactory.newInstance();
////            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
////            Result result = new StreamResult(out);
////
////             transformer.transform(xmlSource, result);
////             transformer.transform(xmlSource, result);
////        } finally {
////            out.close();
////        }
////    }
//
//
//
//
////    public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
////        TransformerFactory tf = TransformerFactory.newInstance();
////        Transformer transformer = tf.newTransformer();
////        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
////        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
////        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
////        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
////        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
////
////        transformer.transform(new DOMSource(doc),
////                new StreamResult(new OutputStreamWriter(out, "UTF-8")));
////    }
//
//
//
//}
