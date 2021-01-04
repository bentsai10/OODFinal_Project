/**
 * Ben Tsai
 * 
 * Part of Builder Pattern
 */

import java.util.*;

//Subclass of BobaDrinkMaker to make Thai Teas
public class ThaiTeaBobaDrinkMaker extends BobaDrinkMaker {

    //add method for each required ingredient
    //if ingredients added out of order, DrinkMakingStepViolation will be thrown
    protected void addGreenTea() throws DrinkMakingStepViolation { 
        greenTea = new Ingredient( "Green Tea");
        System.out.println( "Green Tea added to drink as base.");
    }
    protected void addBoba() throws DrinkMakingStepViolation {
        if ( greenTea == null ) {
            throw new DrinkMakingStepViolation( "\nGreen Tea base must added before boba can be added to the drink.\n" );
        }
        boba = new Ingredient( "Boba");
        System.out.println( "Added three scoops of boba pearls to the drink.");		
    }
    protected void addSpices() throws DrinkMakingStepViolation {
        if ( greenTea == null ) {
            throw new DrinkMakingStepViolation( "\nGreen Tea must be added before spices can be used to alter taste of green tea.\n"  );
        }
        spices = new Ingredient( "Spices");
        System.out.println( "Added spices to spice up green tea base.");		
    }
    protected void addOatMilk() throws DrinkMakingStepViolation {
        if ( greenTea == null ) {
            throw new DrinkMakingStepViolation("\nGreen Tea must be added before oat milk can be used to alter taste of green tea.\n" );
        }
        oatMilk = new Ingredient( "Oat Milk");
        System.out.println( "Added a cup of oat milk to the drink.");		
    }
    protected void addCondensedMilk() throws DrinkMakingStepViolation {
        if ( oatMilk == null || spices == null) {
            throw new DrinkMakingStepViolation( "\nOat milk and spices must be first used to alter taste of green tea base before adding condensed milk.\n" );
        }
        condensedMilk = new Ingredient( "Condensed Milk");
        System.out.println( "Topped drink off with some condensed milk.");
    }

    //makeBobaDrink calls each add ingredient method to gather all ingredients needed to make Thai Tea
    public void makeBobaDrink() throws DrinkMakingStepViolation{
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
        addGreenTea();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
        addBoba();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
        addSpices();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
        addOatMilk();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
        addCondensedMilk();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){}
    }

    //getDrink method ensures all ingredients have been gathered and creates a BobaDrink object with given ingredients
    public BobaDrink getDrink() {
        if ( greenTea != null & boba != null & spices != null & oatMilk != null & condensedMilk != null){
            drinkMade = new BobaDrink( "Thai Tea", 5.25,  
            new ArrayList<Ingredient>( Arrays.asList( greenTea, boba, spices, oatMilk, condensedMilk)));
            System.out.println( 
               "\nThai Tea made using ThaiTeaBobaDrinkMaker.java\n" );
            return drinkMade;
        } else {
            System.out.println("\nThaiTeaBobaDrinkMaker unable to make Thai Tea.\n");
            return null;
        }
    }
}
