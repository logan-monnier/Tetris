import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*;    // Using Swing's components and containers
/**
 * Custom Graphics Example: Using key/button to move a line left or right.
 */
@SuppressWarnings("serial")
public class fenetre extends JFrame {
   // Define constants for the various dimensions
   public static final int CANVAS_WIDTH = 400;
   public static final int CANVAS_HEIGHT = 140;
 
   //The moving line from (x1, y1) to (x2, y2), initially position at the center
 
   private gameArea canvas; // The custom drawing canvas (an innder class extends JPanel)
 
   // Constructor to set up the GUI components and event handlers
   public fenetre() {
      // Set up a custom drawing JPanel
      canvas = new gameArea();
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
 
      // Add both panels to this JFrame's content-pane
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(canvas, BorderLayout.CENTER);
 
      // "super" JFrame fires KeyEvent
      addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent evt) {
            switch(evt.getKeyCode()) {
               case KeyEvent.VK_LEFT:
                  //x1 -= 10;
                  canvas.setX1(canvas.getX1() - 10);
                  repaint();
                  break;
               case KeyEvent.VK_RIGHT:
                  //x1 += 10;
                  canvas.setX1(canvas.getX1() + 10);
                  repaint();
                  break;
            }
         }
      });
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
      setTitle("Move a Line");
      pack();           // pack all the components in the JFrame
      setVisible(true); // show it
      requestFocus();   // set the focus to JFrame to receive KeyEvent
   }
 
   
 
   // The entry main() method
   public static void main(String[] args) {
      // Run GUI codes on the Event-Dispatcher Thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new fenetre(); // Let the constructor do the job
         }
      });
   }
}