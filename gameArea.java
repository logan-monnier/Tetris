// Using AWT's Graphics and Color
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.List;
import java.util.ArrayList;

public class gameArea extends JPanel{
    private int canvasWidth = 500;
    private int canvasHeight = 600;
    public static final Color LINE_COLOR = Color.WHITE;
    public static final Color CANVAS_BACKGROUND = Color.BLACK;

    static int nbColumns;
    static int nbRow;
    private int cellSize;

    private int xCollumn = (int) Math.round(this.canvasWidth/2);
    private int yCollumn = (int) Math.round(this.canvasHeight/4);

    private block block;
    private block nextblock;

    private int score = 0;

    private JLabel label;
    private JLabel labelLoose;
    private JLabel labelNextBlock;

    private int menu = 0;

    public gameArea(int columns, int rows){
        this.setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.black));
        gameArea.nbColumns = columns;
        gameArea.nbRow = rows;
        for(int i = 0; i<gameArea.nbColumns*gameArea.nbRow;i++){
            fenetre.grid.add(Color.BLACK);
        }
        this.cellSize = (int) Math.round(this.canvasWidth / gameArea.nbColumns/2);

        this.label = new JLabel(("Score :" + score),JLabel.CENTER);
        this.label.setForeground(Color.WHITE);
        this.label.setBounds(0,0,this.canvasWidth/2,this.canvasHeight-50);
        this.add(this.label);

        this.labelLoose = new JLabel((""),JLabel.CENTER);
        this.labelLoose.setForeground(Color.WHITE);
        this.labelLoose.setBounds(0,0,this.canvasWidth/2,this.canvasHeight);
        this.add(this.labelLoose);

        this.labelNextBlock = new JLabel(("Next Block"),JLabel.CENTER);
        this.labelNextBlock.setForeground(Color.WHITE);
        this.labelNextBlock.setBounds(this.canvasWidth/6,this.yCollumn,this.cellSize*4,30);
        this.add(this.labelNextBlock);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(CANVAS_BACKGROUND);

        this.canvasWidth = getWidth();
        this.canvasHeight = getHeight();
        if(this.menu == 0){
            this.label.setText("");
            this.labelLoose.setText("");
            this.labelNextBlock.setText("");
            this.setBackground(Color.PINK);
        }
        else if(this.menu == 1){
            this.label.setText("Score :" + score);
            this.labelNextBlock.setText("Next Block");
            this.label.setBounds(0,0,this.canvasWidth/2,this.canvasHeight-50);
            this.labelLoose.setBounds(0,0,this.canvasWidth/2,this.canvasHeight);
            this.labelNextBlock.setBounds(this.canvasWidth/4,this.yCollumn,this.cellSize*4,30);

            this.xCollumn = (int) Math.round(this.canvasWidth/2);
            this.yCollumn = (int) Math.round(this.canvasHeight/4);
            this.cellSize = (int) Math.round((this.canvasHeight-this.yCollumn) / gameArea.nbRow / 1.25);

            for(int j = 0 ; j < gameArea.nbColumns ; j++){
                for(int i = 0 ; i < gameArea.nbRow ; i++){
                    g.setColor(Color.white); 
                    g.drawRect(xCollumn+j*this.cellSize, yCollumn+i*this.cellSize, this.cellSize, this.cellSize);
            }}
            
            //draw the already existant block
            for(int i = 0; i < fenetre.grid.size(); i++){
                g.setColor(fenetre.grid.get(i));
                g.fillRect(this.xCollumn + i%gameArea.nbColumns*this.cellSize+1, this.yCollumn + (int) Math.round(i/gameArea.nbColumns)*this.cellSize+1, this.cellSize-1, this.cellSize-1);
                g.setColor(LINE_COLOR);
                g.drawRect(this.xCollumn + i%gameArea.nbColumns*this.cellSize, this.yCollumn + (int) Math.round(i/gameArea.nbColumns)*this.cellSize, this.cellSize, this.cellSize);
            }

            // draw a preview of where the block would land
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

            List<Integer> blockPositions = block.getPositions();
            //draw the falling block
            for(int i = 0; i < blockPositions.size(); i++){
                g.setColor(block.getColor());
                g.fillRect(this.xCollumn + blockPositions.get(i)%gameArea.nbColumns*this.cellSize+1, this.yCollumn + (int) Math.round(blockPositions.get(i)/gameArea.nbColumns)*this.cellSize+1, this.cellSize-1, this.cellSize-1);
                g.setColor(LINE_COLOR);
                g.drawRect(this.xCollumn + blockPositions.get(i)%gameArea.nbColumns*this.cellSize, this.yCollumn + (int) Math.round(blockPositions.get(i)/gameArea.nbColumns)*this.cellSize, this.cellSize, this.cellSize);
            }

            List<Integer> nextblockPositions = nextblock.getPositions();
            //draw the next block
            for(int i = 0; i < nextblockPositions.size(); i++){
                g.setColor(nextblock.getColor());
                g.fillRect(this.canvasWidth/4 - this.cellSize*4 + nextblockPositions.get(i)%gameArea.nbColumns*this.cellSize+1, this.yCollumn + this.cellSize*2 + (int) Math.round(nextblockPositions.get(i)/gameArea.nbColumns)*this.cellSize+1, this.cellSize-1, this.cellSize-1);
                g.setColor(LINE_COLOR);
                g.drawRect(this.canvasWidth/4 - this.cellSize*4 + nextblockPositions.get(i)%gameArea.nbColumns*this.cellSize, this.yCollumn + this.cellSize*2 + (int) Math.round(nextblockPositions.get(i)/gameArea.nbColumns)*this.cellSize, this.cellSize, this.cellSize);
            }
        }
    }

    class Listener implements KeyListener{
        @Override
        public void keyPressed(KeyEvent evt) {
           System.out.println(evt.getKeyCode());
           if(menu != 0){
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
                    //if (!timer.isRunning()){
                    //   newGame();
                    //}
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
  
     }

    public void setBlock(block block, block nextblock){
        this.block = block;
        this.nextblock = nextblock;
    }

    public void addScore(){
        this.score++;
        this.label.setText("Score :"+this.score);
    }

    public void hasLoosed(){
        this.labelLoose.setText("Press space to start a new game");
    }

    public void startAgain(){
        fenetre.grid.clear();
        for(int i = 0; i<gameArea.nbColumns*gameArea.nbRow;i++){
            fenetre.grid.add(Color.BLACK);
        }
        this.score = 0;
        this.labelLoose.setText("");
    }

    public int getMenu(){
        return this.menu;
    }

    public void addMenu(){
        this.menu++;
    }

}
