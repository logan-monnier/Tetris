// Using AWT's Graphics and Color
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Color;

// Using AWT's event classes and listener interface
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

// Using Swing's components and containers
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
@SuppressWarnings("serial")
public class fenetre extends JFrame {
   static List<Color> grid = new ArrayList<Color>();
   private block block;
   private int score=0;
   public fenetre() {

      gameArea canvas = new gameArea(10, 20);
      canvas.setPreferredSize(new Dimension(500, 600));

      JLabel label = new JLabel(("Score :" + score),JLabel.CENTER);
      label.setForeground(Color.WHITE);
      label.setBounds(50,200,200,200);
      canvas.add(label);

      block = new Tblock();
      canvas.setBlock(block);
 
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(canvas, BorderLayout.CENTER);

      // "super" JFrame fires KeyEvent
      addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent evt) {
            switch(evt.getKeyCode()) {
               case KeyEvent.VK_LEFT:
                  block.moveLeft();
                  repaint();
                  break;
               case KeyEvent.VK_RIGHT:
                  block.moveRight();
                  repaint();
                  break;
               case KeyEvent.VK_DOWN:
                  block.fall();
                  repaint();
                  break;
               case KeyEvent.VK_B:
                  block.spinLeft();
                  repaint();
                  break;
               case KeyEvent.VK_N:
                  block.spinRight();
                  repaint();
                  break;
            }
         }
      });

      final Timer timer = new Timer(800, new ActionListener() {
         // manage to delete line full of block 
         public void actionPerformed(ActionEvent e) {
            int rand;
            if(!block.fall()){
               for(int p : block.getPositions()){
                  grid.set(p, block.getColor());
               }
               int count = 0;
               for(int i = 0; i < grid.size(); i++){
                  if (grid.get(i) != Color.BLACK){
                     count++;
                  }
                  if (count == gameArea.nbColumns){
                     for(int j = i; j>gameArea.nbColumns; j--){
                        grid.set(j, grid.get(j-gameArea.nbColumns));
                     }
                     score ++;
                     label.setText("Score :"+score);
                  }
                  if((i+1)%(gameArea.nbColumns) == 0){
                     count = 0;
                  }
               }
               rand = (int)(Math.random() * 7);
               switch(rand){
                  case 0:
                     block = new Iblock();
                     break;
                  case 1:
                     block = new Jblock();
                     break;
                  case 2:
                     block = new Lblock();
                     break;
                  case 3:
                     block = new Oblock();
                     break;
                  case 4:
                     block = new Sblock();
                     break;
                  case 5:
                     block = new Tblock();
                     break;
                  case 6:
                     block = new Zblock();
                     break;
               }
               canvas.setBlock(block);
            }
            repaint();
         }
      });
      timer.start();
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
      setTitle("Tetris");
      setLocationRelativeTo(null);
      pack();           // pack all the components in the JFrame
      setVisible(true); // show it
      requestFocus();   // set the focus to JFrame to receive KeyEvent
   }

   

   public static void start() {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new fenetre().setVisible(true); // Let the constructor do the job
         }
      });
   }
}