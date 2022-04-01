/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Ibrahima (Ibah)
 */
public class customerMainController implements Initializable{
    
    private Controller c = new Controller();
    
    private Main sceneChange = new Main();
    private ArrayList<Book> books = new ArrayList<>();
    private bookFile bookShelf = new bookFile();
    private final ObservableList<Book> data = FXCollections.observableArrayList();
    
    @FXML
    private Label currentUser;
    @FXML
    private Label currentPoints;
    @FXML
    private Label currentStatus;
    
    @FXML
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> bookName;
    @FXML
    private TableColumn<Book, Integer> bookPrice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //currentUser.setText("User: " + c.user.getName());
            //currentPoints.setText("Points: " + c.getCustomer().getPoints());
            //currentStatus.setText("Status: " + c.getCustomer().getStatus(c.getCustomer().getPoints()));
            
            bookShelf.initBooks();
            books = bookShelf.bookFileRead();
            data.addAll(books);
            
            bookName.setCellValueFactory(new PropertyValueFactory<>("name"));
            bookPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            bookTable.setItems(data);
            
        } catch (IOException e) {}
    }
    
    public void logout(ActionEvent event) throws IOException{
        sceneChange.changeScene("login.fxml");
    }
    
}
