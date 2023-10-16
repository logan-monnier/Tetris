import java.util.ArrayList;
import java.util.List;

public abstract class block {
    List<Integer> positions = new ArrayList<Integer>();
    
    public List<Integer> getPositions(){
        return this.positions;
    }

    public void moveLeft(){
        boolean canFall = true;
        for(int i = 0; i < this.positions.size(); i++){
            if(((this.positions.get(i)%gameArea.nbColumns)-1 < 0) || (fenetre.grid.get(this.positions.get(i)-1) != -1)){
                canFall = false;
            }
        }
        if(canFall){
            for(int i = 0; i < this.positions.size(); i++){
                positions.set(i, positions.get(i)-1);
            }
        }
    }

    public void moveRight(){
        boolean canFall = true;
        for(int i = 0; i < this.positions.size(); i++){
            if(((this.positions.get(i)%gameArea.nbColumns)+1 > gameArea.nbColumns-1) || (fenetre.grid.get(this.positions.get(i)+1) != -1)){
                canFall = false;
            }
        }
        if(canFall){
            for(int i = 0; i < this.positions.size(); i++){
                this.positions.set(i, this.positions.get(i)+1);
            }
        }
    }
    public void fall(){
        boolean canFall = true;
        for(int i = 0; i < this.positions.size(); i++){
            if(((positions.get(i)/gameArea.nbColumns)+1 > gameArea.nbRow-1) || (fenetre.grid.get(this.positions.get(i)+gameArea.nbColumns) != -1)){
                canFall = false;
            }
        }
        if(canFall){
            for(int i = 0; i < this.positions.size(); i++){
                this.positions.set(i, this.positions.get(i)+gameArea.nbColumns);
            }
        }
    }
    public abstract void spinLeft();
    public abstract void spinRight();
}
