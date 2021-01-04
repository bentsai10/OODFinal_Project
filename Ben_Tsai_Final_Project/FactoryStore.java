/**
 * Ben Tsai
 * 
 * Part of Abstract Factory pattern
 */

import java.util.*;

//FactoryStore class representing store where orders are placed to appropriate factories
public class FactoryStore {

    private static FactoryStore store;

    //instance variables track merchandise sold and merchandise stock
    private static final int N = 10;
    private int shirtDeliveredFromNewStock;
    private int hatDeliveredFromNewStock;
    private int cupDeliveredFromNewStock;
	
    private ArrayList<Shirt> shirtsInStock = new ArrayList<Shirt>();
    private ArrayList<Hat> hatsInStock = new ArrayList<Hat>();
    private ArrayList<Cup>  cupsInStock = new ArrayList<Cup>();

    //reset instance variables when new FactoryStore created
    private FactoryStore() {
        shirtDeliveredFromNewStock = 0;
        hatDeliveredFromNewStock = 0;
        cupDeliveredFromNewStock = 0;

        for ( int i = 0; i < N; i++ ) {
            shirtsInStock.add(new Shirt());
            hatsInStock.add(new Hat());
            cupsInStock.add(new Cup());
        }
    }

    //constructor utilizes Singleton pattern to create FactoryStore object
    public static FactoryStore makeFactoryStore() {
        if (store == null) {
            store = new FactoryStore();
        }
        return store;
    }        

    public int batchSize(){ 
        return N; 
    }

    //acquire methods restock merchandise item
    //initialize methods reset number of merchandise item sold
    public void acquireMoreShirtsFromFactory(ArrayList<Shirt> freshStock) {
        shirtsInStock = freshStock;
    }
    public void initializeShirtStock() { 
        shirtDeliveredFromNewStock = 0; 
    }
    public void acquireMoreHatsFromFactory(ArrayList<Hat> freshStock) {
        hatsInStock = freshStock;
    }
    public void initializeHatStock() { 
        hatDeliveredFromNewStock = 0; 
    }
    public void acquireMoreCupsFromFactory(ArrayList<Cup> freshStock) {
        cupsInStock = freshStock;
    }
    public void initializeCupStock() { 
        cupDeliveredFromNewStock = 0; 
    }
    //check methods check whether there are still merchandise items left
    public boolean checkShirtStockIsEmpty() {
        return shirtDeliveredFromNewStock == N ? true : false;
    }
    public boolean checkHatStockIsEmpty() {
        return hatDeliveredFromNewStock == N ? true : false;
    }
    public boolean checkCupStockIsEmpty() {
        return cupDeliveredFromNewStock == N ? true : false;
    }

    //deliver methods retrieve merchandise item from store stock
    public Shirt deliverOneShirtToClient() {
        return shirtsInStock.get(shirtDeliveredFromNewStock++);
    }
    public Hat deliverOneHatToClient() {
        return hatsInStock.get(hatDeliveredFromNewStock++);
    }
    public Cup deliverOneCupToClient() {
        return cupsInStock.get(cupDeliveredFromNewStock++);
    }
}
