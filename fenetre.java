import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*;    // Using Swing's components and containers
/**
 * Custom Graphics Example: Using key/button to move a line left or right.
 */
@SuppressWarnings("serial")
public class fenetre extends JFrame {
   // Define constants for the various dimensions

   public fenetre() {
      // Set up a custom drawing JPanel
      setSize(400, 600);
      setLayout(null);
      add(new gameArea(6));

      // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
      // setTitle("Move a Line");
      // pack();           // pack all the components in the JFrame
      // setVisible(true); // show it
      // requestFocus();   // set the focus to JFrame to receive KeyEvent
   }

   

   // The entry main() method
   public static void main(String[] args) {
      // Run GUI codes on the Event-Dispatcher Thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new fenetre().setVisible(true); // Let the constructor do the job
         }
      });
   }
}