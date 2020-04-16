/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemutvecklingsprojekt;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author ifkli
 */
public class BloggInlaggsPanel extends javax.swing.JPanel {
    
    private Connection db;
    private String rubrik;
    private String text;
    private int skapatAv;
    private String datum;
    private String filURL;
    private int anvandarID;
    private int bloggInlaggID;
    
    

    /**
     * Creates new form BloggInlaggsPanel
     */
    public BloggInlaggsPanel(Connection db, String rubrik, String text, String skapatAv, String datum, String filURL, int anvandarID, String bloggInlaggID, String adminStatus) {
        this.db = db;
        this.rubrik = rubrik;
        this.text = text;
        this.skapatAv = Integer.parseInt(skapatAv);
        this.datum = datum;
        this.filURL = filURL;
        this.anvandarID = anvandarID;
        this.bloggInlaggID = Integer.parseInt(bloggInlaggID);
        
        initComponents();
        
        lblRubrik.setText(rubrik);
        txtBloggtext.setText(text);
        lblDatumTid.setText(datum);
        
        btnRedigera.setVisible(false);
        btnTaBort.setVisible(false);
        
        if(anvandarID == this.skapatAv)
        {
            btnRedigera.setVisible(true);
            btnTaBort.setVisible(true);
        }
        else if(adminStatus.equals("J"))
        {
            btnTaBort.setVisible(true);
        }
        
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtBloggtext = new javax.swing.JTextArea();
        btnTaBort = new javax.swing.JButton();
        lblRubrik = new javax.swing.JLabel();
        btnRedigera = new javax.swing.JButton();
        lblDatumTid = new javax.swing.JLabel();

        txtBloggtext.setEditable(false);
        txtBloggtext.setColumns(20);
        txtBloggtext.setLineWrap(true);
        txtBloggtext.setRows(5);
        jScrollPane1.setViewportView(txtBloggtext);

        btnTaBort.setText("Ta bort");
        btnTaBort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortActionPerformed(evt);
            }
        });

        lblRubrik.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblRubrik.setText("Rubrik visas h�r");

        btnRedigera.setText("Redigera");
        btnRedigera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedigeraActionPerformed(evt);
            }
        });

        lblDatumTid.setText("Datumtid visas h�r");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblDatumTid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRedigera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTaBort))
                    .addComponent(lblRubrik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRedigera)
                        .addComponent(btnTaBort))
                    .addComponent(lblDatumTid))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRedigeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedigeraActionPerformed
        try{
        new RedigeraInlagg(db, rubrik,  text,  skapatAv,  filURL,  bloggInlaggID).setVisible(true);
        }catch(SQLException e){}
                
    }//GEN-LAST:event_btnRedigeraActionPerformed

    private void btnTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortActionPerformed
        try{
        int input = JOptionPane.showConfirmDialog(null, "Vill du verkligen radera detta inl�gg?", null, 
                    JOptionPane.OK_CANCEL_OPTION);

        if(input == 0){
            SQL.raderaBloggInlagg(db, bloggInlaggID);
        }
        }
        catch(NoSuchAlgorithmException e){
            
        }
        catch(SQLException i){
            
        }
    }//GEN-LAST:event_btnTaBortActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRedigera;
    private javax.swing.JButton btnTaBort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatumTid;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JTextArea txtBloggtext;
    // End of variables declaration//GEN-END:variables
}
