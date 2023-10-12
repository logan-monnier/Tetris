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
   public static final Color FILL_COLOR = Color.RED;
   public static final Color LINE_COLOR = Color.WHITE;
   public static final Color CANVAS_BACKGROUND = Color.BLACK;
 
   // The moving line from (x1, y1) to (x2, y2), initially position at the center
   private int x1 = CANVAS_WIDTH / 8;
   private int y1 = CANVAS_HEIGHT / 8;
   private int w = CANVAS_HEIGHT / 4;
   private int h = CANVAS_HEIGHT / 4;
 
   private DrawCanvas canvas; // The custom drawing canvas (an innder class extends JPanel)
 
   // Constructor to set up the GUI components and event handlers
   public fenetre() {
      // Set up a custom drawing JPanel
      canvas = new DrawCanvas();
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
                  x1 -= 10;
                  repaint();
                  break;
               case KeyEvent.VK_RIGHT:
                  x1 += 10;
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
 
   /**
    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
    */
   class DrawCanvas extends JPanel {
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         setBackground(CANVAS_BACKGROUND);
         g.setColor(FILL_COLOR);
         g.fillRect(x1+1, y1+1, w-1, h-1);
         g.setColor(LINE_COLOR);
         g.drawRect(x1, y1, w, h); // Draw the line
      }
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