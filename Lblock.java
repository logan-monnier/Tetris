import java.awt.Color;

public class Lblock extends block{
    public Lblock(){
        positions.add((int) Math.round(gameArea.nbColumns/2)-1);
        positions.add((int) Math.round(gameArea.nbColumns*1.5)-1);
        positions.add((int) Math.round(gameArea.nbColumns/2));
        positions.add((int) Math.round(gameArea.nbColumns/2)+1);
        color = Color.ORANGE;
    }

    public void spinLeft(){
        
    }
    public void spinRight(){
        
    }
}
