import java.awt.Color;

public class Tblock extends block {
    // private int block1 = (int) Math.round(gameArea.nbColumns/2)-1;
    // private int block2 = (int) Math.round(gameArea.nbColumns/2)
    // private int block3 = 
    // private int block4 = 
    public Tblock(){
        this.state = 0;
        positions.add((int) Math.round(gameArea.nbColumns/2)-1);
        positions.add((int) Math.round(gameArea.nbColumns/2));
        positions.add((int) Math.round(gameArea.nbColumns*1.5));
        positions.add((int) Math.round(gameArea.nbColumns/2)+1);
        color = Color.MAGENTA;
    }

    public void spinLeft(){
        boolean canFall = true;
        for(int i = 0; i < this.positions.size(); i++){
            if(((this.positions.get(i)%gameArea.nbColumns)-1 < 0) || (fenetre.grid.get(this.positions.get(i)-1) != Color.BLACK)){
                if(this.state == 3){
                    canFall = false;
                }
            }   
            // if(((this.positions.get(i)%gameArea.nbColumns)+1 > gameArea.nbColumns-1) || (fenetre.grid.get(this.positions.get(i)+1) != Color.BLACK)){
            //     canFall = false;
            // }
            if(((positions.get(i)/gameArea.nbColumns)+1 > gameArea.nbRow-1) || (fenetre.grid.get(this.positions.get(i)+gameArea.nbColumns) != Color.BLACK)){
                canFall = false;
                System.out.println("dans le if");
            }
        }
        if(canFall){
            if(this.state == 0){
                System.out.println("spinLeft0");
                positions.set(0,(int) Math.round(this.positions.get(0)-gameArea.nbColumns+1));
                positions.set(2,(int) Math.round(this.positions.get(2)-gameArea.nbColumns-1));
                positions.set(3,(int) Math.round(this.positions.get(3)+gameArea.nbColumns-1));
                this.state = 1;
            }
            else if(this.state == 1 ){
                System.out.println("spinLeft1");

                positions.set(0,(int) Math.round(this.positions.get(0)+gameArea.nbColumns+1));
                //positions.set(1,(int) Math.round(this.positions.get(1)-gameArea.nbColumns-1));
                positions.set(2,(int) Math.round(this.positions.get(2)-gameArea.nbColumns+1));
                positions.set(3,(int) Math.round(this.positions.get(3)-gameArea.nbColumns-1));
                this.state = 2;
            }
            else if(this.state == 2 ){
                System.out.println("spinLeft2");

                positions.set(0,(int) Math.round(this.positions.get(0)+gameArea.nbColumns-1));
                //positions.set(1,(int) Math.round(this.positions.get(1)-gameArea.nbColumns-1));
                positions.set(2,(int) Math.round(this.positions.get(2)+gameArea.nbColumns+1));
                positions.set(3,(int) Math.round(this.positions.get(3)-gameArea.nbColumns+1));
                this.state = 3;
            }
            else if(this.state == 3 ){
                System.out.println("spinLeft3");

                positions.set(0,(int) Math.round(this.positions.get(0)-gameArea.nbColumns-1));
                //positions.set(1,(int) Math.round(this.positions.get(1)-gameArea.nbColumns-1));
                positions.set(2,(int) Math.round(this.positions.get(2)+gameArea.nbColumns-1));
                positions.set(3,(int) Math.round(this.positions.get(3)+gameArea.nbColumns+1));
                this.state = 0;
            }
        }
        
    }
    public void spinRight(){
        boolean canFall = true;
        for(int i = 0; i < this.positions.size(); i++){
            // if(((this.positions.get(i)%gameArea.nbColumns)-1 < 0) || (fenetre.grid.get(this.positions.get(i)-1) != Color.BLACK)){
            //         canFall = false;
            // }   
            if(((this.positions.get(i)%gameArea.nbColumns)+1 > gameArea.nbColumns-1) || (fenetre.grid.get(this.positions.get(i)+1) != Color.BLACK)){
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
            positions.set(0,(int) Math.round(this.positions.get(0)+gameArea.nbColumns+1));
            //positions.set(1,(int) Math.round(this.positions.get(1)-gameArea.nbColumns-1));
            positions.set(2,(int) Math.round(this.positions.get(2)-gameArea.nbColumns+1));
            positions.set(3,(int) Math.round(this.positions.get(3)-gameArea.nbColumns-1));
            this.state = 3;
        }
        else if(this.state == 3 ){
            positions.set(0,(int) Math.round(this.positions.get(0)-gameArea.nbColumns+1));
            //positions.set(1,(int) Math.round(this.positions.get(1)-gameArea.nbColumns-1));
            positions.set(2,(int) Math.round(this.positions.get(2)-gameArea.nbColumns-1));
            positions.set(3,(int) Math.round(this.positions.get(3)+gameArea.nbColumns-1));
            this.state = 2;
        }
        else if(this.state == 2 ){
            positions.set(0,(int) Math.round(this.positions.get(0)-gameArea.nbColumns-1));
            //positions.set(1,(int) Math.round(this.positions.get(1)-gameArea.nbColumns-1));
            positions.set(2,(int) Math.round(this.positions.get(2)+gameArea.nbColumns-1));
            positions.set(3,(int) Math.round(this.positions.get(3)+gameArea.nbColumns+1));
            this.state = 1;
        }
        else if(this.state == 1 ){
            positions.set(0,(int) Math.round(this.positions.get(0)+gameArea.nbColumns-1));
            //positions.set(1,(int) Math.round(this.positions.get(1)-gameArea.nbColumns-1));
            positions.set(2,(int) Math.round(this.positions.get(2)+gameArea.nbColumns+1));
            positions.set(3,(int) Math.round(this.positions.get(3)-gameArea.nbColumns+1));
            this.state = 0;
        }
    }
}    
    }

