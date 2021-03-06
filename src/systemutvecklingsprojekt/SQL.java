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

    //Dessa kan tas bort
//    SELECT Namn FROM Utvecklingsarbete JOIN Forskning ON Utvecklingsarbete.UtvecklingsarbetsID = Forskning.UtvecklingsarbetsID WHERE Utvecklingsarbete.UtvecklingsarbetsID IN (SELECT UtvecklingsarbetsID FROM UtvecklingsDeltagare WHERE AnvandarID = " + anvandarID + ")";
//    SELECT Namn FROM Utvecklingsarbete JOIN Utbildning ON Utvecklingsarbete.UtvecklingsarbetsID = Utbildning.UtvecklingsarbetsID WHERE Utvecklingsarbete.UtvecklingsarbetsID IN (SELECT UtvecklingsarbetsID FROM UtvecklingsDeltagare WHERE AnvandarID = 1);
    public static ArrayList hamtaProjektGruppNamn(Connection db, int anvandarID) throws SQLException {

        boolean deltarIForskning = false;
        boolean deltarIUtbildning = false;

        ArrayList<ArrayList<String>> projektNamnLista = new ArrayList<>();

        ArrayList<String> forskningsLista = new ArrayList<String>();

        ArrayList<String> utbildningsLista = new ArrayList<String>();

        String sqlForskning = "SELECT Namn FROM Utvecklingsarbete JOIN Forskning ON Utvecklingsarbete.UtvecklingsarbetsID = Forskning.UtvecklingsarbetsID WHERE Utvecklingsarbete.UtvecklingsarbetsID IN (SELECT UtvecklingsarbetsID FROM UtvecklingsDeltagare WHERE AnvandarID = " + anvandarID + ")";
        Statement statement = db.createStatement();
        ResultSet forskning = statement.executeQuery(sqlForskning);

        while (forskning.next()) {
            forskningsLista.add(forskning.getString("Namn"));
            deltarIForskning = true;
        }

        String sqlUtbildning = "SELECT Namn FROM Utvecklingsarbete JOIN Utbildning ON Utvecklingsarbete.UtvecklingsarbetsID = Utbildning.UtvecklingsarbetsID WHERE Utvecklingsarbete.UtvecklingsarbetsID IN (SELECT UtvecklingsarbetsID FROM UtvecklingsDeltagare WHERE AnvandarID = " + anvandarID + ")";
        Statement statement2 = db.createStatement();
        ResultSet utbildning = statement2.executeQuery(sqlUtbildning);

        while (utbildning.next()) {
            utbildningsLista.add(utbildning.getString("Namn"));
            deltarIUtbildning = true;
        }

        if (deltarIForskning == true) {
            forskningsLista.add(0, "Forskning:"); //Skapar en icke-funktionell item i cmb som agerar rubrik.
        }

        if (deltarIUtbildning == true) {
            utbildningsLista.add(0, "Utbildning:"); //Skapar en icke-funktionell item i cmb som agerar rubrik.
        }

        if (deltarIForskning == false && deltarIUtbildning == false) {
            forskningsLista.add("Inga Projekt");   //Skapar en icke-funktionell item i cmb som agerar rubrik.
            //utbildningsLista.add("Inga UtbildningsProjekt"); //Skapar en icke-funktionell item i cmb som agerar rubrik.
        }
        projektNamnLista.add(forskningsLista);
        projektNamnLista.add(utbildningsLista);

        System.out.println(projektNamnLista);
        return projektNamnLista;
    }

    public static ArrayList lasInProjektGrupper(Connection db, String utvecklingsArbetsNamn) throws SQLException {

        ArrayList<ArrayList<String>> projektInlaggLista = new ArrayList<ArrayList<String>>();

        String sql = "SELECT * FROM Utvecklingsarbetsinlagg WHERE Tillh�rArbete = (SELECT UtvecklingsarbetsID from Utvecklingsarbete WHERE Namn = '" + utvecklingsArbetsNamn + "') order by InlaggsID desc";

        Statement statement = db.createStatement();
        ResultSet resultat = statement.executeQuery(sql);

        while (resultat.next()) {
            ArrayList<String> inlaggsInfoLista = new ArrayList<String>();

            inlaggsInfoLista.add(String.valueOf(resultat.getInt("InlaggsID")));
            inlaggsInfoLista.add(resultat.getString("Rubrik"));
            inlaggsInfoLista.add(resultat.getString("Text"));
            inlaggsInfoLista.add(resultat.getString("FilURL"));
            inlaggsInfoLista.add(String.valueOf(resultat.getInt("SkrivenAv")));
            inlaggsInfoLista.add(String.valueOf(resultat.getInt("Tillh�rArbete")));
            inlaggsInfoLista.add(hamtaDenSomSkrivit(db, String.valueOf(resultat.getInt("SkrivenAv"))));

            projektInlaggLista.add(inlaggsInfoLista);

        }

        return projektInlaggLista;
    }

    public static int hamtaProjektGruppID(Connection db, String gruppNamn) throws SQLException {
        String sql = "SELECT UtvecklingsarbetsID FROM Utvecklingsarbete WHERE Namn = '" + gruppNamn + "'";
        Statement statement = db.createStatement();
        ResultSet resultat = statement.executeQuery(sql);

        int gruppID = 0;

        while (resultat.next()) {
            gruppID = resultat.getInt("UtvecklingsarbetsID");
        }
        if (gruppID == 0) {
            System.out.println("gruppID �r noll 0");
        }
        return gruppID;

    }

    public static String hamtaDenSomSkrivit(Connection db, String vemSomSkrivit) throws SQLException {
        String sql = "SELECT Fornamn, Efternamn FROM Anvandare WHERE AnvandarID = " + vemSomSkrivit;
        Statement statement = db.createStatement();
        ResultSet resultat = statement.executeQuery(sql);

        String forfattare = "";

        while (resultat.next()) {
            forfattare = resultat.getString("Fornamn") + " " + resultat.getString("Efternamn");
        }

        return forfattare;
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

    
 


    public static void skapaNyttMote(Connection db, ArrayList<Integer> anvandare, String namn, String beskrivning, String datumtid, String startTid, String slutTid, int skapare) throws SQLException {

        String MotesIDDSQL = "SELECT MAX(MotesID) FROM Mote";

        Statement utvecklingStatement = db.createStatement();
        ResultSet resultat = utvecklingStatement.executeQuery(MotesIDDSQL);
        String antalMoten = resultat.getString(1);

        int nyttID;
        try {
            int intSQLUtvecklingsArbete = Integer.parseInt(antalMoten);
            nyttID = intSQLUtvecklingsArbete + 1;
        } catch (NumberFormatException e) {
            nyttID = 1;
        }

        String sql = "INSERT INTO Mote VALUES (?,?,?,?,?,?,?) ";

        PreparedStatement statement = db.prepareStatement(sql);
        statement.setInt(1, nyttID);
        statement.setString(2, namn);
        statement.setString(3, beskrivning);
        statement.setInt(4, skapare);
        statement.setString(5, datumtid);
        statement.setString(6, startTid);
        statement.setString(7, slutTid);

        System.out.println(nyttID + " " + namn + " " + beskrivning + " " + skapare + " " + datumtid + " " + startTid + " " + slutTid);

        statement.executeUpdate();

        
        for (Integer enAnvandare : anvandare) {
            String sql2 = "INSERT INTO Motesdeltagare VALUES (?,?) ";

            PreparedStatement statement2 = db.prepareStatement(sql2);
            statement2.setInt(1, nyttID);
            statement2.setInt(2, enAnvandare);

            statement2.executeUpdate();
        }
        

    }
    
    public static ArrayList<String> kollaOmLedigtDatum(Connection db, String datum, ArrayList<Integer> anvandarID) throws SQLException{
       // String sql = "SELECT MotesID FROM Motesdeltagare JOIN Mote ON Motesdeltagare.MotesID = MotesID WHERE AnvandarID = '" + "'";
                ArrayList<String> uppTagnaMedlemmar = new ArrayList<String>();
           
                String sql = "SELECT AnvandarID FROM Motesdeltagare JOIN Mote ON Motesdeltagare.MotesID = Mote.MotesID WHERE Datum = '" + datum +"'";
                Statement statement = db.createStatement();
                ResultSet resultat = statement.executeQuery(sql);

            while (resultat.next()) {
                for(Integer inValdaAnv : anvandarID){
                    if(inValdaAnv == resultat.getInt("AnvandarID")){
                       String sql1 = "SELECT Fornamn, Efternamn, Epost FROM Anvandare WHERE AnvandarID = " + inValdaAnv + "";
                       Statement statement1 = db.createStatement();
                       ResultSet resultat1 = statement1.executeQuery(sql1);
                            while (resultat1.next()){
                                String svar = resultat1.getString("Fornamn") + " " + resultat1.getString("Efternamn") + "\n" + resultat1.getString("Epost");
                                    uppTagnaMedlemmar.add(svar);
                            }
                    }
                }    
        }
          return uppTagnaMedlemmar; 
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
            statement3.setInt(1, enAnvandare);
            statement3.setInt(2, nyttID);

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
        statement.setString(4, filURL); //Hur ska vi g�ra med filer?? // William, Jonas
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
        try {
            String sql = "SELECT * FROM FormellBlogg where InlaggsID = " + blogginlaggsID;
            Statement statement = db.createStatement();
            ResultSet resultat = statement.executeQuery(sql);

            while (resultat.next()) {
                formelltInlagg = true;
            }
        } catch (SQLException e) {
        }
        return formelltInlagg;
    }

    public static boolean getInformellaInlagg(Connection db, String blogginlaggsID) {
        boolean informelltInlagg = false;
        try {
            String sql = "SELECT * FROM InformellBlogg where InlaggsID = " + blogginlaggsID;
            Statement statement = db.createStatement();
            ResultSet resultat = statement.executeQuery(sql);

            while (resultat.next()) {
                informelltInlagg = true;
            }
        } catch (SQLException e) {
        }
        return informelltInlagg;
    }

    public static ArrayList<ArrayList<String>> lasFormellaBlogginlagg(Connection db) throws SQLException {
        ArrayList<ArrayList<String>> retur = new ArrayList<ArrayList<String>>();

        String sql = "SELECT * FROM Blogginlagg join formellBlogg on bloggInlaggsID = inlaggsID Order By datumtid desc";

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
            arr.add(hamtaDenSomSkrivit(db, String.valueOf(resultat.getInt("SkapatAv"))));

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

        String sql = "SELECT * FROM Blogginlagg join informellBlogg on bloggInlaggsID = inlaggsID Order By datumtid desc";

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
            arr.add(hamtaDenSomSkrivit(db, String.valueOf(resultat.getInt("SkapatAv"))));

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
            JOptionPane.showMessageDialog(null, "Fel l�senord eller anv�ndarnamn");
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

            if (filURL == null || filURL.isEmpty()) {
                sql = "UPDATE BloggInlagg SET Rubrik = '" + rubrik + "', Text = '" + text + "' WHERE BloggInlaggsID = " + bloggInlaggsID;
            } else {
                sql = "UPDATE BloggInlagg SET Rubrik = '" + rubrik + "', Text = '" + text + "', FilURL = '" + filURL + "' WHERE BloggInlaggsID = " + bloggInlaggsID;
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
        String sql3 = "DELETE FROM HarGillat WHERE BloggInlaggsID = " + bloggInlaggsID;
        PreparedStatement taBortStatement3 = db.prepareStatement(sql3);
        taBortStatement3.executeUpdate();

        String sql4 = "DELETE FROM BloggInlagg WHERE BloggInlaggsID = " + bloggInlaggsID;
        PreparedStatement taBortStatement4 = db.prepareStatement(sql4);
        taBortStatement4.executeUpdate();

    }

    public static void raderaProjektInlagg(Connection db, int projektInlaggsID) throws NoSuchAlgorithmException, SQLException {
        String sql = "DELETE FROM Utvecklingsarbetsinlagg WHERE InlaggsID = " + projektInlaggsID;
        PreparedStatement taBortStatement = db.prepareStatement(sql);
        taBortStatement.executeUpdate();
    }

    private static String getTid() {
        SimpleDateFormat datumformaterare = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp klockslag = new Timestamp(System.currentTimeMillis());
        String datumTid = datumformaterare.format(klockslag);

        return datumTid;
    }

    public static void laggaTillProjektInlagg(Connection db, String rubrik, String text, String filURL, int skrivenAv, int tillhorArbete) throws NoSuchAlgorithmException, SQLException {
        String sql = "INSERT INTO Utvecklingsarbetsinlagg (InlaggsID, Rubrik, Text, FilURL, skrivenAv, Tillh�rArbete) VALUES (?,?,?,?,?,?)";

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

    public static String getProjektNamn(Connection db, int projektGruppID) throws NoSuchAlgorithmException, SQLException {
        String sql = "SELECT namn FROM Utvecklingsarbete WHERE utvecklingsarbetsID = " + projektGruppID;
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

    public static ArrayList<ArrayList<String>> sorteraEfterLikes(Connection db) throws SQLException {
        ArrayList<ArrayList<String>> retur = new ArrayList<ArrayList<String>>();

        String sql = "SELECT *, Count(*) as antalLikes FROM Blogginlagg join informellBlogg on blogginlagg.bloggInlaggsID = inlaggsID LEFT join HarGillat on Blogginlagg.bloggInlaggsID = Hargillat.blogginlaggsID Group by harGillat.BlogginlaggsID Order By antalLikes desc";

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
            arr.add(hamtaDenSomSkrivit(db, String.valueOf(resultat.getInt("SkapatAv"))));

            retur.add(arr);

        }

        for (ArrayList<String> inlagg : retur) {
            String rubrik = inlagg.get(0);
            String text = inlagg.get(1);
            String filURL = inlagg.get(2);
            String datum = inlagg.get(3);
            String skapatAv = inlagg.get(4);
            String bloggInlaggID = inlagg.get(5);
        }

        return retur;
    }

    public static String getUtvecklingFilURL(Connection db, int inlaggsID) {
        String filURL = "";

        try {
            String sql = "SELECT filURL from Utvecklingsarbetsinlagg where InlaggsID = " + inlaggsID;
            Statement statement = db.createStatement();
            ResultSet resultat = statement.executeQuery(sql);
            filURL = resultat.getString("filURL");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return filURL;
    }

    public static String getBloggFilURL(Connection db, int inlaggsID) {
        String filURL = "";

        try {
            String sql = "SELECT filURL from Blogginlagg where BlogginlaggsID = " + inlaggsID;
            Statement statement = db.createStatement();
            ResultSet resultat = statement.executeQuery(sql);
            filURL = resultat.getString("filURL");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return filURL;
    }

    public static boolean bytLosenord(Connection db, String epost, String gammaltLosenord, String nyttLosenord) throws NoSuchAlgorithmException, SQLException {
        
        boolean byttLosenord = false;
        
        if (loggaInCheck(db, epost, gammaltLosenord)) {

            byttLosenord = true;
            
            String sql = "SELECT AnvandarID FROM Anvandare WHERE Epost ='" + epost + "'";
            Statement statement = db.createStatement();
            ResultSet resultat = statement.executeQuery(sql);
            int anvandarID = resultat.getInt("AnvandarID");

            if (anvandarID > 0) {
                String krypteratLosen = Kryptering.skapaHashLosenord(nyttLosenord);

                String sql1 = "UPDATE Anvandare SET Losenord = '" + krypteratLosen + "' WHERE AnvandarID = " + anvandarID;
                PreparedStatement uppdateraStatement = db.prepareStatement(sql1);
                uppdateraStatement.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "Fel l�senord eller anv�ndarnamn");
            }

        }
        
        return byttLosenord;
    }
    
    public static ArrayList<ArrayList<String>> sqlKalender(Connection db, String datum, int id) throws NoSuchAlgorithmException, SQLException {
        ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();
        String sql = "SELECT namn, beskrivning, anvandare.fornamn, starttid, sluttid FROM mote INNER JOIN anvandare ON skapare=anvandare.AnvandarID INNER JOIN motesdeltagare ON mote.motesID=motesdeltagare.motesID WHERE datum ='"+datum+"' AND motesdeltagare.AnvandarID="+id;
        Statement statement = db.createStatement();
        ResultSet resultat = statement.executeQuery(sql);

        while (resultat.next()) {
            ArrayList<String> aLista = new ArrayList<String>();
            aLista.add(resultat.getString("namn"));
            aLista.add(resultat.getString("beskrivning"));
            aLista.add(resultat.getString("fornamn"));
            aLista.add(resultat.getString("starttid"));
            aLista.add(resultat.getString("sluttid"));
            aLista.add("----------------------------------------------------------");

            lista.add(aLista);
        }

        for (ArrayList<String> moten : lista) {
            String namn = moten.get(0);
            String beskrivning = moten.get(1);
            String fornamn = moten.get(2);
            String starttid = moten.get(3);
            String sluttid = moten.get(4);
            String streck = moten.get(5);
        }

        return lista;
    }

    public static ArrayList<ArrayList<String>> getPublicMeetings(Connection db, String dagensDatum) throws NoSuchAlgorithmException, SQLException {
        
        ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();
        String sql = "SELECT namn, beskrivning, anvandare.fornamn, starttid, sluttid, datum FROM mote Join anvandare ON mote.skapare = anvandare.anvandarID WHERE datum >='" + dagensDatum + "' AND mote.namn LIKE 'PUBLIKT M�TE:%' ORDER BY datum ASC ";

        Statement statement = db.createStatement();
        ResultSet resultat = statement.executeQuery(sql);

        while (resultat.next()) {
            ArrayList<String> aLista = new ArrayList<String>();
            aLista.add(resultat.getString("namn"));
            aLista.add(resultat.getString("beskrivning"));
            aLista.add(resultat.getString("fornamn"));
            aLista.add(resultat.getString("starttid"));
            aLista.add(resultat.getString("sluttid"));
            aLista.add(resultat.getString("datum"));
            aLista.add("-----------------------------------------------------");

            lista.add(aLista);
        }

        for (ArrayList<String> moten : lista) {
            String namn = moten.get(0);
            String beskrivning = moten.get(1);
            String fornamn = moten.get(2);
            String starttid = moten.get(3);
            String sluttid = moten.get(4);
            String datum = moten.get(5);
            String streck = moten.get(6);

        }
        return lista;
    }
    
    public static ArrayList<ArrayList<String>> getPrivateMeetings(Connection db, String dagensDatum, int id) /*throws NoSuchAlgorithmException, SQLException*/ {
        ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();
        try{
        
        String sql = "SELECT namn, beskrivning, anvandare.fornamn, starttid, sluttid, datum FROM mote INNER JOIN anvandare ON mote.skapare=anvandare.AnvandarID INNER JOIN motesdeltagare ON mote.motesID=motesdeltagare.motesID WHERE datum >='" + dagensDatum + "' AND mote.namn NOT LIKE 'PUBLIKT M�TE:%' AND motesdeltagare.AnvandarID = " + id + " ORDER BY datum ASC ";
        
        Statement statement = db.createStatement();
        ResultSet resultat = statement.executeQuery(sql);

        while (resultat.next()) {
            ArrayList<String> aLista = new ArrayList<String>();
            aLista.add(resultat.getString("namn"));
            aLista.add(resultat.getString("beskrivning"));
            aLista.add(resultat.getString("fornamn"));
            aLista.add(resultat.getString("starttid"));
            aLista.add(resultat.getString("sluttid"));
            aLista.add(resultat.getString("datum"));
            aLista.add("-----------------------------------------------------");

            lista.add(aLista);
        }

        for (ArrayList<String> moten : lista) {
            String namn = moten.get(0);
            String beskrivning = moten.get(1);
            String fornamn = moten.get(2);
            String starttid = moten.get(3);
            String sluttid = moten.get(4);
            String datum = moten.get(5);
            String streck = moten.get(6);

        }
        }catch(SQLException e){}
       
        return lista;
    }

}
