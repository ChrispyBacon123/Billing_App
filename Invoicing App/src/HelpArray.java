/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CrispyBacon
 */
import java.util.*;
import java.io.*;

public class HelpArray {
private Help[] helpArr = new Help[19];
private int count=-0;

    /**
     * This is the constructor used to create a HelpArray object
     */
    public HelpArray(){
    try{
        String mess,lbl;
        Scanner scFile = new Scanner(new File("Help.txt"));  //Reading the data from the text file
        while(scFile.hasNextLine()){
            Scanner scLine = new Scanner(scFile.nextLine()).useDelimiter("#");
            mess=scLine.next();
            lbl=scLine.next();
            helpArr[count]= new Help(mess,lbl);
            count++;
            scLine.close();
        }
        scFile.close();
        count--;
    }
    catch(FileNotFoundException e){
        System.out.println("Can not find file");
    }
}
  
    /**
     * This method finds the message corresponding to the label it is requested for
     * @param component the name of the component
     * @return The message that corresponds to the component
     */
    public String retrieveMessage(String component){
    boolean flag=false;
    String out="";
    int loop=0;
    
    //Looping through the array until the correct message has been found
    while(!flag&&loop<=count){
        if (helpArr[loop].getLabel().equalsIgnoreCase(component)) {
            flag=true; 
            out= helpArr[loop].getMessage();
        } else {
            loop++;
        }
    }
    return out;
}
    
    public String toString(){
        String out ="";
        for (int i=0;i<=count;i++){
            out = out+helpArr[i].getLabel()+" "+helpArr[i].getMessage()+"\n";
    }
        return out;
}
}