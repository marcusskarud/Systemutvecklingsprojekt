/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemutvecklingsprojekt;

import java.sql.Connection;

/**
 *
 * @author ifkli
 */
public class ProjektInlagg extends javax.swing.JFrame {

    private Connection db;
    private String rubrik;
    private String text;
    private int skrivenAv;
    private String filURL;
    private int anvandarID;
    private int projektInlaggID;
    
    /**
     * Creates new form ProjektInlagg
     */
    public ProjektInlagg(Connection db, String rubrik, String text, int skrivenAv, String filURL, int anvandarID, int projektInlaggID) {
        this.db = db;
        this.rubrik = rubrik;
        this.text = text;
        this.skrivenAv = skrivenAv;
        this.filURL = filURL;
        this.anvandarID = anvandarID;
        this.projektInlaggID = projektInlaggID;
        
        initComponents();
        
        System.out.println(anvandarID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRubrik = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBrodtext = new javax.swing.JTextArea();
        btnPublicera = new javax.swing.JButton();
        lblRubrik = new javax.swing.JLabel();
        lblBrodtext = new javax.swing.JLabel();
        lblProjektRubrik = new javax.swing.JLabel();
        btnLaggTillFil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtBrodtext.setColumns(20);
        txtBrodtext.setRows(5);
        jScrollPane1.setViewportView(txtBrodtext);

        btnPublicera.setText("Publicera");

        lblRubrik.setText("Rubrik");

        lblBrodtext.setText("Br�dtext");

        lblProjektRubrik.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblProjektRubrik.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProjektRubrik.setText("Projektnamn");

        btnLaggTillFil.setText("L�gg till fil");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRubrik)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLaggTillFil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPublicera))
                    .addComponent(lblRubrik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBrodtext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProjektRubrik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblProjektRubrik)
                .addGap(18, 18, 18)
                .addComponent(lblRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBrodtext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPublicera)
                    .addComponent(btnLaggTillFil))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ProjektInlagg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ProjektInlagg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ProjektInlagg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ProjektInlagg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ProjektInlagg().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaggTillFil;
    private javax.swing.JButton btnPublicera;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrodtext;
    private javax.swing.JLabel lblProjektRubrik;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JTextArea txtBrodtext;
    private javax.swing.JTextField txtRubrik;
    // End of variables declaration//GEN-END:variables
}
