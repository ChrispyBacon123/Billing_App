/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CrispyBacon
 */
import java.io.*;
import java.util.*;

public class Client {
    private String name;
    private String email;
    private String phone;
    private String invoiceNo;
    
    public Client(String name, String email, String phone, String invoice){
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.invoiceNo=invoice;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    public String getInvoiceNo(){
        return invoiceNo;
    }
    public void incrementInvoiceNo(){
        int invoice=Integer.parseInt(invoiceNo);
        invoice = invoice +1;
        invoiceNo = ""+invoice;
        Client c = new Client(name, email,phone,invoiceNo);
        GenerateDocs.createClientDetails(c);
        PythonExecuter.ExecutePython("UpdateClient");
    }
    public static ArrayList<Client> generateClientList(){
        ArrayList<Client> clients = new ArrayList<Client>();
        try{
            Scanner scFile = new Scanner(new File("/Users/CrispyBacon/Desktop/Mumsle App/Client List.txt"));
            String name = "";
            String email = "";
            String phone = "";
            String invoice = "";
            
            while(scFile.hasNext()){
                Scanner scLine = new Scanner(scFile.nextLine()).useDelimiter("#");
                name = scLine.next();
                email = scLine.next();
                phone = scLine.next();
                invoice =scLine.next();
                clients.add(new Client(name,email,phone,invoice));
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        return clients;
    }
    
    
}
