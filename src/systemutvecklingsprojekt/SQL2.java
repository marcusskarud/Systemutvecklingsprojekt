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
    
        String sql = "SELECT AnvandarID, Fornamn, Losenord FROM Anvandare";

        Statement statement  = db.createStatement();
        ResultSet resultat    = statement.executeQuery(sql);

            while (resultat.next()) {
                System.out.println(resultat.getInt("AnvandarID") +  "\t" + 
                                   resultat.getString("Fornamn") + "\t" +
                                   resultat.getString("Losenord"));
            }        
    }
    
    public static void laggTillAnvandare(Connection db,int id ,String epost,String fornamn,String efternamn, String losenord, String telefonNummer, String admin) throws NoSuchAlgorithmException, SQLException{
        
        String sql = "INSERT INTO Anvandare (AnvandarID,Epost,Losenord, Fornamn, Efternamn, Telefonnummer, admin) VALUES(?,?,?,?,?,?,?)";
        String nyttHashLosenord = Kryptering.skapaHashLosenord(losenord);
        
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setInt(1, id);
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
