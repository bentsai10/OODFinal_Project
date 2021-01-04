/**
 * Ben Tsai
 * 
 * Part of Abstract Factory pattern
 */

//abstract class Merchandise serving as umbrella for all potential subclasses representing merchandise items
public abstract class Merchandise {
	
    private String itemType;
    private double price;
    
    public Merchandise(String itemType, double price)  {
        this.itemType = itemType;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }
    public String toString() { 
        return itemType; 
    }
}
