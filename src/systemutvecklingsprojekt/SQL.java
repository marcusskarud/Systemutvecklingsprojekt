/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemutvecklingsprojekt;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;


/**
 *
 * @author MarcusSkarud
 */
public class SQL {
        
    
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
    
    public static void laggTillAnvandare(Connection db,int id ,String namn, String losenord) throws NoSuchAlgorithmException, SQLException{
        
        String sql = "INSERT INTO Anvandare(AnvandarID,Fornamn,Losenord) VALUES(?,?,?)";
        String nyttHashLosenord = Kryptering.skapaHashLosenord(losenord);
        
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, namn);
            statement.setString(3, nyttHashLosenord);
            
            statement.executeUpdate();

    }
    
    public static ArrayList<ArrayList<String>> lasBlogginlagg(Connection db) throws SQLException{
        ArrayList<ArrayList<String>> retur = new ArrayList<ArrayList<String>>();
        ArrayList<String> arr = new ArrayList<String>();
    
        
        String sql = "SELECT * FROM Blogginlagg";

        Statement statement  = db.createStatement();
        ResultSet resultat    = statement.executeQuery(sql);

            while (resultat.next()) {
                arr.add(resultat.getString("Rubrik"));
                arr.add(resultat.getString("Text"));
                retur.add(arr);        
                
            }
        
        
        
        
        return retur;
    }
    
    
    public static ArrayList<String> loggaIn(Connection db, String epost, String losenord){
        String sql = "";
        ArrayList<String> resultat = null;
        
    
    
    
        return resultat;
    }
}
