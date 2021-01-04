/**
 * Ben Tsai
 * 
 * Part of Builder Pattern
 */

//Ingredient class representing ingredient objects needed to create BobaDrinks
public class Ingredient {
    String name;
    
    public Ingredient( String name ) {
        this.name = name;
    }
    public String toString() { return name; }
}
