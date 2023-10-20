import java.awt.Color;

public class Sblock extends block {

    public Sblock(){
        positions.add((int) Math.round(gameArea.nbColumns*1.5)-1);
        positions.add((int) Math.round(gameArea.nbColumns*1.5));
        positions.add((int) Math.round(gameArea.nbColumns/2));
        positions.add((int) Math.round(gameArea.nbColumns/2+1));
        color = Color.YELLOW;
    }

    public void spinLeft(){
        
    }
    public void spinRight(){
        
    }
}
