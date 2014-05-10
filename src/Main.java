/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author William Stefan
 */
public class Main extends JPanel implements Runnable{
    private Vehicle V;
    int x,y;
    
    public Main(){
        JFrame j = new JFrame("Coba");        
        V = new Vehicle();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(400, 300);
        j.setLocationRelativeTo(null);
        j.setTitle("Vehicle - Type");
        j.setResizable(false);
        j.add(this);
        j.setVisible(true);
        x=0;
        y=0;
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g.drawImage(V.getImage(),0, 0, x, y, null);
        x++;
        y++;
    }
    
    @Override
    public void run()
    {
        while(true){
            repaint();
        }
    }
    
    public static void main(String arg[])
    {
        Main main = new Main();
        Thread t1 = new Thread(main);
        t1.start();
    }
}