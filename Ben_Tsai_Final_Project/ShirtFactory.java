/**
 * Ben Tsai
 * 
 * Part of Abstract Factory Pattern
 */

import java.util.*;

//subclass of Factory for creating Shirt objects
public class ShirtFactory extends Factory {

    public ShirtFactory() { super();}

    //deliverItem must be implemented by subclass of Factory
    public Shirt deliverItem() {
        return deliverShirt();
    }
    //specific Shirt delivery method; replenishes FactoryStore stock of hats if none left
    private Shirt deliverShirt() {
        if ( store.checkShirtStockIsEmpty() ) 
        replenishShirtStock();
        return store.deliverOneShirtToClient();
    }	
    
    //adding more hats to FactoryStore stock
    private void replenishShirtStock() {
        System.out.println( "Replenishing stock with " 
                          + store.batchSize() + " shirts" );
        ArrayList<Shirt> freshStock = new ArrayList<Shirt>();
        for ( int i = 0; i < store.batchSize(); i++ ) {
            freshStock.add(new Shirt());
        }
        store.acquireMoreShirtsFromFactory(freshStock);
        store.initializeShirtStock();
    }
}
