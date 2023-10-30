// Using AWT's Graphics and Color
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Color;

// Using AWT's event classes and listener interface
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
// Using Swing's components and containers
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
@SuppressWarnings("serial")
public class fenetre extends JFrame {
   static List<Color> grid = new ArrayList<Color>();
   private block block;
   private block nextblock;
   private gameArea canvas;
   private int canvasWidth = 500;
   private int canvasHeight = 600;

   private JButton btn;
   private JButton quitBtn;
   
   public fenetre() {
      this.canvas = new gameArea(10, 20);
      this.canvas.setPreferredSize(new Dimension(this.canvasWidth, this.canvasHeight));

      btn = new JButton("Play");
      btn.setBounds(200,200,100,30);
      quitBtn = new JButton("Quit");
      quitBtn.setBounds(200,250,100,30);

      Listener listen = new Listener();
      btn.addActionListener(listen);
      quitBtn.addActionListener(listen);

      canvas.addKeyListener(listen);
      
      canvas.add(this.btn);
      canvas.add(this.quitBtn);
 
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(this.canvas, BorderLayout.CENTER);
      
      this.newGame();

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
      setTitle("Tetris");
      setLocationRelativeTo(null);
      pack();           // pack all the components in the JFrame
      setVisible(true); // show it
      requestFocus();   // set the focus to JFrame to receive KeyEvent
   }

   class Listener implements KeyListener, ActionListener{
      @Override
      public void keyPressed(KeyEvent evt) {
         System.out.println(evt.getKeyCode());
         if(canvas.getMenu() != 0){
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
               case KeyEvent.VK_SPACE:
                  if (!timer.isRunning()){
                     newGame();
                  }
                  repaint();
                  break;
            }
         }
      }

      @Override
      public void keyTyped(KeyEvent e) {
         // TODO Auto-generated method stub
      }

      @Override
      public void keyReleased(KeyEvent e) {
         // TODO Auto-generated method stub
      }

      @Override
      public void actionPerformed(ActionEvent e){
         if(e.getSource() == btn){
            removeBtn();
            canvas.addMenu();
         }
         else if(e.getSource() == quitBtn){
            System.exit(0);
         }
         canvas.requestFocusInWindow();
      }
   }

   public void removeBtn(){
      canvas.remove(this.btn);
      canvas.remove(this.quitBtn);
   }

   final Timer timer = new Timer(800, new ActionListener() {
      // manage to delete line full of block 
      public void actionPerformed(ActionEvent e) {
         if(canvas.getMenu() != 0){
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
                     canvas.addScore();
                  }
                  if((i+1)%(gameArea.nbColumns) == 0){
                     count = 0;
                  }
               }
               block = nextblock;
               nextblock = newBlock();
               canvas.setBlock(block, nextblock);
               for(int p : block.getPositions()){
                  if(grid.get(p) != Color.BLACK){
                     loose();
                  }
               }
            }
            repaint();
         }
      }
   });

   public block newBlock(){
      int rand = (int)(Math.random() * 7);
      block b = new Iblock();
      switch(rand){
         case 0:
            b = new Iblock();
            break;
         case 1:
            b = new Jblock();
            break;
         case 2:
            b = new Lblock();
            break;
         case 3:
            b = new Oblock();
            break;
         case 4:
            b = new Sblock();
            break;
         case 5:
            b = new Tblock();
            break;
         case 6:
            b = new Zblock();
            break;
      }
      return b;
   }

   public void newGame(){
      this.block = this.newBlock();
      this.nextblock = this.newBlock();
      this.canvas.setBlock(block, nextblock);
      this.canvas.startAgain();
      timer.start();
   }

   public void loose(){
      this.canvas.hasLoosed();
      timer.stop();
   }

   public static void start(){
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new fenetre().setVisible(true); // Let the constructor do the job
         }
      });
   }
}