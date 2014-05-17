/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.Font;
import java.io.IOException;

/**
 *
 * @author Opel Howard
 */
public class LabelComponent extends GUIComponent {

    private final String text;
    private int width;
    private int height;
    private final Font f;

    public LabelComponent(String str, int opt, Font _f) throws IOException {
        super("label", opt);
        text = str;
        f = _f;
    }

    public String getDisplayed() {
        return text;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    public void setWidth(int _width) {
        width = _width;
    }

    public void setHeight(int _height) {
        height = _height;
    }

    public Font getFont() {
        return f;
    }
}