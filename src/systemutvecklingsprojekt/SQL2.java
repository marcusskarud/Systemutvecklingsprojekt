package systemutvecklingsprojekt;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
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

    public static void laggaTillBloggInlägg(Connection db, String rubrik, String text, String filURL, int skapatAv) throws NoSuchAlgorithmException, SQLException {
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

    }

    public static void redigeraBloggInlagg(Connection db, int bloggInlaggsID, String rubrik, String text, String filURL, int skapatAv) throws NoSuchAlgorithmException, SQLException {
        String sql;
        if (filURL == null) {
            sql = "UPDATE BloggInlagg SET Rubrik = '" + rubrik + "', Text = '" + text + "' WHERE BloggInlaggsID = " + bloggInlaggsID;
            System.out.println("filURL är null!");
        } else {
            sql = "UPDATE BloggInlagg SET Rubrik = '" + rubrik + "', Text = '" + text + "', FilURL = '" + filURL + "' WHERE BloggInlaggsID = " + bloggInlaggsID;
        }
        PreparedStatement uppdateraStatement = db.prepareStatement(sql);
        uppdateraStatement.executeUpdate();
    }

    public static void raderaBloggInlagg(Connection db, int bloggInlaggsID) throws NoSuchAlgorithmException, SQLException {
        String sql = "DELETE FROM BloggInlagg WHERE BloggInlaggsID = " + bloggInlaggsID;
        PreparedStatement taBortStatement = db.prepareStatement(sql);
        taBortStatement.executeUpdate();
    }

    private static String getTid() {
        SimpleDateFormat datumformaterare = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp klockslag = new Timestamp(System.currentTimeMillis());
        String datumTid = datumformaterare.format(klockslag);

        return datumTid;
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
        String sql = "SELECT namn, beskrivning, anvandare.fornamn, starttid, sluttid, datum FROM mote Join anvandare ON mote.skapare = anvandare.anvandarID WHERE datum >='" + dagensDatum + "' AND mote.namn LIKE 'PUBLIKT MÖTE:%' ORDER BY datum ASC ";

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
    
    public static ArrayList<ArrayList<String>> getPrivateMeetings(Connection db, String dagensDatum) throws NoSuchAlgorithmException, SQLException {
        
        ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();
        String sql = "SELECT namn, beskrivning, anvandare.fornamn, starttid, sluttid, datum FROM mote Join anvandare ON mote.skapare = anvandare.anvandarID WHERE datum >='" + dagensDatum + "' AND mote.namn NOT LIKE 'PUBLIKT MÖTE:%' ORDER BY datum ASC ";

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

}
