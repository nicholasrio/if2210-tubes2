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

package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageComponent extends GUIComponent {

    private final BufferedImage img_unclicked;
    private final BufferedImage img_clicked;
    private BufferedImage img_displayed;

    /**
     * constructor ImageComponent followed by Component
     * @param str
     * @param opt
     * @throws IOException
     */
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

    /**
     * The displayed image is set by the _img_displayed
     * @param _img_diplayed
     */
    public void setDisplayed(BufferedImage _img_diplayed) {
        dirtyBit = true;
        img_displayed = _img_diplayed;
    }

    /**
     * Get the clicked image
     * @return
     */
    public BufferedImage getClicked() {
        return img_clicked;
    }

    /**
     * Get the unclicked image
     * @return
     */
    public BufferedImage getUnclicked() {
        return img_unclicked;
    }

    /**
     * Get current displayed image
     * @return
     */
    public BufferedImage getDisplayed() {
        dirtyBit = false;
        return img_displayed;
    }

    /**
     * get the width of the displayed image
     * @return
     */
    @Override
    protected int getWidth() {
        return img_displayed.getWidth();
    }

    /**
     * get the height of the displayed image
     * @return
     */
    @Override
    protected int getHeight() {
        return img_displayed.getHeight();
    }
}


