import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*; 
public class gameArea  extends JPanel{
    /**
    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
    */
    private double canvasWidth = 500;
    private double canvasHeight = 600;
    public static final Color FILL_COLOR = Color.RED;
    public static final Color LINE_COLOR = Color.WHITE;
    public static final Color CANVAS_BACKGROUND = Color.BLACK;

    private int nbColumns;
    private int nbRow;
    private int cellSize;

    private int xCollumn = (int) Math.round(this.canvasWidth/2);
    private int yCollumn = (int) Math.round(this.canvasHeight/4);
    private int rectPos = 0;

    public gameArea(int columns, int rows){
        //setVisible(false);
        //setBounds(150, 50, this.canvasWidth, this.canvasHeight);
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.nbColumns = columns;
        this.nbRow = rows;
        this.cellSize = (int) Math.round(this.canvasWidth / this.nbColumns/2);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(CANVAS_BACKGROUND);
        // g.setColor(Color.red);
        this.canvasWidth = getWidth();
        this.canvasHeight = getHeight();
        this.xCollumn = (int) Math.round(this.canvasWidth/2);
        this.yCollumn = (int) Math.round(this.canvasHeight/4);
        this.cellSize = (int) Math.round((this.canvasHeight-this.yCollumn) / this.nbRow / 1.25);

        for(int j = 0 ; j < this.nbColumns ; j++){
            for(int i = 0 ; i < this.nbRow ; i++){
                g.setColor(Color.white); 
                g.drawRect(xCollumn+j*this.cellSize, yCollumn+i*this.cellSize, this.cellSize, this.cellSize);
        }}
        
        g.setColor(FILL_COLOR);
        g.fillRect(this.xCollumn + (int) Math.round(this.rectPos%this.nbColumns)*this.cellSize+1, this.yCollumn + (int) Math.round(this.rectPos/this.nbColumns)*this.cellSize+1, this.cellSize-1, this.cellSize-1);
        g.setColor(LINE_COLOR);
        g.drawRect(this.xCollumn +(int) Math.round(this.rectPos%this.nbColumns)*this.cellSize, this.yCollumn + (int) Math.round(this.rectPos/this.nbColumns)*this.cellSize, this.cellSize, this.cellSize);
    } 

    int getW(){
        return this.cellSize;
    }

    int getH(){
        return this.cellSize;
    }

    void left(){
        if(this.rectPos%this.nbColumns > 0){
            this.rectPos--;
        }
    }

    void right(){
        if(this.rectPos%this.nbColumns < this.nbColumns-1){
            this.rectPos++;
        }
        
    }

    void fall(){
        if(this.rectPos/this.nbColumns < this.nbRow-1){
            this.rectPos += this.nbColumns;
        }
    }

}
