/**
 * Ben Tsai
 * 
 * Part of Builder & Decorator pattern
 */

import java.util.*;

//BobaDrink object with name instance variable and list of ingredients instance variable
public class BobaDrink{
    private String name;
    private double price;
    private List<Ingredient> ingredients;
	
    public BobaDrink( String name, double price, List<Ingredient> ingredients ) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String toString(){
        return getName();
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }
}
