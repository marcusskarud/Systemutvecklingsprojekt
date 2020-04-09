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


/**
 *
 * @author MarcusSkarud
 */
public class SQL {
        
    public static void listaLarare(Connection db) throws SQLException{
    
        String sql = "SELECT id, namn, losenord FROM larare";

        Statement statement  = db.createStatement();
        ResultSet resultat    = statement.executeQuery(sql);

            while (resultat.next()) {
                System.out.println(resultat.getInt("id") +  "\t" + 
                                   resultat.getString("namn") + "\t" +
                                   resultat.getString("losenord"));
            }        
    }
    
    public static void laggTillLarare(Connection db,int id ,String namn, String losenord) throws NoSuchAlgorithmException, SQLException{
        
        String sql = "INSERT INTO larare(id,namn,losenord) VALUES(?,?,?)";
        String nyttHashLosenord = Kryptering.skapaHashLosenord(losenord);
        
            PreparedStatement statement = db.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, namn);
            statement.setString(3, nyttHashLosenord);

            statement.executeUpdate();
         
    }
}
