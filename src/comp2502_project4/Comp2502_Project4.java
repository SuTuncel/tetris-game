
package comp2502_project4;

import javax.swing.JOptionPane;


public class Comp2502_Project4 {
    
    
    private static GamePanel gP;
    private static StartUpForm sf;
     private static LeaderBoard lB;
    
     public static void start(){
         gP.setVisible(true);
         gP.startGame();
     }
     
     public static void showLeaderBoard(){
         lB.setVisible(true);
     }
     
     public static void showStartUp(){
         sf.setVisible(true);
     }
     
     public static void gameOver(int score){
         
        String playerName= JOptionPane.showInputDialog("Game Over1\nPlease enter your name:");
 
        gP.setVisible(false);
        lB.addPlayer(playerName,score);
     }
     
    
    public static void main (String[] args){
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gP = new GamePanel();
               sf = new StartUpForm();
               lB = new LeaderBoard();
               sf.setVisible(true);
            }
        });
      
    }
          
    
    
    
}
