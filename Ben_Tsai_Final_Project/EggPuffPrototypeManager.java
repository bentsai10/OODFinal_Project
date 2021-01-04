/**
 * Ben Tsai
 * 
 * Part of Prototype Pattern
*/

//prototype manager class to manage various prototypes for each flavor
public final class EggPuffPrototypeManager {
    private EggPuff protoPlain;
    private EggPuff protoChocolate;
    private EggPuff protoStrawberry;
    private EggPuff protoGreenTea;
    private EggPuff protoCoffee;
    
    //constructor makes one instance of each flavor
    public EggPuffPrototypeManager() {
    	try {
            protoPlain = EggPuff.makeNewEggPuffInstance("Plain");
            protoChocolate = EggPuff.makeNewEggPuffInstance("Chocolate");
            protoStrawberry= EggPuff.makeNewEggPuffInstance("Strawberry");
            protoGreenTea = EggPuff.makeNewEggPuffInstance("Green Tea");
            protoCoffee = EggPuff.makeNewEggPuffInstance("Coffee");
        } catch( UnknownEggPuffFlavorException e ) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    //order methods clone an EggPuff object based on the flavor
    public EggPuff orderPlainEggPuff() {
        EggPuff ep = null;
        try {
            ep = (EggPuff) protoPlain.clone();
        } catch( CloneNotSupportedException e) {}
        return ep;
    }
    public EggPuff orderChocolateEggPuff() {
        EggPuff ep = null;
        try {
            ep = (EggPuff) protoChocolate.clone();
        } catch( CloneNotSupportedException e) {}
        return ep;
    }
    public EggPuff orderStrawberryEggPuff() {
        EggPuff ep = null;
        try {
            ep = (EggPuff) protoStrawberry.clone();
        } catch( CloneNotSupportedException e) {}
        return ep;
    }
    public EggPuff orderGreenTeaEggPuff() {
        EggPuff ep = null;
        try {
            ep = (EggPuff) protoGreenTea.clone();
        } catch( CloneNotSupportedException e) {}
        return ep;
    }
    public EggPuff orderCoffeeEggPuff() {
        EggPuff ep = null;
        try {
            ep = (EggPuff) protoCoffee.clone();
        } catch( CloneNotSupportedException e) {}
        return ep;
    }
    
    public EggPuff order( String flavor ) throws UnknownEggPuffFlavorException {
    	if ( flavor.equals( "Plain" ) ) {
    	    return orderPlainEggPuff();
        } 
        else if ( flavor.equals( "Chocolate" ) ) {
            return orderChocolateEggPuff();
        } 
        else if ( flavor.equals( "Strawberry" ) ) {
            return orderStrawberryEggPuff();	
        } 
        else if ( flavor.equals( "Green Tea" ) ) {
            return orderGreenTeaEggPuff();	
        } 
        else if ( flavor.equals( "Coffee" ) ) {
            return orderCoffeeEggPuff();	
        } 
        else {
            throw new UnknownEggPuffFlavorException( "Unknown egg puff flavor ordered!" );
        }
    }
}
