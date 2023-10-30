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
        boolean canFall = true;
        for(int i = 0; i < this.positions.size(); i++){
            if(((this.positions.get(i)%gameArea.nbColumns)-1 < 0) || (fenetre.grid.get(this.positions.get(i)-1) != Color.BLACK)){
                if(this.state == 1){
                    canFall = false;
                }
            }   
            if(((positions.get(i)/gameArea.nbColumns)+1 > gameArea.nbRow-1) || (fenetre.grid.get(this.positions.get(i)+gameArea.nbColumns) != Color.BLACK)){
                canFall = false;
            }
        }
        if(canFall){
            if(this.state == 0){
                System.out.println("spinLeft0");
                positions.set(0,(int) Math.round(this.positions.get(0)+2));
                positions.set(1,(int) Math.round(this.positions.get(1)-gameArea.nbColumns+1));
                positions.set(3,(int) Math.round(this.positions.get(3)-gameArea.nbColumns-1));
                this.state = 1;
            }
            else if(this.state == 1 ){
                System.out.println("spinLeft1");

                positions.set(0,(int) Math.round(this.positions.get(0)-2));
                //positions.set(1,(int) Math.round(this.positions.get(1)-gameArea.nbColumns-1));
                positions.set(1,(int) Math.round(this.positions.get(1)+gameArea.nbColumns-1));
                positions.set(3,(int) Math.round(this.positions.get(3)+gameArea.nbColumns+1));
                this.state = 0;
            }
        }
    }
    public void spinRight(){
        this.spinLeft();
        }
}
