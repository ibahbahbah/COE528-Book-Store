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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Ibrahima (Ibah)
 */
public class ownerCustomerController implements Initializable{

    Main sceneChange = new Main();
    private ArrayList<Customer> customers = new ArrayList<>();
    private customerFile list = new customerFile();
    private ObservableList<Customer> data = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Customer> customerTable;
    @FXML
    private TableColumn<Customer, String> customerNameView;
    @FXML
    private TableColumn<Customer, String> customerPasswordView;
    @FXML
    private TableColumn<Customer, Integer> customerPointsView;
    
    @FXML
    private TextField customerName;
    @FXML
    private TextField customerPass;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            list.initCustomer();
            customers = list.customerFileRead();
            data.addAll(customers);
            
            customerNameView.setCellValueFactory(new PropertyValueFactory<>("name"));
            customerPasswordView.setCellValueFactory(new PropertyValueFactory<>("password"));
            customerPointsView.setCellValueFactory(new PropertyValueFactory<>("points"));
            customerTable.setItems(data);
        } catch (IOException e) {}
    }
    
    public void back(ActionEvent event) throws IOException{ 
        
        list.refreshCustomers();
        list.customerFileWrite(customers);
        
        sceneChange.changeScene("ownerMain.fxml"); 
    }
    
    public void deleteCustomer(ActionEvent event){
        Customer selection = customerTable.getSelectionModel().getSelectedItem();
        customerTable.getItems().remove(selection);
        
        for (Customer c : customers) {
            if (selection.getName().equals(c.getName()) && selection.getPassword().equals(c.getPassword())) 
            { selection = c; }
        }
        
        customers.remove(selection);
        
    }
    
    public void addCustomer(){
        String name = customerName.getText();
        String password = customerPass.getText();
        
        if (customerName.getText() != null && customerPass.getText() != null) {
            Customer c = new Customer(name, password);
            customers.add(c);
            data.add(c);
            System.out.println("Customer Added");
        }
        
    }
    
}
