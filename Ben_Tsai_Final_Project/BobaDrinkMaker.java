/**
 * Ben Tsai
 * 
 * Part of Builder Pattern
 */

import java.util.*;

//abstract class BobaDrinkMaker containing blueprint for BobaDrinkMaker subclasses for making a variety of drinks
public abstract class BobaDrinkMaker {
       
    //instance variables for all possible ingredients   
    protected Ingredient milkTea; 
    protected Ingredient greenTea; 
    protected Ingredient latte;  
    protected Ingredient oatMilk; 
    protected Ingredient boba; 
    protected Ingredient matcha; 
    protected Ingredient strawberryPuree; 
    protected Ingredient spices;  
    protected Ingredient condensedMilk; 
    

    protected BobaDrink drinkMade;
    
    //add ingredient methods for all possible ingredients, meant to be overwritten when needed by subclasses
    protected void addMilkTea() 
           throws DrinkMakingStepViolation {}
    protected void addGreenTea() 
           throws DrinkMakingStepViolation {}
    protected void addLatte() 
           throws DrinkMakingStepViolation {}
    protected void addOatMilk() 
           throws DrinkMakingStepViolation {}
    protected void addBoba() 
           throws DrinkMakingStepViolation {}
    protected void addMatcha() 
           throws DrinkMakingStepViolation {}
    protected void addStrawberryPuree() 
           throws DrinkMakingStepViolation {}
    protected void addSpices() 
    throws DrinkMakingStepViolation {}
    protected void addCondensedMilk() 
    throws DrinkMakingStepViolation {}

    //two essential methods all subclasses must implement to produce and retrieve BobaDrink object
    public abstract void makeBobaDrink() throws DrinkMakingStepViolation;
    public abstract BobaDrink getDrink();
}
