package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Mamat Rahmat / 135120007
 */
public class DOC extends MyFile {

    public boolean isPDF() {
        return false;
    }

    public void setEkstensi(String _ekstensi) {
        ekstensi   =    _ekstensi;

    }

    public void toPDF() {
        try {
            // 1) Load DOCX into XWPFDocument
            InputStream is = new FileInputStream(new File(path));
            XWPFDocument document = new XWPFDocument(is);

            // 2) Prepare Pdf options
            PdfOptions options = PdfOptions.create();

            // 3) Convert XWPFDocument to Pdf
            OutputStream out = new FileOutputStream(new File(path + ".pdf"));
            PdfConverter.getInstance().convert(document, out, options);

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println("DOC");
    }
}
