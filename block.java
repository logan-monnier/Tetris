import java.util.ArrayList;
import java.util.List;

public abstract class block {
    List<Integer> positions = new ArrayList<Integer>();

    public void draw(gameArea canvas){
        
    }
    
    public List<Integer> getPositions(){
        return positions;
    }

    public void moveLeft(){
        boolean canFall = true;
        for(int i = 0; i < positions.size(); i++){
            if((fenetre.grid.get(positions.get(i)-1) != -1) || (positions.get(i)%gameArea.nbColumns > 0)){
                canFall = false;
            }
        }
        if(canFall){
            for(int i = 0; i < positions.size(); i++){
                positions.set(i, positions.get(i)-1);
            }
        }
    }

    public void moveRight(){
        boolean canFall = true;
        for(int i = 0; i < positions.size(); i++){
            if((fenetre.grid.get(positions.get(i)+1) != -1) || (positions.get(i)%gameArea.nbColumns < gameArea.nbColumns-1)){
                canFall = false;
            }
        }
        if(canFall){
            for(int i = 0; i < positions.size(); i++){
                positions.set(i, positions.get(i)+1);
            }
        }
    }
    public void fall(){
        boolean canFall = true;
        for(int i = 0; i < positions.size(); i++){
            if((fenetre.grid.get(positions.get(i)+gameArea.nbColumns) != -1) || (positions.get(i)/gameArea.nbColumns < gameArea.nbRow-1)){
                canFall = false;
            }
        }
        if(canFall){
            for(int i = 0; i < positions.size(); i++){
                positions.set(i, positions.get(i)+gameArea.nbColumns);
            }
        }
    }
    public abstract void spinLeft();
    public abstract void spinRight();
}
