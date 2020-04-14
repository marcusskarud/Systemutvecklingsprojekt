/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemutvecklingsprojekt;

/**
 *
 * @author vince
 */
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 

    
  
    
    public class testCopy1 extends javax.swing.JPanel {

    /**
     * Creates new form testCopy
     */
    
        public static JPanel testCopy;
        
    public testCopy1() {
            //initComponents();
            JPanel pnlMallen = new javax.swing.JPanel();
            JLabel lblRubrikF = new javax.swing.JLabel();
            JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
            JTextArea txtBloggBrodTextF = new javax.swing.JTextArea();
            JButton jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRubrikF.setText("testar nuuu");

        txtBloggBrodTextF.setColumns(20);
        txtBloggBrodTextF.setRows(5);
        jScrollPane1.setViewportView(txtBloggBrodTextF);

        jButton1.setText("dwadwadawd");

        javax.swing.GroupLayout pnlMallenLayout = new javax.swing.GroupLayout(pnlMallen);
        pnlMallen.setLayout(pnlMallenLayout);
        pnlMallenLayout.setHorizontalGroup(
            pnlMallenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMallenLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlMallenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMallenLayout.createSequentialGroup()
                        .addComponent(lblRubrikF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pnlMallenLayout.setVerticalGroup(
            pnlMallenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMallenLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblRubrikF)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnlMallen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMallen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Container getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        
        
        
}



    
    
    
    
    
    
    

