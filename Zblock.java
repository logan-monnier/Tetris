import java.awt.Color;

public class Zblock extends block {
    public Zblock(){
        positions.add((int) Math.round(gameArea.nbColumns/2)-1);
        positions.add((int) Math.round(gameArea.nbColumns/2));
        positions.add((int) Math.round(gameArea.nbColumns*1.5));
        positions.add((int) Math.round(gameArea.nbColumns*1.5)+1);
        color = Color.RED;
    }

    public void spinLeft(){
        
    }
    public void spinRight(){
        
    }
}
