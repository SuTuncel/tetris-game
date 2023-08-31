
package comp2502_project4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;


public class GameArea extends JPanel{
    
    private int gridRows;
    private int gridColumns;
    private int gridCellsize;
    private TetrisBlock block;
    private Color [][] background;
    private TetrisBlock[] blockss;
    
    
    GameArea(JPanel placeholder, int columns){
        placeholder.setVisible(false);
        this.setBounds(placeholder.getBounds()); // bunu eklemezsek kare görünmüyordu çünkü jpanelin görünebileceği sınırları yoktu 
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());
        gridColumns = columns;
        gridCellsize = this.getBounds().width/ gridColumns;
        gridRows = this.getBounds().height/gridCellsize;
      
        blockss = new TetrisBlock[]{new IShape(),
       new JShape(), new LShape(),new OShape(), new SShape(),
        new TShape(),new ZShape()};
     
    }
    
    public void initBackgroundArray(){
         background = new Color[gridRows][gridColumns];
    }
    
    
    
    public void spawnBlock(){
        Random r = new Random();
        block = blockss[r.nextInt(blockss.length)];
        block.spawn(gridColumns);
    }
    
    private boolean checkBottom(){
        if(block.getBottomEdge() ==gridRows){
            return false;
        }
        
        int [][] shape = block.getShape();
        int h = block.getHeight();
        int w = block.getWidth();
        
        for (int col =0; col<w; col++){
          for (int row =h-1; row>=0; row--){
              
              if(shape[row][col]!=0){
              int x = col+block.getX();
              int y = row+block.getY()+1;
              if (y<0) break;
              if (background[y][x]!= null) return false;
              break;
              }
          }  
            
        }
        return true;
    }
    
    private boolean checkLeft(){
        if(block.getLeftEdge()==0){
            return false;
        }
        
        int [][] shape = block.getShape();
        int h = block.getHeight();
        int w = block.getWidth();
        
        for (int row =0; row<h; row++){
          for (int col =0; col<w; col++){
              if(shape[row][col]!=0){
              int x = col+block.getX()-1;
              int y = row+block.getY();
              if (y<0) break;
              if (background[y][x]!= null) return false;
              break;
          }  
            
        }
        
        }
       return true; 
    }
    
    private boolean checkRight(){
        if(block.getRightEdge()==gridColumns){
            return false;
        }
          int [][] shape = block.getShape();
        int h = block.getHeight();
        int w = block.getWidth();
        
        for (int row =0; row<h; row++){
          for (int col =w-1; col>=0; col--){
              if(shape[row][col]!=0){
              int x = col+block.getX()+1;
              int y = row+block.getY();
              if (y<0) break;
              if (background[y][x]!= null) return false;
              break;
          }  
            
        }
        }
        
        return true;
    }
    
    
    
    private void drawBackground(Graphics g){
        Color color;
        
        for(int r=0; r< gridRows; r++){
            for(int c =0; c< gridColumns;c++)
            {
                color = background[r][c];
                
                if(color!=null){
                    int x = c*gridCellsize;
                    int y = r*gridCellsize;
                     drawGridSquare(g,color,x,y);
                }
                 
            }
        }
           
    }
    
    private void drawGridSquare(Graphics g, Color color, int x, int y){
          g.setColor(color);
                    g.fillRect(x, y, gridCellsize, gridCellsize);
                    g.setColor(Color.black);
                    g.drawRect(x, y, gridCellsize, gridCellsize);  
        
    }
    
    
    
    private void drawBlock(Graphics g){
        int h = block.getHeight();
        int w = block.getWidth();
        Color co = block.getColor();
        int[][] shape = block.getShape();
        
        
        for (int r=0; r<h; r++ ){
            for (int c =0; c< w; c++){
                
                if(shape[r][c]==1){
                    
                    int x = (block.getX()+c)*gridCellsize;
                    int y = (block.getY()+r)*gridCellsize;
                    
                    drawGridSquare(g,co,x,y);
                    
                }
                
            }
            
        }
        
    }
    
    public boolean isBlockOutOfBounds(){
        
        if (block.getY()<0){
            block=null;
            return true; 
        }
       return false; 
    }
    
    
    
    public boolean moveDown(){
        
        if(checkBottom() == false){
          
            return false;
        }
        block.moveDown();
        repaint();
        
        return true;
    }
    
    
    
    public int clearLines(){
        boolean linefilled;
        int linesCleared =0; 
        
        for(int r= gridRows-1; r>=0; r--){
            linefilled =true;
            for(int c =0; c< gridColumns; c++ ){
                if(background[r][c]==null){
                    linefilled = false;
                    break;
                }
                 
            }
           if(linefilled){
               linesCleared++;
               clearLine(r);
               shiftDown(r);
               clearLine(0);
               r++;
               repaint();
           }
            
        }
        return linesCleared; 
    }
    
    private void clearLine(int r){
         for(int i =0; i< gridColumns; i++){
                   background[r][i]=null;  
               }
    }
    
    private void shiftDown(int r){
        for(int row =r; row>0; row--){
            for(int col=0; col<gridColumns; col++){
                
                background[row][col]= background[row-1][col];
            }
            
            
        }  
    }
    
    public void moveBlockTobackground(){
        int [][] shape = block.getShape();
        int h = block.getHeight();
        int w = block.getWidth();
        int xPos= block.getX();
        int yPos = block.getY();
        Color color = block.getColor();
        
        for(int r=0; r<h; r++){
            for (int c =0; c<w; c++){
                if (shape[r][c]==1){
                    background[r+yPos][c+xPos] = color;
                }
                
                
                
            }
        }   
    }
    
    
    public void moveRight(){
        if(block==null) return;
        if(!checkRight()) return;
        block.moveRight();
        repaint();
    }
    
    public void moveLeft(){
         if(block==null) return;
        if(!checkLeft()) return;
        block.moveLeft();
        repaint();
    }
    
    public void drop(){
         if(block==null) return;
        while(checkBottom()){
            block.moveDown();
        }
        
        repaint();
    }
    
    public void rotate(){
         if(block==null) return;
        block.rotate();
        if(block.getLeftEdge()<0) block.setX(0);
        if (block.getRightEdge()>=gridColumns)
            block.setX(gridColumns-block.getWidth());
        if(block.getBottomEdge()>=gridRows)
            block.setY(gridRows-block.getHeight());
        
        repaint();
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        drawBackground(g);
       drawBlock(g);
    }
    
}
