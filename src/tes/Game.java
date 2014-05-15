/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tes;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javagame.*;
import javax.swing.JFrame;
import tes.scene.*;
/**
 *
 * @author Luqman
 */
public class Game{

   public void start(){
        JFrame frame = new JFrame("TheRiseOfYuu");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLayout(new BorderLayout());
    	
    	frame.add(new GamePanel());
    	
    	frame.setSize(800, 500);
    	frame.setVisible(true);
   }
}
