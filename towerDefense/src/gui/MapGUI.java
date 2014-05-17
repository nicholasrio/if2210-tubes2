
import java.awt.*;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.Map;

class MapGUI {

    public JFrame mainFrame;
    private JPanel optionPanel;
    private JPanel status;
    public JPanel option;
    public int state;
    private ImageViewer pictureCanvas;

    public MapGUI() throws IOException {
        mainFrame = new JFrame("Tower Defense v1.0");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(1200, 700);

        optionPanel = new JPanel();
        optionPanel.setLayout(new BorderLayout());
        optionPanel.setBackground(Color.BLUE);
        optionPanel.setBounds(100, 100, 200, 360);

        status = new JPanel();
        status.setPreferredSize(new Dimension(100, 250));
        Border compound;
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
        compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        status.setBorder(compound);

        option = new JPanel();
        option.setLayout(new BoxLayout(option, BoxLayout.PAGE_AXIS));
        setOption(0);
        
        pictureCanvas = new ImageViewer(this);
        pictureCanvas.addImage("0.jpg"); //0
        pictureCanvas.addImage("bottom-left.jpg"); //1
        pictureCanvas.addImage("bottom-right.jpg"); //2
        pictureCanvas.addImage("left-right.jpg"); //3
        pictureCanvas.addImage("up-down.jpg"); //4 
        pictureCanvas.addImage("up-left.jpg"); //5
        pictureCanvas.addImage("up-right.jpg"); //6

        pictureCanvas.setBounds(0, 0, 940, 360);
        //pictureCanvas.setIgnoreRepaint(true);
        //pictureCanvas.we();

        //mainFrame.add(titleBlock, BorderLayout.PAGE_START);
        mainFrame.add(pictureCanvas, BorderLayout.WEST);
        mainFrame.add(optionPanel, BorderLayout.CENTER);
        optionPanel.add(status, BorderLayout.NORTH);
        optionPanel.add(option, BorderLayout.CENTER);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        //pictureBlock.setMaximumSize(new Dimension(Integer.valueOf(100), Integer.valueOf(100)));

        pictureCanvas.setBackground(Color.red);

        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        MapGUI map = new MapGUI();
    }
    
    public void setOption(int n) {
        switch (n) {
            case 0:
                option.removeAll();
                option.add(new JLabel("This is Sparta"));
                break;
            case 1:
                option.removeAll();
                option.add(new JLabel("Tower Cost 9999"));
                option.add(new JButton("Build Tower"));
                break;
            case 2:
                break;
            default:
                assert(false) : "Option can't be other than 0, 1, or 2";
        }
        option.updateUI();
    }
}

class ImageViewer extends Canvas implements MouseListener {

    private ArrayList<Image> image;
    private String path;
    private MapGUI reference;
    public final int SIZE = 47;
    public final int ROW = 15;
    public final int COL = 20;

    public ImageViewer(MapGUI alpha) {
        addMouseListener(this);
        reference = alpha;
        image = new ArrayList<>();
        path = "img/";
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
        try {
            peta.readFile();
        } catch (IOException ex) {

            System.out.println("File not found");
        }

        for (int i = 0; i < COL; i++) {
            System.out.println("loop i");
            for (int j = 0; j < ROW; j++) {
                System.out.println("loop j");
                if (peta.Peta[j][i] == 256) {
                    System.out.println("rumput");
                    g.drawImage(image.get(0), i * SIZE, j * SIZE, SIZE, SIZE, this);
                } else {
                    System.out.println("masuk ke else");

                    int last4bit = peta.Peta[j][i] >> 4;
                    switch (last4bit) {
                        case 5: {
                            g.drawImage(image.get(3), i * SIZE, j * SIZE, SIZE, SIZE, this);
                            break;
                        }
                        case 3: {
                            g.drawImage(image.get(6), i * SIZE, j * SIZE, SIZE, SIZE, this);
                            break;
                        }
                        case 9: {
                            g.drawImage(image.get(2), i * SIZE, j * SIZE, SIZE, SIZE, this);
                            break;
                        }
                        case 6: {
                            g.drawImage(image.get(5), i * SIZE, j * SIZE, SIZE, SIZE, this);
                            break;
                        }
                        case 10: {
                            g.drawImage(image.get(4), i * SIZE, j * SIZE, SIZE, SIZE, this);
                            break;
                        }
                        case 12: {
                            g.drawImage(image.get(1), i * SIZE, j * SIZE, SIZE, SIZE, this);
                            break;
                        }
                        default:
                            assert (false);
                    }
                }

                //g.drawImage(image.get(i%5), i % 20 * 50, i / 20 * 50, 50, 50, this);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("mouseClicked");
        int row = me.getY() / SIZE;
        int col = me.getX() / SIZE;
        if (Map.Peta[row][col] == 256) {
            reference.setOption(1);
        } else {
            reference.setOption(0);
        }
        //reference.option.setVisible(false);
        reference.option.repaint();
        //reference.option.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
