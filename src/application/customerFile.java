package application;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Ibrahima (Ibah)
 */
public class customerFile {
    
    // Initialize books.txt (create new file if needed)
    public void initCustomer() throws IOException{
        File myObj = new File("customers.txt");
        
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }
    }
    
    // Writes Customer-Object-Array to Customer-Text
    public void customerFileWrite(ArrayList<Customer> customers) throws IOException{
        FileWriter fw = new FileWriter("customers.txt", true);
        for (Customer c : customers) {
            String data = c.getName() + ", " + c.getPassword() + ", " + c.getPoints() + "\n";
            fw.write(data);
        }
        fw.close();
    }
    
    public void refreshCustomers() throws IOException{
        FileWriter fw1 = new FileWriter("customers.txt", false);
        fw1.close();
    }
    
    // Reads and translates Customer-Text to new Customer-Object-Array
    public ArrayList<Customer> customerFileRead() throws IOException{
        FileReader fr = new FileReader("customers.txt");
        Scanner scan = new Scanner(fr);
        ArrayList<Customer> arr = new ArrayList<>();
        
        while(scan.hasNext()){
            String[] data = scan.nextLine().split(", ");
            String name = data[0];
            String password = data[1];
            arr.add(new Customer(name, password));
            
        }
        
        return arr;
    }
    
}
