/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemutvecklingsprojekt;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
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
    private boolean gillad;

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
        //txtVisaFil.setVisible(false);

        try {

            lblAntalLikes.setText(SQL.getAntalLikes(db, bloggInlaggID));

            if (SQL.getLikeStatus(db, anvandarID, bloggInlaggID)) {
                btnGilla.setText("Ogilla");
            } else {
                btnGilla.setText("Gilla");
            }

            if (SQL.getFormellaInlagg(db, bloggInlaggID)) {
                System.out.println("Visas");
                btnGilla.setVisible(false);
                lblAntalLikes.setVisible(false);

            }

            if (SQL.getInformellaInlagg(db, bloggInlaggID)) {
                btnPDFfil.setVisible(false);
            }

        } catch (NoSuchAlgorithmException e) {
        } catch (SQLException e) {
        }
        btnRedigera.setVisible(false);
        btnTaBort.setVisible(false);

        if (anvandarID == this.skapatAv) {
            btnRedigera.setVisible(true);
            btnTaBort.setVisible(true);
        } else if (adminStatus.equals("J")) {
            btnTaBort.setVisible(true);
        }

        if (!SQL.getBloggFilURL(db, Integer.parseInt(bloggInlaggID)).equals("")) {
            String lokalFilURL = SQL.getBloggFilURL(db, Integer.parseInt(bloggInlaggID));

            String fyraSista = lokalFilURL.substring(lokalFilURL.length() - 4);

            if (!fyraSista.equals(".pdf")) {

                btnPDFfil.setVisible(false);
                ImageIcon imageIcon = new ImageIcon(lokalFilURL); // load the image to a imageIcon
                Image image = imageIcon.getImage(); // transform it 
                Image newimg = image.getScaledInstance(360, 311, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                imageIcon = new ImageIcon(newimg);  // transform it back
                lblBild.setIcon(new ImageIcon(newimg));
            }

        }
        else {
         btnPDFfil.setVisible(false);
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
        btnGilla = new javax.swing.JButton();
        lblAntalLikes = new javax.swing.JLabel();
        lblForfattare = new javax.swing.JLabel();
        btnPDFfil = new javax.swing.JButton();
        lblBild = new javax.swing.JLabel();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        lblDatumTid.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDatumTid.setText("Datumtid visas h�r");

        btnGilla.setText("Gilla");
        btnGilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGillaActionPerformed(evt);
            }
        });

        lblAntalLikes.setText("45");
        lblAntalLikes.setMinimumSize(new java.awt.Dimension(10, 10));

        lblForfattare.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblForfattare.setText("Admin Adminsson");

        btnPDFfil.setText("�ppna PDF-fil");
        btnPDFfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDatumTid, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(lblForfattare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGilla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAntalLikes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(177, 177, 177)
                        .addComponent(btnPDFfil)
                        .addGap(53, 53, 53)
                        .addComponent(btnRedigera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTaBort))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblForfattare, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRubrik))
                .addGap(10, 10, 10)
                .addComponent(lblDatumTid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(lblBild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGilla)
                        .addComponent(lblAntalLikes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTaBort)
                        .addComponent(btnRedigera)
                        .addComponent(btnPDFfil)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRedigeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedigeraActionPerformed
        try {
            new RedigeraInlagg(db, rubrik, text, skapatAv, filURL, bloggInlaggID).setVisible(true);
        } catch (SQLException e) {
        }

    }//GEN-LAST:event_btnRedigeraActionPerformed

    private void btnTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortActionPerformed
        try {
            int input = JOptionPane.showConfirmDialog(null, "Vill du verkligen radera detta inl�gg?", null,
                    JOptionPane.OK_CANCEL_OPTION);

            if (input == 0) {
                SQL.raderaBloggInlagg(db, bloggInlaggID);
            }
        } catch (NoSuchAlgorithmException e) {

        } catch (SQLException i) {

        }
    }//GEN-LAST:event_btnTaBortActionPerformed

    private void btnGillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGillaActionPerformed

        try {
            if (gillad == false) {
                gillad = true;
                SQL.gillaInformellBlogginlagg(db, anvandarID, bloggInlaggID);

                String InlaggID = Integer.toString(bloggInlaggID);
                btnGilla.setText("Ogilla");
                lblAntalLikes.setText(SQL.getAntalLikes(db, InlaggID));

            } else if (gillad == true) {
                gillad = false;
                SQL.taBortLike(db, anvandarID, bloggInlaggID);

                String InlaggID = Integer.toString(bloggInlaggID);
                btnGilla.setText("Gilla");
                lblAntalLikes.setText(SQL.getAntalLikes(db, InlaggID));

            }

        } catch (NoSuchAlgorithmException e) {
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_btnGillaActionPerformed

    private void btnPDFfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFfilActionPerformed

        if (Desktop.isDesktopSupported()) {
            try {
                if (!SQL.getBloggFilURL(db, bloggInlaggID).equals("")) {
                    File myFile = new File(SQL.getBloggFilURL(db, bloggInlaggID));
                    System.out.println(bloggInlaggID);
                    System.out.println(SQL.getBloggFilURL(db, bloggInlaggID));
                    Desktop.getDesktop().open(myFile);
                } else {
                    btnPDFfil.setText("Ingen fil");
                    System.out.println("Finns ingen fil");
                }
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }

    }//GEN-LAST:event_btnPDFfilActionPerformed

//    private boolean getGillad()
//    {
//    boolean isGillad = false;
//    
//    if(gillad == true){
//    isGillad = true;
//    }
//    
//    return isGillad;
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGilla;
    private javax.swing.JButton btnPDFfil;
    private javax.swing.JButton btnRedigera;
    private javax.swing.JButton btnTaBort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAntalLikes;
    private javax.swing.JLabel lblBild;
    private javax.swing.JLabel lblDatumTid;
    private javax.swing.JLabel lblForfattare;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JTextArea txtBloggtext;
    // End of variables declaration//GEN-END:variables
}
