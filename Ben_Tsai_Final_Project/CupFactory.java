/**
 * Ben Tsai
 * 
 * Part of Abstract Factory pattern
 */

import java.util.*;


//subclass of Factory for creating Cup objects
public class CupFactory extends Factory {

    public CupFactory() { super();}

    //deliverItem must be implemented by subclass of Factory
    public Cup deliverItem() {
        return deliverCup();
    }
    //specific Cup delivery method; replenishes FactoryStore stock of cups if none left
    private Cup deliverCup() {
        if (store.checkCupStockIsEmpty()){
            replenishCupStock();
        }
        return store.deliverOneCupToClient();
    }	
    
    //adding more cups to FactoryStore stock
    private void replenishCupStock() {
        System.out.println( "Replenishing stock with " + store.batchSize() + " cups" );
        ArrayList<Cup> freshStock = new ArrayList<Cup>();
        for ( int i = 0; i < store.batchSize(); i++ ) {
            freshStock.add(new Cup());
        }
        store.acquireMoreCupsFromFactory(freshStock);
        store.initializeCupStock();
    }
}
