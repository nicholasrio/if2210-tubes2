/**
 *
 * @author 
 * Darwin Prasetio (13512015)
 * Chrestella Stephanie (13512005)
 * Jan Wira Gotama Putra (13512015)
 * Eric (13512021)
 * Willy(13512070)
 * Melvin Fonda (13512085)
 */

import java.awt.*;
import java.awt.Canvas;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.omg.CORBA.FixedHolder;

class MapClass {

    private JFrame mainFrame;
    private JPanel titleBlock;
    private ImageViewer pictureCanvas;
    //private final BufferedImage image;

    public MapClass() throws IOException {
        mainFrame = new JFrame("peta peta peta");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(720, 360);
        //pictureBlock = new ImageViewer(/*fixed*//*new BoxLayout(pictureBlock, BoxLayout.LINE_AXIS)*/);

//        titleBlock = new JPanel();
//        titleBlock.setBackground(Color.blue);
//        titleBlock.setSize(300, 300);
//        pictureBlock.setBackground(Color.red);

        //pictureCanvas = new ImageViewer();
        pictureCanvas.addImage("left-right.jpg");
        pictureCanvas.addImage("left-right.jpg");
        pictureCanvas.addImage("left-right.jpg");
        pictureCanvas.addImage("left-right.jpg");
        pictureCanvas.addImage("bottom-left.jpg");

        pictureCanvas.setBounds(0, 0, 720, 360);
        //pictureCanvas.setIgnoreRepaint(true);

        //mainFrame.add(titleBlock, BorderLayout.PAGE_START);
        mainFrame.add(pictureCanvas, BorderLayout.CENTER);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        //pictureBlock.setMaximumSize(new Dimension(Integer.valueOf(100), Integer.valueOf(100)));

        pictureCanvas.setBackground(Color.red);

        mainFrame.pack();
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        MapClass map = new MapClass();
    }
}

/*class ImageViewer extends Canvas {

    ArrayList<Image> image;
    String path;

    public ImageViewer() {
        image = new ArrayList<>();
        path = "src/img/";
    }

    public void addImage(String str) throws FileNotFoundException, IOException {
        String fullpath = path + str;
        Image mini = ImageIO.read(new FileInputStream(fullpath));
        image.add(mini);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < image.size(); ++i) {
            g.drawImage(image.get(i),  i % 20 * 70, i / 20 * 70, 100, 100, this);
        }
    }
}*/
