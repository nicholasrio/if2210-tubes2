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

import java.awt.Font;
import java.io.IOException;

public class LabelComponent extends GUIComponent {

    private final String text;
    private int width;
    private int height;
    private final Font f;

    /**
     * the component is constructed w/ desired string
     * @param str
     * @param opt
     * @param _f
     * @throws IOException
     */
    public LabelComponent(String str, int opt, Font _f) throws IOException {
        super("label", opt);
        text = str;
        f = _f;
    }

    /**
     *
     * @return the displayed text
     */
    public String getDisplayed() {
        return text;
    }

    /**
     * get the width of the text
     * @return
     */
    @Override
    protected int getWidth() {
        return width;
    }

    /**
     *
     * @return the height of the text
     */
    @Override
    protected int getHeight() {
        return height;
    }

    /**
     * set the width of the text
     * @param _width
     */
    public void setWidth(int _width) {
        width = _width;
    }

    /**
     * set the height of the text
     * @param _height
     */
    public void setHeight(int _height) {
        height = _height;
    }

    /**
     * get the font of the text
     * @return
     */
    public Font getFont() {
        return f;
    }
}