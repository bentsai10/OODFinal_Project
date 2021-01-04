/**
 * Ben Tsai
 * 
 * Part of Builder Pattern
 */

import java.util.*;

//Subclass of BobaDrinkMaker to make Classic Milk Teas
public class ClassicBobaDrinkMaker extends BobaDrinkMaker {
    
    //add method for each required ingredient
    //if ingredients added out of order, DrinkMakingStepViolation will be thrown
    protected void addMilkTea() throws DrinkMakingStepViolation { 
        milkTea = new Ingredient( "Milk Tea");
        System.out.println( "Milk Tea added to drink as base.");
    }
    protected void addBoba() 
                 throws DrinkMakingStepViolation {
        if ( milkTea == null ) {
            throw new DrinkMakingStepViolation( "\nMilk Tea base must added before boba can be added to the drink.\n" );
        }
        boba = new Ingredient( "Boba");
        System.out.println( "Added three scoops of boba pearls to the drink.");		
    }
    //makeBobaDrink calls each add ingredient method to gather all ingredients needed to make Classic Milk Tea
    public void makeBobaDrink() throws DrinkMakingStepViolation{
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
        addMilkTea();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
        addBoba();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
    }
    //getDrink method ensures all ingredients have been gathered and creates a BobaDrink object with given ingredients
    public BobaDrink getDrink() {
        if ( milkTea != null   &   boba != null ) {
            drinkMade = new BobaDrink( "Classic Milk Tea", 5.00, 
            new ArrayList<Ingredient>( Arrays.asList( milkTea, boba )));
            System.out.println( "\nClassic Milk Tea made using ClassicBobaDrinkMaker.java\n" );
            return drinkMade;
        } else {
            System.out.println("\nClassicBobaDrinkMaker unable to make Classic Milk Tea\n");
            return null;
        }
    }
}
