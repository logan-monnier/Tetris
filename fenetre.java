import javax.swing.*;
import java.awt.event.*;

public class fenetre extends JFrame {

   public fenetre() {
      super("Tetris");

      WindowListener l = new WindowAdapter() {
         public void windowClosing(WindowEvent e){
            System.exit(0);
         }
      };

      addWindowListener(l);
      ImageIcon img = new ImageIcon("test.gif");
      JButton bouton = new JButton("Mon bouton",img);

      JPanel panneau = new JPanel();
      panneau.add(bouton);
      setContentPane(panneau);
      setSize(1000,600);
      setVisible(true);
   }

   public static void main(String [] args){
      JFrame frame = new fenetre();
   }
}