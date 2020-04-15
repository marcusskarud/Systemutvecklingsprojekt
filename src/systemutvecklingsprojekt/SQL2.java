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
//import java.text.SimpleDateFormat;
//import java.util.Date;

/**
 *
 * @author MarcusSkarud
 */
public class SQL2 {

    public static void listaAllaAnvandare(Connection db) throws SQLException {

        String sql = "SELECT AnvandarID, Epost, Losenord, Fornamn, Efternamn, Telefonnummer, Admin FROM Anvandare";

        Statement statement = db.createStatement();
        ResultSet resultat = statement.executeQuery(sql);

        while (resultat.next()) {
            System.out.println(resultat.getInt("AnvandarID") + "\t"
                    + resultat.getString("Epost") + "\t"
                    + resultat.getString("Losenord") + "\t"
                    + resultat.getString("Fornamn") + "\t"
                    + resultat.getString("Efternamn") + "\t"
                    + resultat.getString("Telefonnummer") + "\t"
                    + resultat.getString("Admin"));

        }
    }

    public static void laggTillAnvandare(Connection db, String epost, String fornamn, String efternamn, String losenord, String telefonNummer, String admin) throws NoSuchAlgorithmException, SQLException {

        String sql = "INSERT INTO Anvandare (AnvandarID, Epost, Losenord, Fornamn, Efternamn, Telefonnummer, Admin) VALUES (?,?,?,?,?,?,?)";
        String nyttHashLosenord = Kryptering.skapaHashLosenord(losenord);

        String sqlAnvandare = "Select Max (AnvandarID) from Anvandare";

        Statement anvandarStatement = db.createStatement();
        ResultSet resultat = anvandarStatement.executeQuery(sqlAnvandare);
        String antalAnvandare = resultat.getString(1);

        int intsqlAnvandare = Integer.parseInt(antalAnvandare);
        int nyttAnvandarId = intsqlAnvandare + 1;

        PreparedStatement statement = db.prepareStatement(sql);
        statement.setInt(1, nyttAnvandarId);
        statement.setString(2, epost);
        statement.setString(3, nyttHashLosenord);
        statement.setString(4, fornamn);
        statement.setString(5, efternamn);
        statement.setString(6, telefonNummer);
        statement.setString(7, admin);

        statement.executeUpdate();

    }

    public static void loggaIn(Connection db, String epost, String losenord) {
        String sql = "";

    }

    public static void laggaTillBloggInlägg(Connection db, String rubrik, String text, String filURL, int skapatAv) throws NoSuchAlgorithmException, SQLException {
        String sql = "insert into blogginlagg (blogginlaggsid, rubrik, text, filurl, datumtid, skapatav) values(?, ?, ?, ?, ?, ?)";
              
        String sqlBlogggInlaggsID = "Select Max (blogginlaggsid) from blogginlagg";

        Statement anvandarStatement = db.createStatement();
        ResultSet resultat = anvandarStatement.executeQuery(sqlBlogggInlaggsID);
        String antalBloggInlagg = resultat.getString(1);

        int intSQLBloggInlagg = Integer.parseInt(antalBloggInlagg);
        int nyttBloggInlagg = intSQLBloggInlagg + 1;
        
        PreparedStatement statement = db.prepareStatement(sql);
        statement.setInt(1, nyttBloggInlagg);
        statement.setString(2, rubrik);
        statement.setString(3, text);
        //statement.setString(4, filURL); Hur ska vi göra med filer?? // William, Jonas
        //statement.setDate(5,  datumTid); Hur ska datum och tid hanteras?? // William, Jonas
        statement.setInt(6, skapatAv);
    }
    
    public static void redigeraBloggInlagg(Connection db, int bloggInlaggsID, String rubrik, String text, String filURL, int skapatAv) throws NoSuchAlgorithmException, SQLException{
        String sql = "update bloggInlagg set rubrik = " + rubrik + ", text = " + text + ", filURL = " + filURL + " WHERE bloggInlaggsID = " + bloggInlaggsID;
    }
    
    public static void raderaBloggInlagg(Connection db, int bloggInlaggsID) throws NoSuchAlgorithmException, SQLException{
        String sql = "DELETE FROM bloggInlagg WHERE bloggInlaggsID = " + bloggInlaggsID;
    }
    
    
}
