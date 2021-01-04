/**
 * Ben Tsai
 * 
 * Part of Abstract Factory pattern
 */

//abstract factory class with a Singleton FactoryStore instance variable
public abstract class Factory {

    protected FactoryStore store;

    public Factory(){ 
        store = FactoryStore.makeFactoryStore();
    }

    //require subclasses to implement a deliverItem method to retrieve object
    abstract Merchandise deliverItem();
}
