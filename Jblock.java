import java.awt.Color;

public class Jblock extends block{
    public Jblock(){
        positions.add((int) Math.round(gameArea.nbColumns/2)-1);
        positions.add((int) Math.round(gameArea.nbColumns/2));
        positions.add((int) Math.round(gameArea.nbColumns/2)+1);
        positions.add((int) Math.round(gameArea.nbColumns*1.5)+1);
        color = Color.BLUE;
    }

    public void spinLeft(){
        
    }
    public void spinRight(){
        
    }
}
