/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

/**
 * interface of tile (is tile openable or not
 * @author Calvin
 */
public interface Openable {
    /**
     * open the tile
     */
    void open();
    /**
     * close the tile
     */
    void close();
    /**
     * check if the tile is open
     * @return boolean.
     */
    boolean isOpen();
}
