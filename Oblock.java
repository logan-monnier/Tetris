public class Oblock extends block{
    public Oblock(){
        this.positions.add((int) Math.round(gameArea.nbColumns/2)-1);
        this.positions.add((int) Math.round(gameArea.nbColumns/2));
        this.positions.add((int) Math.round(gameArea.nbColumns*1.5)-1);
        this.positions.add((int) Math.round(gameArea.nbColumns*1.5));
    }

    public void spinLeft(){
        
    }
    public void spinRight(){
        
    }
}
