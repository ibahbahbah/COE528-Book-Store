package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Ibrahima (Ibah)
 */
public class ownerBooksController implements Initializable{
    
    Main sceneChange = new Main();
    private ArrayList<Book> books = new ArrayList<>();
    private bookFile bookShelf = new bookFile();
    private ObservableList<Book> data = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> bookName;
    @FXML
    private TableColumn<Book, Integer> bookPrice;
    
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private Label wrongBookPrice;
   
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        // Books File is created (unless already made)
        try {
            bookShelf.initBooks();
            books = bookShelf.bookFileRead();
            data.addAll(books);
            
            bookName.setCellValueFactory(new PropertyValueFactory<>("name"));
            bookPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            bookTable.setItems(data);
        } catch (IOException e) {}
        
    }
    
    public void back(ActionEvent event) throws IOException {
        
        bookShelf.refreshBook();
        bookShelf.bookFileWrite(books);
        
        sceneChange.changeScene("ownerMain.fxml");
    }
    
    public void deleteBook(ActionEvent event) {
        // Problem:  Item was being removed from bookTable but not from books-array
        // Cause:    I used the same variable for selection thinking there would
        //           be no issue as it can return the name and price of the 
        //           selected item used in both instances. In reality the value 
        //           returned, despite having identical data, was different
        //           so the value given corresponded with the Item for bookTable
        //           but not for books-array
        // Solution: Remove the Item from bookTable then find the equivalent
        //           item in the array, overwritting the selection.
        
        Book selection = bookTable.getSelectionModel().getSelectedItem();
        bookTable.getItems().remove(selection);
        
        for (Book b: books) {
            if(selection.getName().equals(b.getName()) && selection.getPrice() == b.getPrice()){
                selection = b;
            }
        }
        
        books.remove(selection);
        
    }
    
    private boolean isNum(String msg){
        // Check if Input is Numerical (used for Price)
        try {
            Double.parseDouble(msg);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Book NOT added");
            return false;
        }
    }
    
    public void addBook() throws IOException{
        //Retrive inputs from Name and Price then create new Book obj
        //Add Book Obj to Books-Array
        
        String tmpBookName = nameField.getText();
        double tmpBookPrice = Double.parseDouble(priceField.getText());
        boolean priceValid = isNum(priceField.getText());
        
        if (priceValid == true && tmpBookPrice >= 0) {
            Book book = new Book(tmpBookName, tmpBookPrice); // Create book obj
            books.add(book);                                 // Add obj to ArrayList
            data.add(book);                                  // Add to Table view
            System.out.println("Book added");
        } else if (tmpBookPrice < 0){
            wrongBookPrice.setVisible(true);
        }
        
    }
        
}
