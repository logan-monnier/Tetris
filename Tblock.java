import java.awt.Color;

public class Tblock extends block {
    public Tblock(){
        positions.add((int) Math.round(gameArea.nbColumns/2)-1);
        positions.add((int) Math.round(gameArea.nbColumns/2));
        positions.add((int) Math.round(gameArea.nbColumns*1.5));
        positions.add((int) Math.round(gameArea.nbColumns/2)+1);
        color = Color.MAGENTA;
    }

    public void spinLeft(){
        
    }
    public void spinRight(){
        
    }
}
