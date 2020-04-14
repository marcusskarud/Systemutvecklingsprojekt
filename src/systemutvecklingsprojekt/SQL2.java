/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemutvecklingsprojekt;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MarcusSkarud
 */
public class SQL2 {
       
    public static void listaAllaAnvandare(Connection db) throws SQLException{
    
        String sql = "SELECT AnvandarID, Epost, Losenord, Fornamn, Efternamn, Telefonnummer, Admin FROM Anvandare";

        Statement statement  = db.createStatement();
        ResultSet resultat    = statement.executeQuery(sql);

            while (resultat.next()) {
                System.out.println(resultat.getInt("AnvandarID") +  "\t" + 
                                   resultat.getString("Epost") + "\t" +
                        resultat.getString("Losenord") + "\t" +
                        resultat.getString("Fornamn") + "\t" +
                        resultat.getString("Efternamn") + "\t" +
                        resultat.getString("Telefonnummer") + "\t" +
                        resultat.getString("Admin"));
                        
            }        
    }
    
    public static void laggTillAnvandare(Connection db, String epost, String fornamn, String efternamn, String losenord, String telefonNummer, String admin) throws NoSuchAlgorithmException, SQLException{
        
        String sql = "INSERT INTO Anvandare (AnvandarID, Epost, Losenord, Fornamn, Efternamn, Telefonnummer, Admin) VALUES (?,?,?,?,?,?,?)";
        String nyttHashLosenord = Kryptering.skapaHashLosenord(losenord);
        
        String sqlAnvandare = "Select Max (AnvandarID) from Anvandare";
        
        Statement anvandarStatement  = db.createStatement();
        ResultSet resultat    = anvandarStatement.executeQuery(sqlAnvandare);
        String antalAnvandare = resultat.getString(1);
        
        int intsqlAnvandare = Integer.parseInt(antalAnvandare);
        int nyttAnvandarId = intsqlAnvandare + 1;
        
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setInt(1, nyttAnvandarId);
            statement.setString(2, epost);
            statement.setString(3, nyttHashLosenord);
            statement.setString(4, fornamn );
            statement.setString(5, efternamn);
            statement.setString(6, telefonNummer);
            statement.setString(7, admin);
            
            statement.executeUpdate();

    }
    
    public static void loggaIn(Connection db, String epost, String losenord){
        String sql = "";
        
    
    
    
    }
}
