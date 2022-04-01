package application;

/**
 *
 * @author Ibrahima (Ibah)
 */

public class Book {
    
    private String name;
    private double price;
    
    Book(String name, double price){
        this.name = name;
        this.price = price;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public String toString(){
        return this.getName() + ", " + this.getPrice();
    }
    
}
