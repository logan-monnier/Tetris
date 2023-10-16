// Using AWT's Graphics and Color
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
// Using AWT's event classes and listener interface
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

// Using Swing's components and containers
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
/**
 * Custom Graphics Example: Using key/button to move a line left or right.
 */
@SuppressWarnings("serial")
public class fenetre extends JFrame {
   // Define constants for the various dimensions
   static List<Integer> grid = new ArrayList<Integer>();
   public fenetre() {
      // Set up a custom drawing JPanel
      gameArea canvas = new gameArea(10, 20);
      canvas.setPreferredSize(new Dimension(500, 600));
 
      // Add both panels to this JFrame's content-pane
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(canvas, BorderLayout.CENTER);
      // Set up a custom drawing JPanel
      //setSize(400, 600);
      //setLayout(null);
      //add(new gameArea(6));

      // "super" JFrame fires KeyEvent
      addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent evt) {
            switch(evt.getKeyCode()) {
               case KeyEvent.VK_LEFT:
                  canvas.left();
                  repaint();
                  break;
               case KeyEvent.VK_RIGHT:
                  canvas.right();
                  repaint();
                  break;
            }
         }
      });

      final Timer timer = new Timer(800, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            canvas.fall();
            repaint();
         }
      });
      timer.start();
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
      setTitle("Tetris");
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
            new fenetre().setVisible(true); // Let the constructor do the job
         }
      });
   }
}