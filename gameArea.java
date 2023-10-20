// Using AWT's Graphics and Color
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.util.List;
import java.util.ArrayList;

public class gameArea extends JPanel{
    /**
    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
    */
    private double canvasWidth = 500;
    private double canvasHeight = 600;
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
            fenetre.grid.add(Color.BLACK);
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
        
        for(int i = 0; i < fenetre.grid.size(); i++){
            g.setColor(fenetre.grid.get(i));
            g.fillRect(this.xCollumn + i%gameArea.nbColumns*this.cellSize+1, this.yCollumn + (int) Math.round(i/gameArea.nbColumns)*this.cellSize+1, this.cellSize-1, this.cellSize-1);
            g.setColor(LINE_COLOR);
            g.drawRect(this.xCollumn + i%gameArea.nbColumns*this.cellSize, this.yCollumn + (int) Math.round(i/gameArea.nbColumns)*this.cellSize, this.cellSize, this.cellSize);
        }

        Graphics2D g2d = (Graphics2D) g;
        boolean canFall = true;
        List<Integer> pos = new ArrayList<Integer>(block.getPositions());
        while (canFall){
            for(int i = 0; i < pos.size(); i++){
                if(((pos.get(i)/gameArea.nbColumns)+1 > gameArea.nbRow-1) || (fenetre.grid.get(pos.get(i)+gameArea.nbColumns) != Color.BLACK)){
                    canFall = false;
                }
            }
            if(canFall){
                for(int i = 0; i < pos.size(); i++){
                    pos.set(i, pos.get(i)+gameArea.nbColumns);
                }
            }
        }
        
        for(int i = 0; i < pos.size(); i++){
            float[] dist = {0.4f, 0.7f, 0.9f, 1.0f};
            Color[] colors = {Color.BLACK, Color.DARK_GRAY, Color.GRAY, Color.WHITE};
            RadialGradientPaint p = new RadialGradientPaint(this.xCollumn + pos.get(i)%gameArea.nbColumns*this.cellSize+this.cellSize/2, this.yCollumn + pos.get(i)/gameArea.nbColumns*this.cellSize+this.cellSize/2, this.cellSize/2, dist, colors);
            g2d.setPaint(p);
            g2d.fillRect(this.xCollumn + pos.get(i)%gameArea.nbColumns*this.cellSize+1, this.yCollumn + pos.get(i)/gameArea.nbColumns*this.cellSize+1, this.cellSize-1, this.cellSize-1);
        }

        for(int i = 0; i < blockPositions.size(); i++){
            g.setColor(block.getColor());
            g.fillRect(this.xCollumn + blockPositions.get(i)%gameArea.nbColumns*this.cellSize+1, this.yCollumn + (int) Math.round(blockPositions.get(i)/gameArea.nbColumns)*this.cellSize+1, this.cellSize-1, this.cellSize-1);
            g.setColor(LINE_COLOR);
            g.drawRect(this.xCollumn + blockPositions.get(i)%gameArea.nbColumns*this.cellSize, this.yCollumn + (int) Math.round(blockPositions.get(i)/gameArea.nbColumns)*this.cellSize, this.cellSize, this.cellSize);
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
