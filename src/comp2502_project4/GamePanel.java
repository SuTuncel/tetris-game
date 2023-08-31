
package comp2502_project4;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class GamePanel extends javax.swing.JFrame {

    private GameArea ga;
    protected GameThread gt;
   
    public GamePanel() {
        initComponents();
         ga = new GameArea(GameAreaPlaceHolder,10);
        
        this.add(ga);
        
       initControls();
        
      
    }
    
    
    private void initControls(){
        InputMap im= this.getRootPane().getInputMap();
        ActionMap am= this.getRootPane().getActionMap();
        
        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");
         im.put(KeyStroke.getKeyStroke("LEFT"), "left");
          im.put(KeyStroke.getKeyStroke("UP"), "up");
           im.put(KeyStroke.getKeyStroke("DOWN"), "down");
           
           am.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              ga.moveRight();
            }
        });
           am.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              ga.moveLeft();
            }
        });
           am.put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              ga.rotate();
            }
        });
           am.put("down",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               ga.drop();
            }
        });
           
           
          
    }
    
    public void startGame(){
        ga.initBackgroundArray();
       gt= new GameThread(ga,this);
               gt.start();
        
    }
    
    
    public void updateScore(int scre){
        score.setText("Score: "+scre);
        
    }
    
    public void updateLevel(int lvel){
        level.setText("Level: "+lvel);
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        GameAreaPlaceHolder = new javax.swing.JPanel();
        score = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        bMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        GameAreaPlaceHolder.setBackground(new java.awt.Color(255, 255, 255));
        GameAreaPlaceHolder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout GameAreaPlaceHolderLayout = new javax.swing.GroupLayout(GameAreaPlaceHolder);
        GameAreaPlaceHolder.setLayout(GameAreaPlaceHolderLayout);
        GameAreaPlaceHolderLayout.setHorizontalGroup(
            GameAreaPlaceHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        GameAreaPlaceHolderLayout.setVerticalGroup(
            GameAreaPlaceHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        score.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        score.setText("Score : 0");

        level.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        level.setText("Level : 1 ");

        bMenu.setBackground(new java.awt.Color(255, 255, 255));
        bMenu.setText("Main Menu");
        bMenu.setFocusable(false);
        bMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(bMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(GameAreaPlaceHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(score)
                    .addComponent(level))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(score)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(level))
                            .addComponent(GameAreaPlaceHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(bMenu)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMenuActionPerformed
       
        gt.interrupt();
        this.setVisible(false);
        Comp2502_Project4.showStartUp();
        
    }//GEN-LAST:event_bMenuActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GamePanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GameAreaPlaceHolder;
    private javax.swing.JButton bMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel level;
    private javax.swing.JLabel score;
    // End of variables declaration//GEN-END:variables
}
