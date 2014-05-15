/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javagame;

/**
 *
 * @author Luqman
 */
public abstract class Scene implements Drawable, Updateable {
    protected String name;
    
    public Scene()
    {
    }

    public abstract void initialize();


    public abstract void terminate();

    public String getName() {
        return name;
    }
}
