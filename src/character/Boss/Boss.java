/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character.Boss;

import character.*;
import character.Skill.*;
import java.util.*;
import java.awt.Graphics2D;
/**
 *
 * @author kevinyu
 */
public abstract class Boss extends character.Character implements Fightable{
    
    /**
     * arraylist skill
     */
    protected ArrayList<Skill> skills;
    /**
     * integer for skill range
     */
    protected int[] skillRange = { 300 , 128 };
    /**
     * integer for skill delay
     */
    protected int[] skillDelay =  {60 , 30 }; //jenjang waktu penggunaan skill
    /**
     * long integer for skill last
     */
    protected long[] skillLast = { 0 , 0}; //waktu terakhir menggunakan skill
    
    /**
     * method update
     */
    public abstract void update();
    
    public void setSkillRange(int[] _skillRange){ skillRange = _skillRange; }
    public void setAttackRange(int _attackRange) { attackRange = _attackRange; }
    public void setSkillDelay(int[] _skillDelay) { skillDelay = _skillDelay; }
    /**
     * method check if get hitting
     * @param enemy 
     */
    public abstract void checkHitting(character.Character enemy);
    /**
     * method check skill range
     * @param enemy 
     */
    public abstract void checkSkillRange(character.Character enemy);
    /**
     * method check attack range
     * @param enemy 
     */
    public abstract void checkAttackRange(character.Character enemy);
    /**
     * method draw
     * @param g
     * @param offsetX
     * @param offsetY 
     */
    
    public abstract void draw (Graphics2D g,int offsetX,int offsetY);
    
    
}
