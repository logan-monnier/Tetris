import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*; 
public class gameArea  extends JPanel{
    /**
    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
    */
    public static final int CANVAS_WIDTH = 204;
    public static final int CANVAS_HEIGHT = 476;
    private int nbColumns;
    private int nbRow;
    private int cellSize;
  

    public gameArea(int columns){
        //setVisible(false);
        setBounds(150, 50, CANVAS_WIDTH, CANVAS_HEIGHT);
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.nbColumns = columns;
        this.cellSize = CANVAS_WIDTH / this.nbColumns;
        this.nbRow = CANVAS_HEIGHT / this.cellSize;



    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // g.setColor(Color.red);
        for(int j = 0 ; j < this.nbRow ; j ++){
            for(int i = 0 ; i < this.nbColumns; i++){
                g.drawRect(i*this.cellSize,j*this.cellSize,this.cellSize,this.cellSize);
        }

        }

    }

}
