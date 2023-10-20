import java.awt.Color;

public class Iblock extends block{
    public Iblock(){
        positions.add((int) Math.round(gameArea.nbColumns/2)-1);
        positions.add((int) Math.round(gameArea.nbColumns/2));
        positions.add((int) Math.round(gameArea.nbColumns/2)+1);
        positions.add((int) Math.round(gameArea.nbColumns/2)+2);
        color = Color.CYAN;
    }

    public void spinLeft(){
        
    }
    public void spinRight(){
        
    }
}
    

