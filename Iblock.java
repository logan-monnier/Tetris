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
        if(this.state == 0){
            System.out.println("spinLeft0");
            positions.set(0,(int) Math.round(this.positions.get(0)+gameArea.nbColumns+1));
            //positions.set(1,(int) Math.round(this.positions.get(1)-gameArea.nbColumns-1));
            positions.set(2,(int) Math.round(this.positions.get(2)-gameArea.nbColumns-1));
            positions.set(3,(int) Math.round(this.positions.get(3)-(gameArea.nbColumns*2)-2));
            this.state = 1;
        }
        else if(this.state == 1 ){
            System.out.println("spinLeft1");

            positions.set(0,(int) Math.round(this.positions.get(0)-gameArea.nbColumns-1));
            //positions.set(1,(int) Math.round(this.positions.get(1)-gameArea.nbColumns-1));
            positions.set(2,(int) Math.round(this.positions.get(2)+gameArea.nbColumns+1));
            positions.set(3,(int) Math.round(this.positions.get(3)+(gameArea.nbColumns*2)+2));
            this.state = 0;
        }
    }
    public void spinRight(){
        spinLeft();
        
    }
}
    

