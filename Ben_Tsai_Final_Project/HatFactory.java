/**
 * Ben Tsai
 * 
 * Part of Abstract Factory pattern
 */

import java.util.*;

//subclass of Factory for creating Hat objects
public class HatFactory extends Factory {

    public HatFactory() { super();}

    //deliverItem must be implemented by subclass of Factory
    public Hat deliverItem() {
        return deliverHat();
    }

    //specific Hat delivery method; replenishes FactoryStore stock of hats if none left
    private Hat deliverHat() {
        if ( store.checkHatStockIsEmpty() ) 
        replenishHatStock();
        return store.deliverOneHatToClient();
    }	
    
    //adding more hats to FactoryStore stock
    private void replenishHatStock() {
        System.out.println( "Replenishing stock with " 
                          + store.batchSize() + " hats" );
        ArrayList<Hat> freshStock = new ArrayList<Hat>();
        for ( int i = 0; i < store.batchSize(); i++ ) {
            freshStock.add(new Hat());
        }
        store.acquireMoreHatsFromFactory(freshStock);
        store.initializeHatStock();
    }
}
