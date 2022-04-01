package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


/**
 *
 * @author Ibrahima (Ibah)
 */
public class Controller implements Initializable{
    
    Main sceneChange = new Main();
    private ArrayList<Customer> customers = new ArrayList<>();
    private customerFile list = new customerFile();
    protected Customer user;
    
    //Login
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Label wrongLogin;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            customers = list.customerFileRead();
        } catch (IOException e) {}
    }
    
    public void login(ActionEvent event) throws IOException{
        checkLogin();
    }
    
    private void checkLogin() throws IOException{
        
        if (usernameField.getText().equals("admin") && passwordField.getText().equals("admin")) {
            sceneChange.changeScene("ownerMain.fxml");
        }
        for (Customer c : customers){
            if (usernameField.getText().equals(c.getName()) && passwordField.getText().equals(c.getPassword()) ) {
                user = c;
                sceneChange.changeScene("customerMain.fxml");
            }
        }
        //System.out.println(passwordField.getText() + " " + customers.get(0).getPassword());
    }
    
    public void ownerBooks(ActionEvent event) throws IOException{
        sceneChange.changeScene("ownerBooks.fxml");
    }
    
    public void ownerCustomer(ActionEvent event) throws IOException{
        sceneChange.changeScene("ownerCustomer.fxml");
    }
    
    public void logout(ActionEvent event) throws IOException{
        sceneChange.changeScene("login.fxml");
    }
    
    public void back(ActionEvent event) throws IOException{
        sceneChange.changeScene("ownerMain.fxml");
    }

    
    
}
