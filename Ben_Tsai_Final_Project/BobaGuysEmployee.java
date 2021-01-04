/**
 * Ben Tsai
 * 
 * Part of Builder Pattern
 */
import java.util.*;

//Director class of builder pattern
public class BobaGuysEmployee {

    //protected instance variables for all possible drink ingredients
    protected Ingredient milkTea; 
    protected Ingredient greenTea; 
    protected Ingredient latte;  
    protected Ingredient oatMilk; 
    protected Ingredient boba; 
    protected Ingredient matcha; 
    protected Ingredient strawberryPuree; 
    protected Ingredient spices;  
    protected Ingredient condensedMilk;

    //makeBobaDrink method takes order from customer and creates an appropriate BobaDrinkMaker object to make ordered drink
    public static BobaDrink makeBobaDrink( String order ) {
        BobaDrinkMaker drinkMaker = null;

        //check what was ordered to create appropriate BobaDrinkMaker object
        if ( order.equalsIgnoreCase("Classic Milk Tea")){
            System.out.println("\nBOBA GUYS EMPLOYEE will make a Classic Milk Tea now\n");
            drinkMaker = new ClassicBobaDrinkMaker();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e){}
        } else if (order.equalsIgnoreCase("Strawberry Matcha Latte")){
            System.out.println("\n\nBOBA GUYS EMPLOYEE will make a Strawberry Matcha Latte now\n");
            drinkMaker = new StrawberryMatchaLatteBobaDrinkMaker();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e){}
        } else if ( order.equalsIgnoreCase("Thai Tea") ) {
            System.out.println("\n\nBOBA GUYS EMPLOYEE will make a Thai Tea now\n");
            drinkMaker = new ThaiTeaBobaDrinkMaker();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e){}
        }
        //once we have appropriate BobaDrinkMaker object, call makeBobaDrink method of that object
        //retrieve the drink made
        try {
            drinkMaker.makeBobaDrink();
            return drinkMaker.getDrink();
        } catch( DrinkMakingStepViolation violation ) {
            System.out.println( violation.getMessage() );
            return null;
        }
    }
}
