package gui;

import controller.GameController;
import java.awt.*;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.Map;
import model.Monster;
import model.Tower;

/**
 * MapGUI is for the map
 * @author Opel Howard
 */
public class MapGUI {

    public GameController GController;
    public JFrame mainFrame;
    private JPanel optionPanel;
    public JPanel status;
    public JPanel option;
    public int state;
    private ImageViewer pictureCanvas;

    /**
     * the constructor for the MapGUI
     * @param _GController
     * @throws IOException
     */
    public MapGUI(GameController _GController) throws IOException {
        GController = _GController;
        mainFrame = new JFrame("Tower Defense");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(1200, 700);

        optionPanel = new JPanel();
        optionPanel.setLayout(new BorderLayout());
        optionPanel.setBackground(Color.BLUE);
        optionPanel.setBounds(100, 100, 200, 360);

        status = new JPanel();
        Border compound;
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
        compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        status.setBorder(compound);
        status.setLayout(new BoxLayout(status, BoxLayout.PAGE_AXIS));
        status.setPreferredSize(new Dimension(100, 250));
        changeStatus();
        option = new JPanel();
        option.setLayout(new BoxLayout(option, BoxLayout.PAGE_AXIS));
        setOption(0, -1);

        pictureCanvas = new ImageViewer(this);
        pictureCanvas.addImage("0.jpg"); //0
        pictureCanvas.addImage("bottom-left.jpg"); //1
        pictureCanvas.addImage("bottom-right.jpg"); //2
        pictureCanvas.addImage("left-right.jpg"); //3
        pictureCanvas.addImage("up-down.jpg"); //4 
        pictureCanvas.addImage("up-left.jpg"); //5
        pictureCanvas.addImage("up-right.jpg"); //6
        pictureCanvas.addImage("tower.jpg");

        pictureCanvas.setBounds(0, 0, 940, 360);
        
        mainFrame.add(pictureCanvas, BorderLayout.WEST);
        mainFrame.add(optionPanel, BorderLayout.CENTER);
        optionPanel.add(status, BorderLayout.NORTH);
        optionPanel.add(option, BorderLayout.CENTER);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        pictureCanvas.setBackground(Color.red);

        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    /**
     * Change the panel of the game
     */
    public void changeStatus() {
        assert (status != null);
        status.removeAll();
        status.add(new JLabel("Game Status   "));
        status.add(new JLabel("Player Name : " + GController.getPlayer().getName()));
        status.add(new JLabel("Current Level : " + GController.getCurrentLevel()));
        status.add(new JLabel("Score : " + GController.getScore()));
        status.add(new JLabel("Gold : " + GController.getGold()));
        status.add(new JLabel("Lives : " + GController.getLives()));
        JButton quitButton = new JButton("Quit Game");
        quitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GameController.menu = 7;
            }

        });
        JButton saveButton = new JButton("Save Game");
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GameController.menu = 5;
            }

        });
        JButton startButton = new JButton("Start Level");
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GameController.menu = 6;
                mainFrame.setVisible(true);
            }

        });
        status.add(quitButton);
        status.add(saveButton);
        status.add(startButton);
    }
    
    /**
     * add announcement of the x
     * @param x
     */
    public void addAnnouncement(String x) {
        status.add(new JLabel(x));
    }

    /**
     * show the window
     */
    public void show() {
        mainFrame.setVisible(true);
    }

    /**
     * hide the window
     */
    public void hide() {
        mainFrame.setVisible(false);
    }

    /**
     * the clicked button
     * @param n
     * @param idx
     */
    public void setOption(int n, int idx) {
        final int alpha = idx;
        JButton jButton1, jButton2;
        option.removeAll();
        switch (n) {
            case 0:
                break;
            case 1:
                option.add(new JLabel("Tower Cost " + Tower.towerCost));
                jButton1 = new JButton("Build Tower");
                jButton1.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GameController.menu = 1;
                        setOption(0, -1);
                    }

                });
                option.add(jButton1);
                break;
            case 2:
                jButton2 = new JButton("Sell Tower");
                jButton2.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GameController.menu = 2;
                        setOption(0, -1);
                    }

                });
                Tower tt = GController.getTower(idx);
                option.add(new JLabel("Level " + tt.getCurrentLevel()));
                option.add(new JLabel("Upgrade Cost " + tt.getUpgradeCost()));
                option.add(new JLabel("Attack " + tt.getAttack()));
                option.add(new JLabel("Range " + tt.getRange()));
                jButton1 = new JButton("Upgrade Tower");
                jButton1.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GameController.menu = 3;
                        setOption(2, alpha);
                    }

                });
                option.add(jButton1);
                option.add(jButton2);
                break;
            default:
                assert (false) : "Option can't be other than 0, 1, or 2";
        }
        option.updateUI();
    }
}

class ImageViewer extends Canvas implements MouseListener {

    private ArrayList<BufferedImage> image;
    private String path;
    private MapGUI reference;
    public static final int SIZE = 47;
    public static final int ROW = 15;
    public static final int COL = 20;
    private BufferedImage[] sprites;

    public ImageViewer(MapGUI alpha) throws IOException {
        addMouseListener(this);
        reference = alpha;
        image = new ArrayList<>();
        path = "img/";

        BufferedImage bigImg = ImageIO.read(new FileInputStream(path + "monster.png"));
        final int rows = 5;
        final int cols = 5;
        sprites = new BufferedImage[rows * cols];
        final int width = 50;
        final int height = 60;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sprites[(i * cols) + j] = bigImg.getSubimage(
                        j * width,
                        i * height,
                        width,
                        height
                );
            }
        }
    }

    public void addImage(String str) throws FileNotFoundException, IOException {
        String fullpath = path + str;
        BufferedImage mini = ImageIO.read(new FileInputStream(fullpath));
        image.add(mini);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                if (Map.Peta[j][i] == 256) {
                    g.drawImage(image.get(0), i * SIZE, j * SIZE, SIZE, SIZE, this);
                } else {

                    int last4bit = Map.Peta[j][i] >> 4;
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
            }
        }

        List<Tower> lot = reference.GController.getListOfTower();
        for (Tower tt : lot) {
            int i = tt.getPositionCol();
            int j = tt.getPositionRow();
            g.drawImage(image.get(7), i * SIZE, j * SIZE, SIZE, SIZE, this);
        }

        List<Monster> lom = reference.GController.getListOfMonster();
        for (Monster mm : lom) {
            if (mm.getHP()>0) {
                int i = mm.getCol();
                int j = mm.getRow();
                g.drawImage(sprites[0], i*SIZE, j*SIZE, SIZE, SIZE, this);
                g.setColor(Color.red);
                g.drawString(String.valueOf(mm.getHP()), i*SIZE, j*SIZE);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int row = me.getY() / SIZE;
        int col = me.getX() / SIZE;
        GameController.pos_row = row;
        GameController.pos_col = col;
        if (Map.Peta[row][col] == 256) {
            int idx = reference.GController.getTowerIdx(row, col);
            if (idx == -1) {
                reference.setOption(1, idx);
            } else {
                reference.setOption(2, idx);
            }
        } else {
            reference.setOption(0, -1);
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
