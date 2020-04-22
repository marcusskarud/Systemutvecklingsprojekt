/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemutvecklingsprojekt;


import java.sql.Array;
    import java.sql.Connection;
    import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author vince
 */
public class SkapaNyttMote extends javax.swing.JFrame {

    /**
     * Creates new form SkapaNyttProjekt
     */
        private static Connection db;
        DefaultListModel valdMedlemListModel = new DefaultListModel();
        private int anvandarID;
    
    
    public SkapaNyttMote(Connection db, int anvandarID) {
        this.db = db;
        this.anvandarID = anvandarID;
        initComponents();
        this.setLocationRelativeTo(null); //S�TTER F�NSTRET I MITTEN AV SK�RMEN N�R DEN SKAPAS
       
        try{
        listaAllaAnvandare();
            
        }
            catch(SQLException e){
                
            }
        
    }
    
    private void listaAllaAnvandare() throws SQLException{
        DefaultListModel listModell = new DefaultListModel();
        ArrayList<ArrayList<String>> resultatLista = SQL.getAnvandareItemList(db);
        
            for(ArrayList<String> anvandare : resultatLista){
                String anvandarInfo = anvandare.get(2) + " " + anvandare.get(3) + " "  + anvandare.get(1);
                
                listModell.addElement(anvandarInfo);
                listValjMedlemmar.setModel(listModell);
                System.out.println(anvandarInfo);
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

        jLabelmotesrubrik = new javax.swing.JLabel();
        txtProjektRubrik = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaBeskrivning = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btnSkapaMote = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listValjMedlemmar = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listValdaMedlemmar = new javax.swing.JList<>();
        btnTaBortMedl = new javax.swing.JButton();
        btnLaggTillMedl = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelmotesrubrik.setText("M�tesnamn:");

        txtAreaBeskrivning.setColumns(20);
        txtAreaBeskrivning.setRows(5);
        jScrollPane1.setViewportView(txtAreaBeskrivning);

        jLabel3.setText("Beskrivning av m�tet:");

        btnSkapaMote.setText("Skapa nytt m�te");
        btnSkapaMote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaMoteActionPerformed(evt);
            }
        });

        listValjMedlemmar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(listValjMedlemmar);

        jScrollPane3.setViewportView(listValdaMedlemmar);

        btnTaBortMedl.setText("Ta bort");
        btnTaBortMedl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortMedlActionPerformed(evt);
            }
        });

        btnLaggTillMedl.setText("L�gg till");
        btnLaggTillMedl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillMedlActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/systemutvecklingsprojekt/ProjektGrupperMild.png"))); // NOI18N

        jLabel4.setText("V�lj anv�nddare");

        jLabel5.setText("Valda anv�ndare");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/systemutvecklingsprojekt/INFORTELJBREOALJBF90.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/systemutvecklingsprojekt/VertikalH�ger.png"))); // NOI18N

        jSpinner1.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1587548132413L), null, java.util.Calendar.DAY_OF_MONTH));

        jSpinner2.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1587548549512L), null, java.util.Calendar.DAY_OF_MONTH));

        jSpinner3.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1587548601505L), null, java.util.Calendar.HOUR));

        jLabel2.setText("V�lj datum:");

        jLabel8.setText("Starttid:");

        jLabel9.setText("Sluttid:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(188, 188, 188)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(266, 266, 266)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnLaggTillMedl)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabelmotesrubrik)
                                            .addComponent(txtProjektRubrik)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTaBortMedl)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(344, 344, 344)
                                .addComponent(btnSkapaMote)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel7)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabelmotesrubrik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProjektRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTaBortMedl))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLaggTillMedl)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSkapaMote)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLaggTillMedlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillMedlActionPerformed
        laggTillMedlemmar();
        
        
    }//GEN-LAST:event_btnLaggTillMedlActionPerformed

    private void btnTaBortMedlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortMedlActionPerformed
            try{
                 listValdaMedlemmar.getSelectedValue();
                 valdMedlemListModel.removeElementAt(listValdaMedlemmar.getSelectedIndex());
            }
            catch(Exception e){
                
            }
    }//GEN-LAST:event_btnTaBortMedlActionPerformed

    private void btnSkapaMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaMoteActionPerformed
     
        if(Validering.textIsEmpty(txtProjektRubrik) || Validering.textAreaIsEmpty(txtAreaBeskrivning) || listValdaMedlemmar.getModel().getSize() == 0){
            
                JOptionPane.showMessageDialog(null, "V�nligen fyll i Rubrik, Beskrivning och l�gg till medlemmar!");
        }
        else{
                ArrayList<String> medlemsEpostLista = new ArrayList<>();
                
                          
             for(int i = 0; i<listValdaMedlemmar.getModel().getSize(); i++){
                String[] enMedlem = listValdaMedlemmar.getModel().getElementAt(i).split(" ");
                    medlemsEpostLista.add(enMedlem[2]);
                
                 System.out.println(medlemsEpostLista);
        } 
            try{
                ArrayList<Integer> enIDLista = SQL.epostTillAnvandarID(db, medlemsEpostLista);
                
                 //SQL.skapaNyttMote(db, enIDLista, txtProjektRubrik.getText(), txtAreaBeskrivning.getText(), datumtid, startTid, slutTid, anvandarID);
                }
                catch(SQLException e){
                }
            
            JOptionPane.showMessageDialog(null, "M�tetsinbjudan �r skickad" + txtProjektRubrik.getText() + ". ");
            txtProjektRubrik.setText("");
            txtAreaBeskrivning.setText("");
            valdMedlemListModel.clear();
            listValdaMedlemmar.setModel(valdMedlemListModel);
        }
    }//GEN-LAST:event_btnSkapaMoteActionPerformed

    
    private void laggTillMedlemmar(){
        boolean finnsRedan = false;
        String valdMedlem = listValjMedlemmar.getSelectedValue();
        
        for(int i = 0; i<listValdaMedlemmar.getModel().getSize(); i++){
           String enMedlem = listValdaMedlemmar.getModel().getElementAt(i);
           
                if(valdMedlem.equals(enMedlem)){
                    finnsRedan = true;
                }
                   
        }  
        
        if(finnsRedan == false){
            System.out.println(valdMedlem);
        
            valdMedlemListModel.addElement(valdMedlem);
            listValdaMedlemmar.setModel(valdMedlemListModel);
        }
        else{
            JOptionPane.showMessageDialog(null, "Personen du valt �r redan tillagd!");
        }
        
    }
    
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
//            java.util.logging.Logger.getLogger(SkapaNyttProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SkapaNyttProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SkapaNyttProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SkapaNyttProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SkapaNyttProjekt(db).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaggTillMedl;
    private javax.swing.JButton btnSkapaMote;
    private javax.swing.JButton btnTaBortMedl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelmotesrubrik;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JList<String> listValdaMedlemmar;
    private javax.swing.JList<String> listValjMedlemmar;
    private javax.swing.JTextArea txtAreaBeskrivning;
    private javax.swing.JTextField txtProjektRubrik;
    // End of variables declaration//GEN-END:variables
}
