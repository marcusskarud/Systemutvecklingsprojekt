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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author MarcusSkarud
 */
public class SQL {

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

    public static ArrayList epostTillAnvandarID(Connection db, ArrayList<String> epostLista) throws SQLException {
        ArrayList<Integer> idLista = new ArrayList<>();

        for (String epost : epostLista) {
            String sql = "SELECT AnvandarID FROM Anvandare WHERE Epost = '" + epost + "'";

            Statement statement = db.createStatement();
            ResultSet resultat = statement.executeQuery(sql);

            while (resultat.next()) {
                idLista.add(resultat.getInt("AnvandarID"));

            }
        }
        System.out.println(idLista);
        return idLista;
    }

    public static void skapaProjektGruppIDatabas(Connection db, ArrayList<Integer> anvandare, String gruppNamn, String gruppBeskrivning, String kategori, int anvandarID) throws SQLException {

        String utvecklingsArbetsIDSQL = "SELECT MAX(UtvecklingsarbetsID) FROM Utvecklingsarbete";

        Statement utvecklingStatement = db.createStatement();
        ResultSet resultat = utvecklingStatement.executeQuery(utvecklingsArbetsIDSQL);
        String antalUtvecklingsArbeten = resultat.getString(1);

        int nyttID;
        try {
            int intSQLUtvecklingsArbete = Integer.parseInt(antalUtvecklingsArbeten);
            nyttID = intSQLUtvecklingsArbete + 1;
        } catch (NumberFormatException e) {
            nyttID = 1;
        }

        String sql = "INSERT INTO Utvecklingsarbete VALUES (?,?,?,?) ";

        PreparedStatement statement = db.prepareStatement(sql);
        statement.setInt(1, nyttID);
        statement.setString(2, gruppNamn);
        statement.setString(3, gruppBeskrivning);
        statement.setInt(4, anvandarID);

        statement.executeUpdate();

        String sql2 = "INSERT INTO " + kategori + " VALUES (?) ";

        PreparedStatement statement2 = db.prepareStatement(sql2);
        statement2.setInt(1, nyttID);

        statement2.executeUpdate();

        for (Integer enAnvandare : anvandare) {
            String sql3 = "INSERT INTO UtvecklingsDeltagare VALUES (?,?) ";

            PreparedStatement statement3 = db.prepareStatement(sql3);
            statement3.setInt(1, nyttID);
            statement3.setInt(2, enAnvandare);

            statement3.executeUpdate();
        }
    }

    public static ArrayList getAnvandareItemList(Connection db) throws SQLException {

        String sql = "SELECT AnvandarID, Epost, Fornamn, Efternamn, Telefonnummer, Admin FROM Anvandare";

        Statement statement = db.createStatement();
        ResultSet resultat = statement.executeQuery(sql);
        ArrayList<ArrayList<String>> anvandarLista = new ArrayList<ArrayList<String>>();

        while (resultat.next()) {
            ArrayList<String> resultatList = new ArrayList<String>();

            resultatList.add(String.valueOf(resultat.getInt("AnvandarID")));
            resultatList.add(resultat.getString("Epost"));
            resultatList.add(resultat.getString("Fornamn"));
            resultatList.add(resultat.getString("Efternamn"));
            resultatList.add(resultat.getString("Telefonnummer"));
            resultatList.add(resultat.getString("Admin"));

            anvandarLista.add(resultatList);
        }
        return anvandarLista;

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

    public static void laggaTillBloggInlagg(Connection db, String rubrik, String text, String filURL, int skapatAv, String inlaggsTyp) throws NoSuchAlgorithmException, SQLException {
        String sql = "INSERT INTO Blogginlagg (BlogginlaggsID, Rubrik, Text, FilURL, Datumtid, SkapatAv) VALUES (?,?,?,?,?,?)";

        String sqlBlogggInlaggsID = "SELECT MAX(BlogginlaggsID) FROM Blogginlagg";

        Statement anvandarStatement = db.createStatement();
        ResultSet resultat = anvandarStatement.executeQuery(sqlBlogggInlaggsID);
        String antalBloggInlagg = resultat.getString(1);

        int intSQLBloggInlagg = Integer.parseInt(antalBloggInlagg);
        int nyttBloggInlagg = intSQLBloggInlagg + 1;

        String datumTid = getTid();

        PreparedStatement statement = db.prepareStatement(sql);
        statement.setInt(1, nyttBloggInlagg);
        statement.setString(2, rubrik);
        statement.setString(3, text);
        statement.setString(4, filURL); //Hur ska vi göra med filer?? // William, Jonas
        statement.setString(5, datumTid); //Hur ska datum och tid hanteras?? // William, Jonas
        statement.setInt(6, skapatAv);

        statement.executeUpdate();
        String sql2 = "";
        if (inlaggsTyp.equals("Informell blogg")) {
            sql2 = "INSERT INTO InformellBlogg VALUES (?)";
        } else {
            sql2 = "INSERT INTO FormellBlogg VALUES (?)";
        }
        PreparedStatement statement2 = db.prepareStatement(sql2);
        statement2.setInt(1, nyttBloggInlagg);

        statement2.executeUpdate();
    }

    public static boolean getFormellaInlagg(Connection db, String blogginlaggsID) {
        boolean formelltInlagg = false;
        try{
        String sql = "SELECT * FROM FormellBlogg where InlaggsID = " + blogginlaggsID;
        Statement statement = db.createStatement();
        ResultSet resultat = statement.executeQuery(sql);
        System.out.println(formelltInlagg);
        while (resultat.next()) {
            formelltInlagg = true;
        }
        System.out.println(formelltInlagg);}
        catch(SQLException e){}
        return formelltInlagg;
    }

    public static ArrayList<ArrayList<String>> lasFormellaBlogginlagg(Connection db) throws SQLException {
        ArrayList<ArrayList<String>> retur = new ArrayList<ArrayList<String>>();

        String sql = "SELECT * FROM Blogginlagg join formellBlogg on bloggInlaggsID = inlaggsID";

        Statement statement = db.createStatement();
        ResultSet resultat = statement.executeQuery(sql);

        while (resultat.next()) {
            ArrayList<String> arr = new ArrayList<String>();

            arr.add(resultat.getString("Rubrik"));
            arr.add(resultat.getString("Text"));
            arr.add(resultat.getString("FilURL"));
            arr.add(resultat.getString("Datumtid"));
            arr.add(String.valueOf(resultat.getInt("SkapatAv")));
            arr.add(String.valueOf(resultat.getInt("BlogginlaggsID")));

            retur.add(arr);

        }

        for (ArrayList<String> inlagg : retur) {
            String rubrik = inlagg.get(0);
            String text = inlagg.get(1);
            String filURL = inlagg.get(2);
            String datum = inlagg.get(3);
            String skapatAv = inlagg.get(4);
            String bloggInlaggID = inlagg.get(5);
            System.out.println("Rubrik: " + rubrik + "\n" + "Text: " + text + " " + filURL + " "
                    + datum + " " + skapatAv + " " + bloggInlaggID);
        }

        return retur;
    }

    public static ArrayList<ArrayList<String>> lasInformellaBlogginlagg(Connection db) throws SQLException {
        ArrayList<ArrayList<String>> retur = new ArrayList<ArrayList<String>>();

        String sql = "SELECT * FROM Blogginlagg join informellBlogg on bloggInlaggsID = inlaggsID";

        Statement statement = db.createStatement();
        ResultSet resultat = statement.executeQuery(sql);

        while (resultat.next()) {
            ArrayList<String> arr = new ArrayList<String>();

            arr.add(resultat.getString("Rubrik"));
            arr.add(resultat.getString("Text"));
            arr.add(resultat.getString("FilURL"));
            arr.add(resultat.getString("Datumtid"));
            arr.add(String.valueOf(resultat.getInt("SkapatAv")));
            arr.add(String.valueOf(resultat.getInt("BlogginlaggsID")));

            retur.add(arr);

        }

        for (ArrayList<String> inlagg : retur) {
            String rubrik = inlagg.get(0);
            String text = inlagg.get(1);
            String filURL = inlagg.get(2);
            String datum = inlagg.get(3);
            String skapatAv = inlagg.get(4);
            String bloggInlaggID = inlagg.get(5);
            System.out.println("Rubrik: " + rubrik + "\n" + "Text: " + text + " " + filURL + " "
                    + datum + " " + skapatAv + " " + bloggInlaggID);
        }

        return retur;
    }

    public static boolean loggaInCheck(Connection db, String epost, String losenord) throws NoSuchAlgorithmException {

        boolean inloggad = false;
        int id = 0;
        String krypteratLosen = Kryptering.skapaHashLosenord(losenord);

        try {
            String sql = "SELECT AnvandarID FROM Anvandare WHERE Epost ='" + epost + "' AND Losenord='" + krypteratLosen + "'";

            Statement statement = db.createStatement();
            ResultSet resultat = statement.executeQuery(sql);
            while (resultat.next()) {
                id = resultat.getInt("AnvandarID");

            }

        } catch (SQLException fel) {
            System.out.println(fel.getMessage());
            id = 0;
        }
        if (id > 0) {

            inloggad = true;

        } else {
            JOptionPane.showMessageDialog(null, "Fel lösenord eller användarnamn");
        }

        return inloggad;
    }

    public static boolean inloggning(Connection db, String epost, String losenord) throws NoSuchAlgorithmException, SQLException {
        boolean inloggad = false;
        if (loggaInCheck(db, epost, losenord)) {
            String sql = "SELECT AnvandarID, Admin FROM Anvandare WHERE Epost ='" + epost + "'";

            Statement statement = db.createStatement();
            ResultSet resultat = statement.executeQuery(sql);
            int id = resultat.getInt("AnvandarID");
            String admin = resultat.getString("Admin");
            inloggad = true;

            new Inloggad(db, id, admin).setVisible(true);

        }
        return inloggad;
    }

    public static void redigeraBloggInlagg(Connection db, int bloggInlaggsID, String rubrik, String text, String filURL, int skapatAv) /*throws NoSuchAlgorithmException, SQLException */ {
        try {
            String sql;
            System.out.println("innan");
            if (filURL == null || filURL.isEmpty()) {
                sql = "UPDATE BloggInlagg SET Rubrik = '" + rubrik + "', Text = '" + text + "' WHERE BloggInlaggsID = " + bloggInlaggsID;
                System.out.println("if");
            } else {
                sql = "UPDATE BloggInlagg SET Rubrik = '" + rubrik + "', Text = '" + text + "', FilURL = '" + filURL + "' WHERE BloggInlaggsID = " + bloggInlaggsID;
                System.out.println("else");
            }
            PreparedStatement uppdateraStatement = db.prepareStatement(sql);
            uppdateraStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void raderaBloggInlagg(Connection db, int bloggInlaggsID) throws NoSuchAlgorithmException, SQLException {
        String sql = "DELETE FROM InformellBlogg WHERE InlaggsID = " + bloggInlaggsID;
        PreparedStatement taBortStatement = db.prepareStatement(sql);
        taBortStatement.executeUpdate();
        String sql1 = "DELETE FROM FormellBlogg WHERE InlaggsID = " + bloggInlaggsID;
        PreparedStatement taBortStatement1 = db.prepareStatement(sql1);
        taBortStatement1.executeUpdate();
        String sql2 = "DELETE FROM Bloggamne WHERE BlogginlaggsID = " + bloggInlaggsID;
        PreparedStatement taBortStatement2 = db.prepareStatement(sql2);
        taBortStatement2.executeUpdate();

        String sql3 = "DELETE FROM BloggInlagg WHERE BloggInlaggsID = " + bloggInlaggsID;
        PreparedStatement taBortStatement3 = db.prepareStatement(sql3);
        taBortStatement3.executeUpdate();
    }

    private static String getTid() {
        SimpleDateFormat datumformaterare = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp klockslag = new Timestamp(System.currentTimeMillis());
        String datumTid = datumformaterare.format(klockslag);

        return datumTid;
    }

    public static void laggaTillProjektInlagg(Connection db, String rubrik, String text, String filURL, int skrivenAv, int tillhorArbete) throws NoSuchAlgorithmException, SQLException {
        String sql = "INSERT INTO Utvecklingsarbetsinlagg (InlaggsID, Rubrik, Text, FilURL, skrivenAv, TillhörArbete) VALUES (?,?,?,?,?,?)";

        String sqlProjektInlaggsID = "SELECT MAX(InlaggsID) FROM Utvecklingsarbetsinlagg";

        Statement anvandarStatement = db.createStatement();
        ResultSet resultat = anvandarStatement.executeQuery(sqlProjektInlaggsID);
        String antalProjektInlagg = resultat.getString(1);

        int intSQLProjektInlagg = Integer.parseInt(antalProjektInlagg);
        int nyttProjektInlagg = intSQLProjektInlagg + 1;

        PreparedStatement statement = db.prepareStatement(sql);
        statement.setInt(1, nyttProjektInlagg);
        statement.setString(2, rubrik);
        statement.setString(3, text);
        statement.setString(4, filURL);
        statement.setInt(5, skrivenAv);
        statement.setInt(6, tillhorArbete);

        statement.executeUpdate();

    }

    public static String getProjektNamn(Connection db) throws NoSuchAlgorithmException, SQLException {
        String sql = "SELECT namn FROM Utvecklingsarbete WHERE utvecklingsarbetsID = 1";
        Statement statement = db.createStatement();
        ResultSet resultat = statement.executeQuery(sql);
        String projektnamn = resultat.getString("Namn");
        return projektnamn;

    }

    public static void gillaInformellBlogginlagg(Connection db, int anvandarID, int blogginlaggsID) throws NoSuchAlgorithmException, SQLException {
        String sql = "INSERT INTO HarGillat (AnvandarID, BlogginlaggsID) VALUES (?,?)";

        PreparedStatement statement = db.prepareStatement(sql);
        statement.setInt(1, anvandarID);
        statement.setInt(2, blogginlaggsID);

        statement.executeUpdate();
    }

    public static void taBortLike(Connection db, int anvandarID, int blogginlaggsID) throws NoSuchAlgorithmException, SQLException {
        String sql = "DELETE FROM HarGillat WHERE AnvandarID = " + anvandarID + " and BlogginlaggsID = " + blogginlaggsID;

        PreparedStatement taBortStatement = db.prepareStatement(sql);
        taBortStatement.executeUpdate();

        taBortStatement.executeUpdate();
    }

    public static String getAntalLikes(Connection db, String blogginlaggsID) throws NoSuchAlgorithmException, SQLException {

        String sql = "SELECT COUNT(*) AS antalLikes FROM HarGillat WHERE BlogginlaggsID = " + blogginlaggsID;
        Statement statement = db.createStatement();
        ResultSet resultat = statement.executeQuery(sql);
        String antalLikes = resultat.getString("antalLikes");
        return antalLikes;
    }

    public static boolean getLikeStatus(Connection db, int anvandarID, String blogginlaggsID) {
        boolean gillad = false;
        try {
            ArrayList<Integer> anvandareSomGillat = new ArrayList<Integer>();

            String sql = "SELECT AnvandarID FROM HarGillat WHERE BlogginlaggsID = " + blogginlaggsID;
            Statement statement = db.createStatement();
            ResultSet resultat = statement.executeQuery(sql);

            System.out.println(resultat);
            while (resultat.next()) {

                anvandareSomGillat.add(resultat.getInt("AnvandarID"));

            }

            for (Integer anvandare : anvandareSomGillat) {

                if (anvandare == anvandarID) {
                    gillad = true;
                }

            }

        } catch (SQLException e) {
        }
        return gillad;
    }
}
