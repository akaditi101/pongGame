import javax.swing.*;
import java.awt.*;
//import java.util.*;//
//import java.awt.geom.Line2D;


public class App {
    public static void main(String[] args) {
         
      
        JFrame jf = new JFrame("Demo");
        Container cp = jf.getContentPane();
        Mover m = new Mover();
     
         jf.setSize(1000, 700);
         jf.add(m);
        jf.setVisible(true);
    }
}

