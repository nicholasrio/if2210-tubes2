/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.user;

/**
 * Exception untuk masukan pilihan dalam program utama user
 * @author CakBin
 */
public class OptionException extends Exception{
    public OptionException(String message){
        super(message);
    }
}
