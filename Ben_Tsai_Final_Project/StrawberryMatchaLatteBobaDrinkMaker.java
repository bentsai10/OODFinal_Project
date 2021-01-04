/**
 * Ben Tsai
 * 
 * Part of Builder Pattern
 */

import java.util.*;

//Subclass of BobaDrinkMaker to make Strawberry Matcha Lattes
public class StrawberryMatchaLatteBobaDrinkMaker extends BobaDrinkMaker {

    //add method for each required ingredient
    //if ingredients added out of order, DrinkMakingStepViolation will be thrown	
    protected void addLatte() throws DrinkMakingStepViolation { 
        latte = new Ingredient( "Latte");
        System.out.println( "Latte added to drink as base.");
    }
    protected void addBoba() throws DrinkMakingStepViolation {
        if ( latte == null ) {
            throw new DrinkMakingStepViolation("\nLatte base must added before boba can be added to the drink.\n" );
        }
        boba = new Ingredient( "Boba");
        System.out.println( "Added three scoops of boba pearls to the drink.");	
    }
    protected void addStrawberryPuree() throws DrinkMakingStepViolation {
        if ( boba == null ) {
            throw new DrinkMakingStepViolation( "\nBoba scoops must added before strawberry puree can be added to maximize the drink's flavor.\n"  );
        }
        strawberryPuree = new Ingredient( "Strawberry Puree");
        System.out.println( "Drizzled strawberry puree to bottom of drink.");		
    }
    protected void addOatMilk() throws DrinkMakingStepViolation {
        if ( strawberryPuree == null ) {
            throw new DrinkMakingStepViolation( "\nStrawberry puree must be drizzled to achieve layering aesthetic\n" );
        }
        oatMilk = new Ingredient( "Oat Milk");
        System.out.println( "Added a cup of oat milk to the drink.");	
    } 
    protected void addMatcha() throws DrinkMakingStepViolation {
        if ( oatMilk == null ) {
            throw new DrinkMakingStepViolation( "\nOat Milk must be added first to achieve layering aesthetic.\n" );
        }
        matcha = new Ingredient( "Matcha");
        System.out.println( "Topped drink off with some matcha.");		
    }

    //makeBobaDrink calls each add ingredient method to gather all ingredients needed to make Strawberry Matcha Latte
    public void makeBobaDrink() throws DrinkMakingStepViolation{
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
        addLatte();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
        addBoba();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
        addStrawberryPuree();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
        addOatMilk();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
        addMatcha();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
    }
    //getDrink method ensures all ingredients have been gathered and creates a BobaDrink object with given ingredients
    public BobaDrink getDrink() {
        if ( latte != null & boba != null & strawberryPuree != null & oatMilk != null & matcha != null){
            drinkMade = new BobaDrink( "Strawberry Matcha Latte", 6.00,  
            new ArrayList<Ingredient>( Arrays.asList( latte, boba, strawberryPuree, oatMilk, matcha)));
            System.out.println( "\nStrawberry Matcha Latte made using StrawberryMatchaLatteBobaDrinkMaker.java\n" );
            return drinkMade;
        } else {
            System.out.println( "\nStrawberryMatchaLatteBobaDrinkMaker unable to make Strawberry Matcha Latte.\n" );
            return null;
        }
    }
}
