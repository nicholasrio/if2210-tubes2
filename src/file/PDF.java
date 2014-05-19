package file;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Scanner;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.event.PrintServiceAttributeListener;
import org.apache.pdfbox.pdmodel.PDDocument;
import static printer.PrinterController.printPDF;

/**
 *
 * @author Mamat Rahmat / 135120007
 */
public class PDF extends MyFile {

	public boolean isPDF() {
		return true;
	}

	public void setEkstensi(String _ekstensi) {
		/*
		 if(super.nama.contains(".txt")){
		 super.ekstensi    =   "TXT";
		 }else if(nama.contains(".pdf")){
		 super.ekstensi    =   "PDF";
		 }else{
		 super.ekstensi    =   "DOC";
		 }
		 */
		ekstensi = _ekstensi;
	}

	public void toPDF() {

	}

	public void print(PrintService service) throws IOException, PrinterException {
		// TODO code application logic here
		printPDF("serverFolder/" + uploader + "/" + path, service);
	}
}
