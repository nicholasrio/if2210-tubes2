package file;

import java.awt.print.PrinterException;
import java.io.IOException;
import javax.print.PrintService;

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

	public abstract void print(PrintService service) throws IOException, PrinterException;

}
