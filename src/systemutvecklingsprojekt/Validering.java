/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemutvecklingsprojekt;

import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;


/**
 *
 * @author MarcusSkarud
 */
// Valideringsklassen vi har anv�nt oss av f�r att utf�ra valideringar f�r flera funktioner i systemet.
public class Validering {
    
    //Kollar om textf�ltet �r tomt.
    static public boolean textIsEmpty(JTextField txt){
        if (txt.getText().isEmpty()){
            //JOptionPane.showMessageDialog(null, "Textf�ltet �r tomt!");
            txt.requestFocus();
            return true;
        }
        else {
            return false;
        }
    }
    
    //Kollar om inmatningen i textf�lt best�r av integers.
    static public boolean textIsIntegers(JTextField txt){
        try{
            Integer.parseInt(txt.getText());
            return true;
        }
        catch(NumberFormatException undantag){
            JOptionPane.showMessageDialog(null, "V�rdet m�ste best� av endast heltal!");
            txt.requestFocus();
            return false;
        }
    }
    
    // Kollar s� inte l�senordsf�ltet �r tomt.
    static public boolean passwordIsEmpty(JPasswordField txt){
        if (new String(txt.getPassword()).isEmpty()){
            //JOptionPane.showMessageDialog(null, "L�senordsf�ltet �r tomt!");
            txt.requestFocus();
            return true;
        }
        else {
            return false;
        }
    }
    
    // Kollar om de nya l�senorden matchar varandra.
    static public boolean newPasswordMatch(JPasswordField txt1, JPasswordField txt2){
        if (new String(txt1.getPassword()).equals(new String(txt2.getPassword()))){
            return true;
        }
        else{
            txt1.requestFocus();
            JOptionPane.showMessageDialog(null, "De nya l�senorden matchar inte!");
            return false;
        }
    }
    
    // Kollar formatet p� ett textf�lt f�r att se om det �verensst�mmer med ett datum.
    static public boolean checkDatumFormat(JTextField datumField){
        String[] datum = datumField.getText().toString().split("-");
        boolean allNumbers = true;
        for (String datumet : datum){
            try{
                System.out.println(datumet);
                int testInt = Integer.parseInt(datumet);
            }
            catch( NumberFormatException undantag){
                allNumbers = false;
                System.out.println("Inte nummer");
            }
        }
        if (allNumbers && datum.length == 3 && datum[0].length() == 4 && datum[1].length() == 2 && datum[2].length() == 2){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Datumformatet ska vara numeriskt, enligt detta format '���-MM-DD'.");
            datumField.requestFocus();
            return false;
        }
    }
    
    // Kollar l�ngden p� inmatat telefonnummer s� det inte �verstiger 30 tecken.
    static public boolean checkPhoneLength(JTextField txt){
        if (txt.getText().toString().length() <= 30){
            return false;
        }
        else{
            //JOptionPane.showMessageDialog(null, "Telefonnumret �r f�r l�ngt!");
            return true;
        }
    }
    
    // Kollar s� l�ngden p� inmatat l�senord ej �r f�r l�ngt.
    static public boolean passwordTextFieldLengthCheck(JTextField txt){
        if (new String(txt.getText()).length() <= 6){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "L�senordet �r f�r l�ngt! Max 6 tecken.");
            txt.requestFocus();
            return false;
        }
    }
    
    //Kollar s� l�ngden p� inmatat namn ej �r f�r l�ngt.
    static public boolean nameTextFieldLengthCheck(JTextField txt){
        if (new String(txt.getText()).length() <= 20){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Namnet �r f�r l�ngt! Max 20 tecken.");
            txt.requestFocus();
            return false;
        }
    }
    //Kollar om JComboBoxen �r tom.
    static public boolean JComboBoxNotEmpty(JComboBox box){
        if (box.getSelectedItem().toString().equals("---")){
            JOptionPane.showMessageDialog(null, "Inget valt i listan!");
            box.requestFocus();
            return false;
        }
        else{
        return true;
        }
    }
    
    //Kollar om n�gon valts i komboboxen samt att det finns ett v�rde i en vald JTextField.
    public static boolean iDIfyllt(JTextField txt, JComboBox box){
        System.out.println(txt.getText());
        if (txt.getText().isEmpty() || box.getSelectedItem().toString().equals("---")){
            JOptionPane.showMessageDialog(null, "Inget valt i listan!");
            box.requestFocus();
            return false;
        }
        else{
            return true;
        }
    }
    
    // Kollar om l�ngden p� l�senordet �r h�gst 6 tecken.
    static public boolean passwordLengthCheck(JPasswordField txt){
        if (new String(txt.getPassword()).length() <= 6){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "L�senordet �r f�r l�ngt! Max 6 tecken.");
            txt.requestFocus();
            return false;
        }
    }
    
}