package com.shishpordenis;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

/**
 * Created by ((ZLoY)) on 23.05.2017.
 */
public class Printers {
    public String get() throws IOException {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null,null);
        StringBuilder builder = new StringBuilder();
        String getPrinters;

        JSONArray array = new JSONArray();
        JSONObject root = new JSONObject();
        JSONObject printers = new JSONObject();

        for(PrintService printer: printServices){
            array.add(printer.getName());
        }

        root.put("printers", array);

        getPrinters = root.toString();
        builder.append(getPrinters);


        return getPrinters;
    }

    public static void print(String pafName) throws Exception {
        PDDocument document = PDDocument.load(new File(pafName));

//        PrintService myPrintService = findPrintService("EPSON TX117_119 Series");

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPageable(new PDFPageable(document));
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            }catch (PrinterException ignored) {

            }

        }
    }

    private static PrintService findPrintService(String printerName) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService printService : printServices) {
            if (printService.getName().trim().equals(printerName)) {
                return printService;
            }
        }
        return null;
    }

}
