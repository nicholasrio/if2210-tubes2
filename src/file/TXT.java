package file;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author Mamat Rahmat / 135120007
 */
public class TXT extends MyFile {

    public boolean isPDF() {
        return false;
    }

    public void setEkstensi(String _ekstensi) {
        ekstensi   =    _ekstensi;

    }

    public void toPDF() {
        FileInputStream fis = null;
        DataInputStream in = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            File file = new File(path);
            Document pdfDoc = new Document();
            String output_file = path + ".pdf";
            PdfWriter writer = PdfWriter.getInstance(pdfDoc, new FileOutputStream(output_file));
            pdfDoc.open();
            pdfDoc.setMarginMirroring(true);
            pdfDoc.setMargins(36, 72, 108, 180);
            pdfDoc.topMargin();
            Font myfont = new Font();
            Font bold_font = new Font();
            bold_font.setStyle(Font.BOLD);
            bold_font.setSize(10);
            myfont.setStyle(Font.NORMAL);
            myfont.setSize(10);
            pdfDoc.add(new Paragraph("\n"));

            if (file.exists()) {

                fis = new FileInputStream(file);
                in = new DataInputStream(fis);
                isr = new InputStreamReader(in);
                br = new BufferedReader(isr);
                String strLine;

                while ((strLine = br.readLine()) != null) {

                    Paragraph para = new Paragraph(strLine + "\n", myfont);
                    para.setAlignment(Element.ALIGN_JUSTIFIED);
                    pdfDoc.add(para);
                }
            } else {

                System.out.println("no such file exists!");
            }
            pdfDoc.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }

    public void print() {
        System.out.println("TXT");
    }
}
