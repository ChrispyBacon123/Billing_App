/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author CrispyBacon
 */
public class GenerateDocs {


    public static void createExcelUpdate(Client client,String date, String noPeople, String duration){
        String fileName = "/Users/CrispyBacon/Desktop/Mumsle App/FileBuffer/UpdateExcel.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(client.getName()+"\n");
            writer.write(client.getPhone()+"\n");
            writer.write(client.getEmail()+"\n");
            writer.write(noPeople+"\n");
            writer.write(date+"\n");
            writer.write(duration);
        }
        catch (IOException e) {
            System.err.println("Error creating the text file: " + e.getMessage());
        }
                
    }
    
    public static void createEmail(Client c,String date){
        String fileName = "/Users/CrispyBacon/Desktop/Mumsle App/FileBuffer/Email.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write content to the file
            writer.write(c.getEmail()+"\n");
            writer.write(date);
        }
        catch (IOException e) {
            System.err.println("Error creating the text file: " + e.getMessage());
        }

    }
    public static void createClientDetails(Client client) {
        String fileName = "/Users/CrispyBacon/Desktop/Mumsle App/FileBuffer/"+client.getName()+".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write content to the file
            writer.write(client.getName()+"\n");
            writer.write(client.getEmail()+"\n");
            writer.write(client.getPhone()+"\n");
            writer.write(client.getInvoiceNo());
            
            System.out.println("Text file created successfully.");
        } catch (IOException e) {
            System.err.println("Error creating the text file: " + e.getMessage());
        }
    }
    
    public static void createInvoiceTextFile(Client client, String amount, String date){
        String name = client.getName();
        String fileName = "/Users/CrispyBacon/Desktop/Mumsle App/FileBuffer/createInvoice.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(name+"\n");
            writer.write(date+"\n");
            writer.write(client.getInvoiceNo()+"\n");
            writer.write(amount);
        }
        catch (IOException e) {
            System.err.println("Error creating the text file: " + e.getMessage());
        }
        
    }
    
    
}

