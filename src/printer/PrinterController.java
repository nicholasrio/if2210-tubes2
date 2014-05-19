/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printer;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Scanner;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.event.PrintServiceAttributeListener;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author adwisatya
 */
public class PrinterController {
    public static PrintService choosePrinter() {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        if(printJob.printDialog()) {
            return printJob.getPrintService();          
        }
        else {
            return null;
        }
    }

    public static void printPDF(String fileName, PrintService printer)
            throws IOException, PrinterException {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintService(printer);
        PDDocument doc = PDDocument.load(fileName);
        doc.silentPrint(job);
    }
}
