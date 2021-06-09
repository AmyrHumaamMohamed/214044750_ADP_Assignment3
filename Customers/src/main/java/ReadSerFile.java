
/**
 * Humaam Mohamed
 *21444750
 * Assignment3
 * @author AmyrH
 */

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class ReadSerFile {

FileWriter fwriter;
ObjectInputStream read;
BufferedWriter bwriter;

ArrayList<Supplier> supply= new ArrayList<Supplier>();

ArrayList<Customers> Custom= new ArrayList<Customers>();




//Question 2A

 public void OpenFile(){
 try {read = new ObjectInputStream( new FileInputStream( "stakeholder.ser" ) );
 System.out.println("Ser file created!");               
}
 catch (IOException ioe){
 System.out.println("error opening Ser file: " + ioe.getMessage());
 System.exit(1);
}}

    
    
public void readFile(){
try{
while(true){
Object object = read.readObject();
String custom ="Customers";
String sup = "Supplier";
String name = object.getClass().getSimpleName();
     
if ( name.equals(custom)){
Custom.add((Customers)object);
} 
else if ( name.equals(sup)){
supply.add((Supplier)object);
} 
else {
System.out.println("failed");
}}}
 
catch (EOFException eofe) {
System.out.println("End");}

catch (ClassNotFoundException ioe) {
System.out.println("Class not found: "+ ioe);}

catch (IOException ioe) {
System.out.println("Failed to read file: "+ ioe);}
        
sortCustomers();
getDateOfBirth();
//LocalDate();       
}
       
 public void readCloseFile(){
 try{ read.close( );} 
 catch (IOException ioe){            
 System.out.println("error closing file: " + ioe.getMessage());
 System.exit(1);
}}

    
    
    
//Question 2B
    public void sortCustomers(){
    String[] sortstkID = new String[Custom.size()];
    
    ArrayList<Customers> sortNewArray= new ArrayList<Customers>();
    
    int count = Custom.size();
    for (int u = 0; u < count; u++)
    {
    sortstkID[u] = Custom.get(u).getStHolderId();}

    Arrays.sort(sortstkID);     
    for (int u = 0; u < count; u++) 
    {
    for (int h = 0; h < count; h++) 
    {
    if (sortstkID[u].equals(Custom.get(h).getStHolderId())){
            sortNewArray.add(Custom.get(h));
    }}}
 Custom = sortNewArray;
}
   
    
    
//Question 2C   
    
    
    
    
    
    
//Question 2D  
public static void getDateOfBirth(){
  
String pattern = "dd-MM-yyyy";
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
String date = formatter.format(new Date());
System.out.println("Date Format with dd/MM/yyyy : "+ date);
 }





  
//Question 2E

    public void displayCustomersText(){
    try{ fwriter = new FileWriter("CustomersFile.txt");
            
    bwriter = new BufferedWriter(fwriter);
    bwriter.write(String.format(" %-15s\n", "======================================CUSTOMER======================================="));
    bwriter.write(String.format("%-15s %-15s %-15s %-15s %-15s\n", "ID","Name","Surname","Date of Birth","Age"));
    bwriter.write(String.format(" %-15s\n", "-------------------------------------------------------------------------------------"));
    for (int i = 0; i < Custom.size(); i++) {
    bwriter.write(String.format("%-15s %-15s %-15s %-15s \n", Custom.get(i).getStHolderId(), Custom.get(i).getFirstName(), Custom.get(i).getSurName(),Custom.get(i).getDateOfBirth()));
}}
  catch(IOException fnfe )           
{
   System.out.println(fnfe);
   System.exit(1);
}
  
  try{
  bwriter.close( );} 
  catch (IOException ioe){            
  System.out.println("error closing text file: " + ioe.getMessage());
  System.exit(1);
}}

    
//Question 2F
    
    
    
    
    
    
    
    
    
    
//Question 3A
  
    public void displaySupplierText(){
    try{
    FileWriter fwriter = new FileWriter("SupplierFile.txt");
   
    bwriter = new BufferedWriter(fwriter);
    bwriter.write(String.format(" %-15s\n", "======================================SUPPLIERS======================================="));         
    bwriter.write(String.format("%-15s %-15s %-15s %-15s\n", "ID","Name","Product Type","Product Description"));
    bwriter.write(String.format(" %-15s\n", "--------------------------------------------------------------------------------------"));     
    for (int i = 0; i < supply.size(); i++) {
    bwriter.write(String.format("%-15s %-15s %-15s %-15s \n", supply.get(i).getStHolderId(), supply.get(i).getName(), supply.get(i).getProductType(), supply.get(i).getProductDescription()));  
    }}
    
    catch(IOException fnfe )
    {
    System.out.println(fnfe);
    System.exit(1);
    }
    try{
    bwriter.close( ); }
     
    catch (IOException ioe){            
    System.out.println("error closing text file: " + ioe.getMessage());
    System.exit(1);
    }}

    
    
 //-----------------------------------------------------------------------------   
    
  public void sortSupplier(){
   String[] sortstkID = new String[supply.size()];
    
   ArrayList<Supplier> sortNewArray= new ArrayList<Supplier>();
    
   int count = supply.size();
   for (int u = 0; u < count; u++)
   {
   sortstkID[u] = supply.get(u).getName();}

   Arrays.sort(sortstkID);     
   for (int u = 0; u < count; u++) 
   {
   for (int h = 0; h < count; h++) 
   {
   if (sortstkID[u].equals(supply.get(h).getName())){
            sortNewArray.add(supply.get(h));
   }}}    
   supply = sortNewArray;
   }
    
    
    
    


public static void main(String args[]){
ReadSerFile obj=new ReadSerFile(); 
obj.OpenFile();
obj.readFile();
obj.readCloseFile();
obj.displayCustomersText();
obj.displaySupplierText();
obj.sortSupplier();
//obj.LocalDate();
} 
} 
    
    
