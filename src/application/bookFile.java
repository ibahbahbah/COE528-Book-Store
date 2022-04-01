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
public class bookFile {
    
    // Initialize books.txt (create new file if needed)
    public void initBooks() throws IOException{
        File myObj = new File("books.txt");
        
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }
    }
    
    // Writes Book-Object-Array to Book-Text
    public void bookFileWrite(ArrayList<Book> books) throws IOException{
        FileWriter fw = new FileWriter("books.txt", true);
        for (Book book : books) {
            String data = book.getName() + ", " + book.getPrice() + "\n";
            fw.write(data);
        }
        fw.close();
    }
    
    public void refreshBook() throws IOException{
        FileWriter fw1 = new FileWriter("books.txt", false);
        fw1.close();
    }
    
    // Reads and translates Book-Text to new Book-Object-Array
    public ArrayList<Book> bookFileRead() throws IOException{
        FileReader fr = new FileReader("books.txt");
        Scanner scan = new Scanner(fr);
        ArrayList<Book> arr = new ArrayList<>();
        
        while(scan.hasNext()){
            String[] data = scan.nextLine().split(",");
            String name = data[0];
            double price = Double.parseDouble(data[1]);
            arr.add(new Book(name, price));
        }
        
        return arr;
    }
    
    
}
