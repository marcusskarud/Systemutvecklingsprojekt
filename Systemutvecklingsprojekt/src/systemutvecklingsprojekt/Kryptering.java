/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemutvecklingsprojekt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Kryptering {
    
    // Denna metod tar en vanlig textstr�ng som parameter (l�senordet) och 
    // genererar en SHA256-hash. 
    // - Vid "�ndring av l�senord" sparar man resultatet fr�n denna metod i databasen.
    // - Vid "inloggning" h�mtar man l�senordet i databasen och j�mf�r med resultatet av denna metod.
    // F�r att k�ra metoden skriv: Kryptering.skapaHashLosenord(<<din textstr�ng>>)
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
