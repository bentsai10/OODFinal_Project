/**
 * Ben Tsai
 * 
 * Part of Prototype Pattern
*/

import java.util.*;

//EggPuff class representing egg puff snack object
public class EggPuff implements Cloneable {
	
    private String flavor;
    private double price;
	
    private final static Set<String> allFlavors = new HashSet<String>(Arrays.asList("Plain", "Chocolate","Strawberry","Green Tea","Coffee"));

    //private constructor to control the creation of new EggPuff objects
    private EggPuff(String flavor) throws UnknownEggPuffFlavorException {
        try {
            if ( allFlavors.contains(flavor) ) { 
                this.flavor = flavor;
                if ( flavor.equals( "Plain" ) ) {
                    price = 3;
                } else if ( flavor.equals("Chocolate")) {
                    price = 4;
                } else if ( flavor.equals("Strawberry")) {
                    price = 4;
                } else if ( flavor.equals("Green Tea")){
                    price = 4.5;
                } else if ( flavor.equals("Coffee")){
                    price = 4.5;
                } 
            } else {
                throw new UnknownEggPuffFlavorException( "We don't have egg puffs of the flavor " + flavor + " on the menu");
            }
        } catch( ClassCastException e ) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    public static EggPuff makeNewEggPuffInstance( String flavor ) throws UnknownEggPuffFlavorException {
        return new EggPuff( flavor );
    }
    public double getPrice() {
        return price ;
    }
    public String getFlavor(){
        return flavor;
    }
    public Object clone() throws CloneNotSupportedException {
        EggPuff ep = (EggPuff) super.clone();
        return ep;
    }
    public String toString() {
        return flavor + " " + this.getClass().getName();
    }
}
