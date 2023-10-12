import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*; 
public class gameArea  extends JPanel{
    /**
    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
    */
    public static final int CANVAS_WIDTH = 400;
    public static final int CANVAS_HEIGHT = 140;
    public static final Color FILL_COLOR = Color.RED;
    public static final Color LINE_COLOR = Color.WHITE;
    public static final Color CANVAS_BACKGROUND = Color.BLACK;

    private int x1 = CANVAS_WIDTH / 8;
    private int y1 = CANVAS_HEIGHT / 8;
    private int w = CANVAS_HEIGHT / 4;
    private int h = CANVAS_HEIGHT / 4;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(CANVAS_BACKGROUND);
        g.setColor(FILL_COLOR);
        g.fillRect(x1+1, y1+1, w-1, h-1);
        g.setColor(LINE_COLOR);
        g.drawRect(x1, y1, w, h); // Draw the line
    }

    int getX1(){
        return this.x1;
    }

        int getY1(){
        return this.y1;
    }

        int getW(){
        return this.w;
    }

        int getH(){
        return this.h;
    }

    int setX1(int i){
        return this.x1 =i;
    }

        int setY1(int i){
        return this.y1 =i;
    }

        int setW(int i){
        return this.w =i;
    }

        int setH(int i){
        return this.h =i;
    }

}
