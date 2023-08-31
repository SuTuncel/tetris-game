
package comp2502_project4;

import java.util.logging.Level;
import java.util.logging.Logger;


public class GameThread extends Thread {
    
    private GameArea ga;
    private int score;
    private GamePanel gP;
    private int level =1; 
    private int scorePerLevel =3;
    
    private int pause =1000;
    private int speedUpPerLevel= 100;
    
    
    GameThread(GameArea ga, GamePanel gP){
        
        this.ga = ga;
        this.gP= gP;
        
        gP.updateScore(score);
        gP.updateLevel(level);
       
        
        
       
    }
  
   
    @Override
    public void run(){
        while(true){
            ga.spawnBlock();
            while(ga.moveDown()){
            
        try {
            Thread.sleep(pause);
        } catch (InterruptedException ex) {
           return;
        }
       }
            if(ga.isBlockOutOfBounds()){
                 Comp2502_Project4.gameOver(score);
                break;
            }  
            ga.moveBlockTobackground();
            score+= ga.clearLines();
            gP.updateScore(score); 
            int lvl = score/ scorePerLevel +1;
            if(lvl>level){
                level=lvl;
                gP.updateLevel(level);
                pause-= speedUpPerLevel;
            }      
    }  
    }
}
