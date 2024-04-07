/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CrispyBacon
 */
public class Help {
    private String message;
    private String label;

    /**
     * This is the constructor used to make a Help Object
     * @param mess message to be conveyed to the user 
     * @param lbl name of the component
     */
    public Help(String mess, String lbl){
        message=mess;
        label=lbl;
    }

    /**
     * This method returns the message property of the object
     * @return the message property of the object
     */
    public String getMessage(){return message;}

    /**
     * This method returns the label property of the object
     * @return the label property of the object
     */
    public String getLabel(){return label;}
    }
