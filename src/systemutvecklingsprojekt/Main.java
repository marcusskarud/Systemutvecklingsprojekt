/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemutvecklingsprojekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author MarcusSkarud
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    private static Connection db;

    
    public static void main(String[] args) {
    
        String aktuellMap = System.getProperty("user.dir");
        String sokVag = aktuellMap + ("/dbTest.db");
        
        String url = "jdbc:sqlite:" + sokVag;
        
        try {
            db = DriverManager.getConnection(url);
            SQL2.listaAllaAnvandare(db);
        }
         catch (SQLException e) {
                System.out.println(e.getMessage());
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartFönster(db).setVisible(true);
            }
        });    
    }
    
}
