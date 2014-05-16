/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.Exception;

/**
 *
 * @author Winson
 */
public class SceneNotFoundException extends Exception{
    public SceneNotFoundException(){
        super("Scene does not exist");
    }
}
