/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Opel Howard
 */
public class ImageComponent extends GUIComponent {

    private final BufferedImage img_unclicked;
    private final BufferedImage img_clicked;
    private BufferedImage img_displayed;

    public ImageComponent(String str, int opt) throws IOException {
        super("image", opt);
        if (new File("img\\" + str + ".png").exists()) {
            img_displayed = ImageIO.read(new File("img\\" + str + ".png"));
        }

        if (new File("img\\" + str + "_unclicked.png").exists()) {
            img_displayed = img_unclicked = ImageIO.read(new File("img\\" + str + "_unclicked.png"));
        } else {
            img_unclicked = null;
        }
        if (new File("img\\" + str + "_clicked.png").exists()) {
            img_clicked = ImageIO.read(new File("img\\" + str + "_clicked.png"));
        } else {
            img_clicked = null;
        }
    }

    public void setDisplayed(BufferedImage _img_diplayed) {
        dirtyBit = true;
        img_displayed = _img_diplayed;
    }

    public BufferedImage getClicked() {
        return img_clicked;
    }

    public BufferedImage getUnclicked() {
        return img_unclicked;
    }

    public BufferedImage getDisplayed() {
        dirtyBit = false;
        return img_displayed;
    }

    @Override
    protected int getWidth() {
        return img_displayed.getWidth();
    }

    @Override
    protected int getHeight() {
        return img_displayed.getHeight();
    }
}


