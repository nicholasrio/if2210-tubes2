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
import printer.*;

/**
 *
 * @author Mamat Rahmat / 135120007
 */
public abstract class MyFile {

	public String nama;
	public String path;
	public String uploader;
	public String ekstensi;

	public abstract boolean isPDF();

	public abstract void setEkstensi(String _ekstensi);

	public abstract void toPDF();

	public abstract void print() throws IOException, PrinterException;

}
