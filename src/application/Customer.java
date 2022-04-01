/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Ibrahima (Ibah)
 */
public class Customer {
    
    private String name;
    private String password;
    private int points;
    private String status;
    
    public Customer(String username, String pass){
        name = username;
        password = pass;
        points = 0;
    }
    
    public String getName(){
        return name;
    }
    
    public String getPassword(){
        return password;
    }
    
    public int getPoints(){
        return points;
    }
    
    public String getStatus(int points){
        
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative");
        } else if (points < 1000){
            status = "Silver";
        } else {
            status = "Gold";
        }
        
        return status;
    }
    
}
