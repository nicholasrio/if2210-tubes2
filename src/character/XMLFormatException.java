/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character;

/**
 *
 * @author yafithekid
 */
public class XMLFormatException extends Exception{
    @Override
    public String getMessage(){
        return "XML format error";
    }
}
