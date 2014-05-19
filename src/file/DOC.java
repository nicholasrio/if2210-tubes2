package file;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import static printer.PrinterController.printPDF;

/**
 *
 * @author Mamat Rahmat / 135120007
 */
public class DOC extends MyFile {

	public boolean isPDF() {
		return false;
	}

	public void setEkstensi(String _ekstensi) {
		ekstensi = _ekstensi;

	}

	public void toPDF() {
		try {
			// 1) Load DOCX into XWPFDocument
			InputStream is = new FileInputStream(new File("serverFolder/" + uploader + "/" + path));
			XWPFDocument document = new XWPFDocument(is);

			// 2) Prepare Pdf options
			PdfOptions options = PdfOptions.create();

			// 3) Convert XWPFDocument to Pdf
			OutputStream out = new FileOutputStream(new File("serverFolder/" + uploader + "/" + path + ".pdf"));
			PdfConverter.getInstance().convert(document, out, options);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void print(javax.print.PrintService service) throws IOException, PrinterException {
		toPDF();
                PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
		printPDF("serverFolder/" + uploader + "/" + path + ".pdf", printServices[4]);
	}
}
