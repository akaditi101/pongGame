import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.imageio.ImageIO;
import javax.lang.model.util.ElementScanner14;

import java.awt.Image;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.awt.image.BufferedImage;

    public class Mover extends JPanel implements ActionListener, KeyListener
{
    Timer t = new Timer(0, this);
    int x = 10, y = 10, a = 450, b = 550, vela = 0, velb = 0, velx = 0, vely = 0, score= 0;
    int up, down, right, left;

    public Mover()
    {
        t.start();
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }
    BufferedImage img = null;
    Color c = new Color(10,10,255);
    Color r = new Color(200,0,0);
        Color gr = new Color(0,200,0);
        Color bl = new Color(0, 0, 0);
        Color white = new Color(200, 200, 200);
        int randNum;
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //start
       
                g2.setStroke(new BasicStroke(50));
                g2.setColor(r);
                g2.fillRect(0, 0, 1000, 700);
                g2.setColor(gr);
                g2.fillRect(a, b, 200, 50);
                
        
                g2.setColor(c);
                g2.fillOval(x, y, 50, 50);
                g2.setColor(white);
                g2.fillRect(830, 610, 150, 50);
                g2.setColor(bl);
                Font font = new Font("Serif", Font.PLAIN, 30);
                g2.setFont(font);
                String str = "Score: " + score;
                g2.drawString(str, 850, 650);
                Color loser = new Color(50, 25, 89);
                boolean done = false;
                if (lost)
                {
                    g2.setColor(loser);
                    g2.fillRect(0, 0, 1000, 700);
                    font = new Font("Serif", Font.PLAIN, 40);
                    String l = "You lost with a score of: " + score;
                    g2.setFont(font);
                    g2.setColor(bl);
                    g2.drawString(l, 300, 300);
                    done = true;
                    
                    
                }
                if (done)
                    try{TimeUnit.SECONDS.sleep(1);} catch (Exception e){};
                
   }
   double slope = 0;
        int temp;
        boolean lost;
        public void actionPerformed(ActionEvent e)
    {
        repaint();
        if (y > 501)
            lost = true;

        if (a+vela < 950 && a+vela > 0 )
            a+=vela;

        if (x + 25 > a && x < a + 200 && y >500 && y < 555)
        {
            
            //slope = vely/velx;
            //temp = vely;
            velx = 1;
            vely = -1 * vely;
            randNum = (int) (Math.random() * 9) + 1;
            if (randNum < 3)
                velx = 0;
            else if (randNum < 6)
                velx = -1;
            
            x +=velx;
            x +=velx;
            y += vely;
            score ++;
            System.out.println("done");
        }
        else if (x >980)
        {
            randNum = (int) (Math.random() * 10);
            
            velx = -1;
            vely = -1;
            if (randNum < 5)
                vely = 1;
            System.out.println("WRONG");
            x +=velx;
            y += vely;
        }
        else if (y < 10)
        {
            velx = -1;
            vely = 1;
            randNum = (int) (Math.random() * 10);
            System.out.println(randNum);
            if (randNum < 5)
                velx = 1;
            x +=velx;
            y += vely;
        }
        else if (x < 10)
        {
            velx = 1;
            vely = 1;
            randNum = (int) (Math.random() * 10);
            if (randNum < 5)
                vely = -1;
            x +=velx;
            y += vely;
        }
        else
        {   x +=velx;
            y += vely;
        }
    }

    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE)
        {
            velx = 1;
            vely = 1;
        }
    
        if (code == KeyEvent.VK_LEFT){
           vela= -1;
           

        }
        if (code == KeyEvent.VK_RIGHT){
            vela = 1;
            
            
        }
       
        }
    

    
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
}


