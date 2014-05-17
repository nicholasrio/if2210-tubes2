
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

class MapClass {

    private JFrame mainFrame;
    private JPanel titleBlock;
    private ImageViewer pictureCanvas;

    public MapClass() throws IOException {
        mainFrame = new JFrame("peta peta peta");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(946, 700);
        //pictureBlock = new ImageViewer(/*fixed*//*new BoxLayout(pictureBlock, BoxLayout.LINE_AXIS)*/);

//        titleBlock = new JPanel();
//        titleBlock.setBackground(Color.blue);
//        titleBlock.setSize(300, 300);

        pictureCanvas = new ImageViewer();
//        mainFrame.setLayout(new FlowLayout());
        pictureCanvas.addImage("0.jpg"); //0
        pictureCanvas.addImage("bottom-left.jpg"); //1
        pictureCanvas.addImage("bottom-right.jpg"); //2
        pictureCanvas.addImage("left-right.jpg"); //3
        pictureCanvas.addImage("up-down.jpg"); //4 
        pictureCanvas.addImage("up-left.jpg"); //5
        pictureCanvas.addImage("up-right.jpg"); //6
        
        pictureCanvas.setBounds(0, 0, 1003, 360);
        //pictureCanvas.setIgnoreRepaint(true);

        //mainFrame.add(titleBlock, BorderLayout.PAGE_START);
        mainFrame.add(pictureCanvas, BorderLayout.WEST);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        //pictureBlock.setMaximumSize(new Dimension(Integer.valueOf(100), Integer.valueOf(100)));

        pictureCanvas.setBackground(Color.red);

        
        
        
//        mainFrame.pack();
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        MapClass map = new MapClass();
    }
}

class ImageViewer extends Canvas {

    ArrayList<Image> image;
    String path;
    public final int SIZE = 47;
    
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
        Map peta = new Map();
        try{
            peta.readFile(); 
        }catch (IOException ex){
            System.out.println("File not found");
        }
        
        
        
        for (int i=0; i<20; i++) {
            System.out.println("loop i");
            for (int j=0; j<15; j++){
                System.out.println("loop j");
                if(peta.Peta[j][i] == 256 ){
                    System.out.println("rumput");
                    g.drawImage(image.get(0), i * SIZE, j * SIZE, SIZE, SIZE, this);
                }
                else {
                    System.out.println("masuk ke else");

                    int last4bit = peta.Peta[j][i] >> 4;
                    switch (last4bit){
                        case 5 : {g.drawImage(image.get(3), i * SIZE, j * SIZE, SIZE, SIZE, this);
                                 break;}
                        case 3 : {g.drawImage(image.get(6), i * SIZE, j * SIZE, SIZE, SIZE, this);
                                 break;}
                        case 9 : {g.drawImage(image.get(2), i * SIZE, j * SIZE, SIZE, SIZE, this);
                                 break;}
                        case 6 : {g.drawImage(image.get(5), i * SIZE, j * SIZE, SIZE, SIZE, this);
                                 break;}
                        case 10 : {g.drawImage(image.get(4), i * SIZE, j * SIZE, SIZE, SIZE, this);
                                 break;}
                        case 12: {g.drawImage(image.get(1), i * SIZE, j * SIZE, SIZE, SIZE, this);
                                 break;}
                        default : assert(false);
                    }
                }

                //g.drawImage(image.get(i%5), i % 20 * 50, i / 20 * 50, 50, 50, this);
            }
        }
    }
}
