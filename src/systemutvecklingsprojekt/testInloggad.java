/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemutvecklingsprojekt;

/**
 *
 * @author Ludvig Johansson
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class testInloggad extends javax.swing.JFrame {
private static Connection db;
    private int anvandarID;
    private String adminStatus;

    /**
     * Creates new form Inloggad
     */
    public testInloggad(Connection db, int anvandarID, String adminStatus) {
        initComponents();

        this.db = db;
        this.anvandarID = anvandarID;
        this.adminStatus = adminStatus;

        pnlFormellBlogg.setLayout(new BoxLayout(pnlFormellBlogg, BoxLayout.Y_AXIS));
        pnlInformellBlogg.setLayout(new BoxLayout(pnlInformellBlogg, BoxLayout.Y_AXIS));

        if (adminStatus.equals("N")) {
            tabbedPaneBar.remove(3);
        }

        try {
            uppdateraInformellBlogg();
            uppdateraFormellBlogg();
        } catch (SQLException e) {
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPaneBar = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        ScrollPane1 = new javax.swing.JScrollPane();
        pnlInformellBlogg = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btnUppdateraInformell = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        ScrollPane3 = new javax.swing.JScrollPane();
        pnlFormellBlogg = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        btnUppdateraFormell = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        txtSattRubrik = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        cmbInlaggsTyp = new javax.swing.JComboBox<>();
        btnPublicera = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBrodtext = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        pnlAdminRights = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtEpost = new javax.swing.JTextField();
        txtTelefonnummer = new javax.swing.JTextField();
        txtFornamn = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnSkapaKonto = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtEfternamn = new javax.swing.JTextField();
        rbtnAdmin = new javax.swing.JRadioButton();
        pswLosenord = new javax.swing.JPasswordField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbedPaneBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTabbedPane2.setRequestFocusEnabled(false);

        javax.swing.GroupLayout pnlInformellBloggLayout = new javax.swing.GroupLayout(pnlInformellBlogg);
        pnlInformellBlogg.setLayout(pnlInformellBloggLayout);
        pnlInformellBloggLayout.setHorizontalGroup(
            pnlInformellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 906, Short.MAX_VALUE)
        );
        pnlInformellBloggLayout.setVerticalGroup(
            pnlInformellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2333, Short.MAX_VALUE)
        );

        ScrollPane1.setViewportView(pnlInformellBlogg);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/systemutvecklingsprojekt/BannerInformellBloggColor.png"))); // NOI18N

        jLabel20.setText("#");

        jLabel21.setText("S�k inl�gg");

        jButton4.setText("S�k");

        btnUppdateraInformell.setText("Uppdatera");
        btnUppdateraInformell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUppdateraInformellActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(41, 41, 41))
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnUppdateraInformell)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addGap(18, 18, 18)
                            .addComponent(jButton4))))
                .addGap(12, 12, 12)
                .addComponent(ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                        .addComponent(btnUppdateraInformell)
                        .addGap(224, 224, 224))))
        );

        jTabbedPane2.addTab("Informell", jPanel7);

        javax.swing.GroupLayout pnlFormellBloggLayout = new javax.swing.GroupLayout(pnlFormellBlogg);
        pnlFormellBlogg.setLayout(pnlFormellBloggLayout);
        pnlFormellBloggLayout.setHorizontalGroup(
            pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 906, Short.MAX_VALUE)
        );
        pnlFormellBloggLayout.setVerticalGroup(
            pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2333, Short.MAX_VALUE)
        );

        ScrollPane3.setViewportView(pnlFormellBlogg);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/systemutvecklingsprojekt/BannerFormellBloggColor.png"))); // NOI18N

        jLabel29.setText("#");

        jLabel30.setText("S�k inl�gg");

        jButton16.setText("S�k");

        btnUppdateraFormell.setText("Uppdatera");
        btnUppdateraFormell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUppdateraFormellActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(41, 41, 41))
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnUppdateraFormell)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel29)
                            .addGap(18, 18, 18)
                            .addComponent(jButton16))))
                .addGap(12, 12, 12)
                .addComponent(ScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel28)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton16)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUppdateraFormell)
                        .addGap(232, 232, 232))))
        );

        jTabbedPane2.addTab("Formell", jPanel10);

        txtSattRubrik.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel7.setText("Rubrik");

        jLabel18.setText("Br�dtext");

        jButton13.setText("L�gg till fil");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel22.setText("*Visa vald filnamn h�r*");

        jLabel26.setText("#");

        jLabel27.setText("L�gg till s�kord:");

        jButton10.setText("L�gg till");

        jButton15.setText("Ta bort valt s�kord");

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "item 6", "item 7", "item 8", "item 9 ", "item 10", "item 11", "item 12", "item 13", "item 14", "item 15" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList2);

        cmbInlaggsTyp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Informell blogg", "Formell blogg" }));

        btnPublicera.setText("Publicera");
        btnPublicera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPubliceraActionPerformed(evt);
            }
        });

        jLabel3.setText("#");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/systemutvecklingsprojekt/SkapaNyttInl�ggColor.png"))); // NOI18N

        txtBrodtext.setColumns(20);
        txtBrodtext.setLineWrap(true);
        txtBrodtext.setRows(5);
        jScrollPane1.setViewportView(txtBrodtext);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGap(503, 503, 503)
                                .addComponent(btnPublicera))
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton13)
                                        .addComponent(cmbInlaggsTyp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                            .addComponent(jLabel27)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(150, 150, 150)
                                .addComponent(jLabel26))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10))))
                    .addComponent(jLabel7)
                    .addComponent(txtSattRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel31)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSattRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel26))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton15)
                                    .addComponent(jButton10))
                                .addGap(56, 56, 56)
                                .addComponent(jButton13))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbInlaggsTyp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPublicera))))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Skapa nytt inl�gg", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        tabbedPaneBar.addTab("Blogg", jPanel1);

        jButton6.setText("Skapa nytt projekt");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Forskning: projektnamn" }));

        jLabel2.setText("V�lj projektgrupp:");

        jButton1.setText("Skapa Ny Projektgrupp");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 1056, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 814, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton6))))
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton1)
                .addGap(30, 30, 30)
                .addComponent(jButton6)
                .addContainerGap(547, Short.MAX_VALUE))
        );

        tabbedPaneBar.addTab("Projekt", jPanel2);

        jButton7.setText("Ny h�ndelse");

        jButton8.setText("M�ten");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addContainerGap(938, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addContainerGap(657, Short.MAX_VALUE))
        );

        tabbedPaneBar.addTab("Kalender", jPanel3);

        jButton11.setText("Ge adminstatus");

        jPanel4.setBackground(new java.awt.Color(68, 73, 255));

        jLabel12.setText("E-post (inlogg)");

        jLabel13.setText("L�senord");

        jLabel15.setText("Telefonnummer");

        jLabel16.setText("F�rnamn");

        btnSkapaKonto.setText("Skapa nytt anv�ndarkonto");
        btnSkapaKonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaKontoActionPerformed(evt);
            }
        });

        jLabel17.setText("Efternamn");

        rbtnAdmin.setText("Administrat�r");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEpost, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTelefonnummer)
                    .addComponent(rbtnAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(pswLosenord))
                .addGap(55, 55, 55)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSkapaKonto)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEfternamn, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtFornamn))))
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel15)
                .addGap(10, 10, 10)
                .addComponent(txtTelefonnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSkapaKonto)
                    .addComponent(rbtnAdmin))
                .addGap(30, 30, 30))
        );

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("V�lj person att ge Adminstatus:");

        jLabel14.setText("S�tt ej \"actionperformed\" p� comboboxen!");

        javax.swing.GroupLayout pnlAdminRightsLayout = new javax.swing.GroupLayout(pnlAdminRights);
        pnlAdminRights.setLayout(pnlAdminRightsLayout);
        pnlAdminRightsLayout.setHorizontalGroup(
            pnlAdminRightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminRightsLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlAdminRightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton11)
                    .addGroup(pnlAdminRightsLayout.createSequentialGroup()
                        .addGroup(pnlAdminRightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        pnlAdminRightsLayout.setVerticalGroup(
            pnlAdminRightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminRightsLayout.createSequentialGroup()
                .addGroup(pnlAdminRightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAdminRightsLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel14))
                    .addGroup(pnlAdminRightsLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(345, Short.MAX_VALUE))
        );

        tabbedPaneBar.addTab("Admin", pnlAdminRights);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneBar)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneBar)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUppdateraInformellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUppdateraInformellActionPerformed
        // TODO add your handling code here:
        try {
            uppdateraInformellBlogg();
            uppdateraFormellBlogg();
            revalidate();
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_btnUppdateraInformellActionPerformed

    private void btnUppdateraFormellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUppdateraFormellActionPerformed
        // TODO add your handling code here:
        try {
            uppdateraFormellBlogg();
            uppdateraInformellBlogg();
            revalidate();
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_btnUppdateraFormellActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File fil = chooser.getSelectedFile();

        String filNamn = String.valueOf(fil);

        if (!filNamn.equals("null")) {
            System.out.println(filNamn);
            String fileName = fil.getAbsolutePath();
            System.out.println(fileName);
            System.out.println(fil);
            String namn = chooser.getName(fil);
            if (checkPdf(namn)) {
                sparaFil(fil, namn);
                jLabel22.setText(namn);
            } else {
                JOptionPane.showMessageDialog(null, "Du m�ste v�lja en pdf fil");
            }
        }

    }//GEN-LAST:event_jButton13ActionPerformed

    private void btnPubliceraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPubliceraActionPerformed

        try {
            if (Validering.textIsEmpty(txtSattRubrik)) {
                JOptionPane.showMessageDialog(null, "V�nligen fyll i rubrik");
            } else if (Validering.textAreaIsEmpty(txtBrodtext)) {
                JOptionPane.showMessageDialog(null, "V�nligen fyll i br�dtext");
            } else {
                SQL.laggaTillBloggInlagg(db, txtSattRubrik.getText(), txtBrodtext.getText(), " ", anvandarID, cmbInlaggsTyp.getSelectedItem().toString());
                tomFalt();
                JOptionPane.showMessageDialog(null, "Inl�gg publicerat!");
            }
        } catch (NoSuchAlgorithmException e) {
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_btnPubliceraActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        //            String rubrik = "";
        //            String text = "";
        //            String filURL = "";
        //
        //            int skrivenAv = anvandarID;
        //            int projektInlaggID = 1;
        //        ProjektInlagg testProjekt = new ProjektInlagg(db, rubrik, text, skrivenAv, filURL, anvandarID, projektInlaggID);
        //         testProjekt.setVisible(true);
        //new SkapaNyttProjekt(db).setVisible(true);
        String rubrik = "";
        String text = "";
        String filURL = "";
        String skrivenAv = Integer.toString(anvandarID);
        String projektInlaggID = Integer.toString(1);
        ProjektInlagg testProjekt = new ProjektInlagg(db, rubrik, text, skrivenAv, filURL, anvandarID, projektInlaggID);
        testProjekt.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new SkapaNyttProjekt(db).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSkapaKontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaKontoActionPerformed

        String epost = txtEpost.getText();
        String fornamn = txtFornamn.getText();
        String efternamn = txtEfternamn.getText();
        String losenord = new String(pswLosenord.getPassword());
        String telefonNummer = txtTelefonnummer.getText();
        String admin = "";

        if (rbtnAdmin.isSelected()) {
            admin = "J";
        } else {
            admin = "N";
        }

        if (Validering.textIsEmpty(txtEpost)) {
            JOptionPane.showMessageDialog(null, "V�nligen fyll i en E-post");
        } else if (Validering.textIsEmpty(txtFornamn)) {
            JOptionPane.showMessageDialog(null, "V�nligen fyll i f�rnamn");
        } else if (Validering.textIsEmpty(txtEfternamn)) {
            JOptionPane.showMessageDialog(null, "V�nligen fyll i efternamn");
        } else if (Validering.passwordIsEmpty(pswLosenord)) {
            JOptionPane.showMessageDialog(null, "V�nligen fyll i ett l�senord");
        } else if (Validering.textIsEmpty(txtTelefonnummer) || Validering.checkPhoneLength(txtTelefonnummer)) {
            JOptionPane.showMessageDialog(null, "Telefonnummer m�ste vara mellan 1-30 siffror");
        } else {
            try {
                SQL.laggTillAnvandare(db, epost, fornamn, efternamn, losenord, telefonNummer, admin);
                JOptionPane.showMessageDialog(null, "Kontot har skapats!");
                tomFalt();
            } catch (NoSuchAlgorithmException i) {

            } catch (SQLException e) {

            }
        }
    }//GEN-LAST:event_btnSkapaKontoActionPerformed

     public void uppdateraFormellBlogg() throws SQLException {
        pnlFormellBlogg.removeAll();

        ArrayList<ArrayList<String>> bloggInlagg = SQL.lasFormellaBlogginlagg(db);
        ArrayList<BloggInlaggsPanel> inlaggPaneler = new ArrayList<>();

        for (ArrayList<String> inlagg : bloggInlagg) {
            String rubrik = inlagg.get(0);
            String text = inlagg.get(1);
            String filURL = inlagg.get(2);
            String datum = inlagg.get(3);
            String skapatAv = inlagg.get(4);
            String bloggInlaggID = inlagg.get(5);
            BloggInlaggsPanel nyttInlagg = new BloggInlaggsPanel(db, rubrik, text, skapatAv, datum, filURL, anvandarID, bloggInlaggID, adminStatus);
            inlaggPaneler.add(nyttInlagg);
        }

        for (BloggInlaggsPanel inlagg : inlaggPaneler) {
            pnlFormellBlogg.add(inlagg);
        }
    }

    public void uppdateraInformellBlogg() throws SQLException {

        pnlInformellBlogg.removeAll();

        ArrayList<ArrayList<String>> bloggInlagg = SQL.lasInformellaBlogginlagg(db);
        ArrayList<BloggInlaggsPanel> inlaggPaneler = new ArrayList<>();

        for (ArrayList<String> inlagg : bloggInlagg) {
            String rubrik = inlagg.get(0);
            String text = inlagg.get(1);
            String filURL = inlagg.get(2);
            String datum = inlagg.get(3);
            String skapatAv = inlagg.get(4);
            String bloggInlaggID = inlagg.get(5);
            BloggInlaggsPanel nyttInlagg = new BloggInlaggsPanel(db, rubrik, text, skapatAv, datum, filURL, anvandarID, bloggInlaggID, adminStatus);
            inlaggPaneler.add(nyttInlagg);
        }
        for (BloggInlaggsPanel inlagg : inlaggPaneler) {
            pnlInformellBlogg.add(inlagg);
        }
    }

    public String visaFilTyp(String fileName) {

        String fileType = "Undetermined";
        final File file = new File(fileName);

        try {
            fileType = Files.probeContentType(file.toPath());

        } catch (IOException e) {
            System.out.println("kan inte hitta filtypen f�r: " + fileName + " p� grund av " + e);
        }

        return fileType;
    }

    public boolean checkPdf(String fileName) {
        boolean filCheck = false;

        if (visaFilTyp(fileName).equals("application/pdf")) {
            filCheck = true;
        }

        return filCheck;
    }

    public void sparaFil(File fil, String namn) {
        System.out.println(namn);
        File temp = new File("src\\systemutvecklingsprojekt\\AppData\\" + namn);
        File destination = new File(temp.getAbsolutePath());

        boolean bool = fil.renameTo(destination);
        System.out.print(bool);

    }

    private void tomFalt() {
        txtEpost.setText("");
        txtFornamn.setText("");
        txtEfternamn.setText("");
        pswLosenord.setText("");
        txtTelefonnummer.setText("");
        rbtnAdmin.setSelected(false);
        txtBrodtext.setText("");
        txtSattRubrik.setText("");
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane1;
    private javax.swing.JScrollPane ScrollPane3;
    private javax.swing.JButton btnPublicera;
    private javax.swing.JButton btnSkapaKonto;
    private javax.swing.JButton btnUppdateraFormell;
    private javax.swing.JButton btnUppdateraInformell;
    private javax.swing.JComboBox<String> cmbInlaggsTyp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel pnlAdminRights;
    private javax.swing.JPanel pnlFormellBlogg;
    private javax.swing.JPanel pnlInformellBlogg;
    private javax.swing.JPasswordField pswLosenord;
    private javax.swing.JRadioButton rbtnAdmin;
    private javax.swing.JTabbedPane tabbedPaneBar;
    private javax.swing.JTextArea txtBrodtext;
    private javax.swing.JTextField txtEfternamn;
    private javax.swing.JTextField txtEpost;
    private javax.swing.JTextField txtFornamn;
    private javax.swing.JTextField txtSattRubrik;
    private javax.swing.JTextField txtTelefonnummer;
    // End of variables declaration//GEN-END:variables
}