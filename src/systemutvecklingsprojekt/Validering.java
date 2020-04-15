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
// Valideringsklassen vi har använt oss av för att utföra valideringar för flera funktioner i systemet.
public class Validering {
    
    //Kollar om textfältet är tomt.
    static public boolean textIsEmpty(JTextField txt){
        if (txt.getText().isEmpty()){
            //JOptionPane.showMessageDialog(null, "Textfältet är tomt!");
            txt.requestFocus();
            return true;
        }
        else {
            return false;
        }
    }
    
    //Kollar om inmatningen i textfält består av integers.
    static public boolean textIsIntegers(JTextField txt){
        try{
            Integer.parseInt(txt.getText());
            return true;
        }
        catch(NumberFormatException undantag){
            JOptionPane.showMessageDialog(null, "Värdet måste bestå av endast heltal!");
            txt.requestFocus();
            return false;
        }
    }
    
    // Kollar så inte lösenordsfältet är tomt.
    static public boolean passwordIsEmpty(JPasswordField txt){
        if (new String(txt.getPassword()).isEmpty()){
            //JOptionPane.showMessageDialog(null, "Lösenordsfältet är tomt!");
            txt.requestFocus();
            return true;
        }
        else {
            return false;
        }
    }
    
    // Kollar om de nya lösenorden matchar varandra.
    static public boolean newPasswordMatch(JPasswordField txt1, JPasswordField txt2){
        if (new String(txt1.getPassword()).equals(new String(txt2.getPassword()))){
            return true;
        }
        else{
            txt1.requestFocus();
            JOptionPane.showMessageDialog(null, "De nya lösenorden matchar inte!");
            return false;
        }
    }
    
    // Kollar formatet på ett textfält för att se om det överensstämmer med ett datum.
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
            JOptionPane.showMessageDialog(null, "Datumformatet ska vara numeriskt, enligt detta format 'ÅÅÅ-MM-DD'.");
            datumField.requestFocus();
            return false;
        }
    }
    
    // Kollar längden på inmatat telefonnummer så det inte överstiger 30 tecken.
    static public boolean checkPhoneLength(JTextField txt){
        if (txt.getText().toString().length() <= 30){
            return false;
        }
        else{
            //JOptionPane.showMessageDialog(null, "Telefonnumret är för långt!");
            return true;
        }
    }
    
    // Kollar så längden på inmatat lösenord ej är för långt.
    static public boolean passwordTextFieldLengthCheck(JTextField txt){
        if (new String(txt.getText()).length() <= 6){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Lösenordet är för långt! Max 6 tecken.");
            txt.requestFocus();
            return false;
        }
    }
    
    //Kollar så längden på inmatat namn ej är för långt.
    static public boolean nameTextFieldLengthCheck(JTextField txt){
        if (new String(txt.getText()).length() <= 20){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Namnet är för långt! Max 20 tecken.");
            txt.requestFocus();
            return false;
        }
    }
    //Kollar om JComboBoxen är tom.
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
    
    //Kollar om någon valts i komboboxen samt att det finns ett värde i en vald JTextField.
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
    
    // Kollar om längden på lösenordet är högst 6 tecken.
    static public boolean passwordLengthCheck(JPasswordField txt){
        if (new String(txt.getPassword()).length() <= 6){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Lösenordet är för långt! Max 6 tecken.");
            txt.requestFocus();
            return false;
        }
    }
    
}