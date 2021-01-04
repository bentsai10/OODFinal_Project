/**
 * Ben Tsai
 * Main Driver Class
 */

import java.util.*;

public class BobaGuysDriver {
    public static void main(String[] args){
        System.out.println("\nWelcome to Boba Guys!\n");

        //retrieve current time
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minOfDay = calendar.get(Calendar.MINUTE);
        System.out.println("It is currently " + hourOfDay + ":" + minOfDay + ".\n");

        //based on time of day, change state of program
        Store_State currentStoreState;
        if(hourOfDay >= 11 && hourOfDay <17){
            currentStoreState = new Lunch();
        }
        else if(hourOfDay >= 17 && hourOfDay <= 22 ){
            currentStoreState = new Dinner();
            
        }else{
            currentStoreState = new Closed();
        }
        Store store = new Store(currentStoreState);
        System.out.println(store.getState());
        store.launchOrderingInterface();
    }
}