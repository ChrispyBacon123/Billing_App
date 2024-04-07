/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CrispyBacon
 */
import java.time.*;
import java.time.format.DateTimeFormatter;
public class DataValidation {
    /**
     * This method is used to create a DataValidation object
     */
    public DataValidation(){} 
    
    


    /**
     * This method checks to see if the data entered consists of any spaces 
     * This is done to avoid SQL injection attacks as well as ensure that the email address is valid
     * @param data a string which will be the data entered by the user
     * @return The text that the error label must display
     */
    public static String checkNoSpace(String data){
        boolean spaceCheck=true;
             for (int i = 0; i < data.length()-1; i++) {
            if (Character.isWhitespace(data.charAt(i))) {
                spaceCheck =false;
                i=data.length();
            }          
        }
             if (spaceCheck) {
            return "";
        }
             else  {
                 return "Make sure that no spaces are present";
             }
    }
    /**
     * This method validates the data that the user enters into a text field 
     * where the data is meant to be an email address
     * @param email a string which be the data entered by the user
     * @return The text that the error label must display
     */
    public static String validateEmail(String email){
    boolean emailCheck=false;
    String out="";
    
    //Checking to ensure that the email has an @
    for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i)!='@') {
                emailCheck=false;
            }
            else{
                emailCheck=true;
                i=email.length();
            }
        }
        if (emailCheck==false) {
            out= "Make sure an @ is present"; //Displaying error message

        }
        return out;
}   

    /**
     * This method validates the data that the user enters into a text field 
     * where the data is meant to be a first name or a surname
     * @param name a string which be the data entered by the user
     * @return The text that the error label must display
     */
    public static String validateName(String name){
        boolean nameCheck=true;
        int count=0;
        char check;
        String out="";
        
        //Presence check
        if (name.isEmpty()) {
            out="Please enter your name";
            nameCheck=false;
        }
        
        while(nameCheck==true&&count<name.length()){ //Format Check
            check=name.charAt(count);
            if (!Character.isLetter(check)) {
                nameCheck=false;
                out="Make sure your name consists of only letters";
            }
            count++;
        }
       
       return out;
        
    }

    /**
     * This method validates the data that the user enters into a text field 
     * where the data is meant to be both a first name and a surname
     * @param fullName a string which be the data entered by the user
     * @return The text that the error label must display
     */
    public String validateFullName(String fullName){
        
        String out="";
        char check;
        boolean nameCheck = false;
        int space,count=0;
        
        //Presence checck
        if (fullName.isEmpty()) {
            out="Enter your name and surname";
            nameCheck=false;
        }
        
        //Ensuring that both a first name and surname have been entered
         for (int i = 0; i < fullName.length(); i++) { //Format Check
            check=fullName.charAt(i);
            if (Character.isWhitespace(check)) {
                nameCheck=true;
                space = i;
            }
        }
        if (nameCheck==false) {
            out="Enter your name AND surname with a space in between"; //Displaying error message
        }
        
        //Ensuring that only letters are in the name 
        while(nameCheck==true&&count<fullName.length()){ //Fromat Check
            check=fullName.charAt(count);
            if (!Character.isLetter(check)&&!Character.isWhitespace(check)) {
                nameCheck=false;
            }
            count++;
        }        
        if (nameCheck==false) {
            out="Make sure your name consists of only letters and the space"; //Displaying error message
        }
        return out;
    }

  
 
    public static String validatePhone(String number){
        if (number.isBlank()||number.isEmpty()) {
            return "Please enter a phone number";
        } 
        if (number.length()<12){
            return "Please enter a number that is long enough";
        }
        if (Character.isWhitespace(number.charAt(3))&&Character.isWhitespace(number.charAt(7))){
            return "";
        }
        else{
            return "Please enter the phone number in the same format as 082 829 5804";
        }
    }
    
    public static String validateAmount(String amount){

        if (amount.isBlank()||amount.isEmpty()){
            return "Please enter an amount";
        }
        try{
            int rands = Integer.parseInt(amount);
        }
        catch(NumberFormatException e){
            return "Please enter the amount in numeric form";
        }
        return "";
        
    }
    
    public static String validateDate(String date){
        if (date.isBlank()||date.isEmpty()) 
        {
            return "Please enter a date";
        } 
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        if(parsedDate.isAfter(currentDate)){
            return "Please do not enter a date in the future";
        }
        else {
            return "";
        }
    }
}