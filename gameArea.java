// Using AWT's Graphics and Color
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.util.List;

public class gameArea  extends JPanel{
    /**
    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
    */
    private double canvasWidth = 500;
    private double canvasHeight = 600;
    public static final Color FILL_COLOR = Color.RED;
    public static final Color LINE_COLOR = Color.WHITE;
    public static final Color CANVAS_BACKGROUND = Color.BLACK;

    static int nbColumns;
    static int nbRow;
    private int cellSize;

    private int xCollumn = (int) Math.round(this.canvasWidth/2);
    private int yCollumn = (int) Math.round(this.canvasHeight/4);
    private int rectPos = 0;
    private block block;

    public gameArea(int columns, int rows){
        //setVisible(false);
        //setBounds(150, 50, this.canvasWidth, this.canvasHeight);
        setBorder(BorderFactory.createLineBorder(Color.black));
        gameArea.nbColumns = columns;
        gameArea.nbRow = rows;
        for(int i = 0; i<gameArea.nbColumns*gameArea.nbRow;i++){
            fenetre.grid.add(-1);
        }
        this.cellSize = (int) Math.round(this.canvasWidth / gameArea.nbColumns/2);

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
        this.cellSize = (int) Math.round((this.canvasHeight-this.yCollumn) / gameArea.nbRow / 1.25);

        for(int j = 0 ; j < gameArea.nbColumns ; j++){
            for(int i = 0 ; i < gameArea.nbRow ; i++){
                g.setColor(Color.white); 
                g.drawRect(xCollumn+j*this.cellSize, yCollumn+i*this.cellSize, this.cellSize, this.cellSize);
        }}

        List<Integer> blockPositions = block.getPositions();
        

        for(int i = 0; i < blockPositions.size(); i++){
            g.setColor(FILL_COLOR);
            g.fillRect(this.xCollumn + (int) Math.round(blockPositions.get(i)%gameArea.nbColumns)*this.cellSize+1, this.yCollumn + (int) Math.round(blockPositions.get(i)/gameArea.nbColumns)*this.cellSize+1, this.cellSize-1, this.cellSize-1);
            g.setColor(LINE_COLOR);
            g.drawRect(this.xCollumn +(int) Math.round(blockPositions.get(i)%gameArea.nbColumns)*this.cellSize, this.yCollumn + (int) Math.round(blockPositions.get(i)/gameArea.nbColumns)*this.cellSize, this.cellSize, this.cellSize);
        }
        
        //g.setColor(FILL_COLOR);
        //g.fillRect(this.xCollumn + (int) Math.round(this.rectPos%gameArea.nbColumns)*this.cellSize+1, this.yCollumn + (int) Math.round(this.rectPos/gameArea.nbColumns)*this.cellSize+1, this.cellSize-1, this.cellSize-1);
        //g.setColor(LINE_COLOR);
        //g.drawRect(this.xCollumn +(int) Math.round(this.rectPos%gameArea.nbColumns)*this.cellSize, this.yCollumn + (int) Math.round(this.rectPos/gameArea.nbColumns)*this.cellSize, this.cellSize, this.cellSize);
    } 

    void setBlock(block block){
        this.block = block;
    }
    int getW(){
        return this.cellSize;
    }

    int getH(){
        return this.cellSize;
    }

    void left(){
        if(this.rectPos%gameArea.nbColumns > 0){
            this.rectPos--;
        }
    }

    void right(){
        if(this.rectPos%gameArea.nbColumns < gameArea.nbColumns-1){
            this.rectPos++;
        }
        
    }

    void fall(){
        if(this.rectPos/gameArea.nbColumns < gameArea.nbRow-1){
            this.rectPos += gameArea.nbColumns;
        }
    }

}
