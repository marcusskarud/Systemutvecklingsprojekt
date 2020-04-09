/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemutvecklingsprojekt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Kryptering {
    
    // Denna metod tar en vanlig textsträng som parameter (lösenordet) och 
    // genererar en SHA256-hash. 
    // - Vid "ändring av lösenord" sparar man resultatet från denna metod i databasen.
    // - Vid "inloggning" hämtar man lösenordet i databasen och jämför med resultatet av denna metod.
    // För att köra metoden skriv: Kryptering.skapaHashLosenord(<<din textsträng>>)
    static public String skapaHashLosenord(String losenord) throws NoSuchAlgorithmException{

        String hashlosenord = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = messageDigest.digest(losenord.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashlosenord = stringBuilder.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            System.out.println(e.getMessage());
        }
        return hashlosenord;
    }  
}
