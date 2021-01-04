/**
 * Ben Tsai
 * 
 * Part of State Pattern
 */

import java.util.*;
import java.text.DecimalFormat;

public class Lunch implements Store_State {
    
    //getState retrieves welcoming statement to customer based on store state
    public String getState() {
        return "We are open! It's currently during the lunch hours, so our lunch menu is available!";
    }
    //launchOrderingInterface prints user prompts based on store state
    public void launchOrderingInterface(){
        //ArrayLists tracking what's been ordered
        ArrayList<BobaDrink> drinksOrdered = new ArrayList<BobaDrink>();
        ArrayList<Merchandise> merchOrdered = new ArrayList<Merchandise>();

        //Factory objects for each merchandise item
        Factory shirtFactory = new ShirtFactory();
        Factory hatFactory = new HatFactory();
        Factory cupFactory = new CupFactory();

        //outer loop continues to take user input until user ends ordering process
        while(true){
            Scanner sc = new Scanner(System.in);
            int input;

            //inner loop continues to take user input until valid number provided
            while(true){
                System.out.println("\nLunch Menu\n");
                System.out.println("To order a boba drink, please press 1\nTo order official Boba Guys merchandise, please press 2\nTo end your visit with us today, please press 3\nTo order an egg puff snack, please come back during our dinner hours!\n");
                while(!sc.hasNextInt()){
                    System.out.println("\nPlease enter a number!");
                    sc.next();
                }
                input = sc.nextInt();
                if(input >= 1 && input <= 4){
                    break;
                }
                System.out.println("\nPlease enter a valid number!\n");
            }
            
            //Order Boba Drink Path using Builder pattern
            if(input == 1){
                //outer loop continues to take user input until user navigates to main menu
                while(true){
                    Scanner drinkScanner = new Scanner(System.in);
                    int drinkInput;

                    //inner loop continues to take user input until valid number provided
                    while(true){
                        System.out.println("\nDrink Menu\n");
                        System.out.println("To order a Classic Milk Tea ($5), please press 1\nTo order a Strawberry Matcha Latte ($6), please press 2\nTo order a Thai Tea ($5.25), please press 3\nTo go back to the main menu, please press 4\n");
                        while(!drinkScanner.hasNextInt()){
                            System.out.println("\nPlease enter a number!");
                            drinkScanner.next();
                        }
                        drinkInput = drinkScanner.nextInt();
                        if(drinkInput >= 1 && drinkInput <= 4){
                            break;
                        }
                        System.out.println("\nPlease enter a valid number!\n");
                    }
                    if(drinkInput == 1){
                        drinksOrdered.add(BobaGuysEmployee.makeBobaDrink("Classic Milk Tea"));
                    }
                    else if(drinkInput == 2){
                        drinksOrdered.add(BobaGuysEmployee.makeBobaDrink("Strawberry Matcha Latte"));
                    }
                    else if(drinkInput == 3){
                        drinksOrdered.add(BobaGuysEmployee.makeBobaDrink("Thai Tea"));
                    }else{
                        break;
                    }
                }
            }
            
            //Order Merchandise Path using Abstract Factory + Singleton pattern
            else if(input == 2){
                //outer loop continues to take user input until user navigates to main menu
                while(true){
                    Scanner merchScanner = new Scanner(System.in);
                    int merchInput;
                    
                    //inner loop continues to take user input until valid number provided
                    while(true){
                        System.out.println("Merchandise Items\n");
                        System.out.println("To order a Boba Guys Shirt ($40), please press 1\nTo order a Boba Guys Hat ($25.50), please press 2\nTo order a Boba Guys Cup ($10.25), please press 3\nTo go back to the main menu, please press 4");
                        while(!merchScanner.hasNextInt()){
                            System.out.println("\nPlease enter a number!");
                            merchScanner.next();
                        }
                        merchInput = merchScanner.nextInt();
                        if(merchInput >= 1 && merchInput <= 4){
                            break;
                        }
                        System.out.println("\nPlease enter a valid number!\n");
                    }
                    if(merchInput == 1){
                        merchOrdered.add(shirtFactory.deliverItem());
                        try {
                            Thread.sleep(1000);
                        } catch(InterruptedException e){}
                        System.out.println("Boba Guys shirt ordered");
                        try {
                            Thread.sleep(1000);
                        } catch(InterruptedException e){}
                        System.out.println("Retrieving Boba Guys shirt");
                        try {
                            Thread.sleep(1000);
                        } catch(InterruptedException e){}
                        System.out.println("Boba Guys shirt retrieved\n");
                        try {
                            Thread.sleep(1000);
                        } catch(InterruptedException e){}
                        
                    }
                    else if(merchInput == 2){
                        merchOrdered.add(hatFactory.deliverItem());
                        try {
                            Thread.sleep(1000);
                        } catch(InterruptedException e){}
                        System.out.println("Boba Guys hat ordered");
                        try {
                            Thread.sleep(1000);
                        } catch(InterruptedException e){}
                        System.out.println("Retrieving Boba Guys hat");
                        try {
                            Thread.sleep(1000);
                        } catch(InterruptedException e){}
                        System.out.println("Boba Guys hat retrieved\n");
                        try {
                            Thread.sleep(1000);
                        } catch(InterruptedException e){}
                    }
                    else if(merchInput == 3){
                        merchOrdered.add(cupFactory.deliverItem());
                        try {
                            Thread.sleep(1000);
                        } catch(InterruptedException e){}
                        System.out.println("Boba Guys cup ordered");
                        try {
                            Thread.sleep(1000);
                        } catch(InterruptedException e){}
                        System.out.println("Retrieving Boba Guys cup");
                        try {
                            Thread.sleep(1000);
                        } catch(InterruptedException e){}
                        System.out.println("Boba Guys cup retrieved\n");
                        try {
                            Thread.sleep(1000);
                        } catch(InterruptedException e){}
                    }else{
                        break;
                    }
                }   
            }

            if(input == 3){
                break;
            }
        }
        if(drinksOrdered.size() > 0){
            System.out.println("\nNumber of drinks ordered: " + drinksOrdered.size()); 
        }
        if(merchOrdered.size() > 0){
            System.out.println("\nNumber of merchandise items ordered: " + merchOrdered.size());
        }
        
        System.out.println("\nBelow are your ordered items: ");

        double total = 0;
        DecimalFormat df = new DecimalFormat("#.00");

        //for each type of item create a hashmap tracking how much of each item is ordered
        //create another hashmap keeping track of the price of each item
        //Iterate through all items of one type to calculate quantity ordered of each item and adjust the total price
        HashMap<String, Integer> drinkTracker = new HashMap<String, Integer>();
        HashMap<String, Double> drinkPriceTracker = new HashMap<String, Double>();
        ListIterator<BobaDrink> drinkIter = drinksOrdered.listIterator();
        while(drinkIter.hasNext()){
            BobaDrink drink = drinkIter.next();
            if(drinkTracker.get(drink.getName()) == null){
                drinkTracker.put(drink.getName(), 1);
                drinkPriceTracker.put(drink.getName(), drink.getPrice());
            }else{
                drinkTracker.put(drink.getName(), drinkTracker.get(drink.getName()) + 1);
            }
        }
        for (String drink : drinkTracker.keySet()) {
            System.out.print(drinkTracker.get(drink) + " " + drink);
            total += drinkPriceTracker.get(drink) * drinkTracker.get(drink);
            if(drinkTracker.get(drink) > 1){
                System.out.print("s");
            }
            System.out.print(" ($" + df.format(drinkPriceTracker.get(drink)) + " each)");
            System.out.println();
        }

        HashMap<String, Integer> merchTracker = new HashMap<String, Integer>();
        HashMap<String, Double> merchPriceTracker = new HashMap<String, Double>();
        ListIterator<Merchandise> merchIter = merchOrdered.listIterator();
        while(merchIter.hasNext()){
            Merchandise merchItem = merchIter.next();
            if(Shirt.class.isAssignableFrom(merchItem.getClass())){
                if(merchTracker.get("Boba Guys Shirt") == null){
                    merchTracker.put("Boba Guys Shirt", 1);
                    merchPriceTracker.put("Boba Guys Shirt", merchItem.getPrice());
                }
                else{
                    merchTracker.put("Boba Guys Shirt", merchTracker.get("Boba Guys Shirt") + 1);
                }
                continue;
            }
            if(Hat.class.isAssignableFrom(merchItem.getClass())){
                if(merchTracker.get("Boba Guys Hat") == null){
                    merchTracker.put("Boba Guys Hat", 1);
                    merchPriceTracker.put("Boba Guys Hat", merchItem.getPrice());
                }
                else{
                    merchTracker.put("Boba Guys Hat", merchTracker.get("Boba Guys Hat") + 1);
                }
                continue;
            }
            if(Cup.class.isAssignableFrom(merchItem.getClass())){
                if(merchTracker.get("Boba Guys Cup") == null){
                    merchTracker.put("Boba Guys Cup", 1);
                    merchPriceTracker.put("Boba Guys Cup", merchItem.getPrice());
                }
                else{
                    merchTracker.put("Boba Guys Cup", merchTracker.get("Boba Guys Cup") + 1);
                }
                continue;
            }
        }
        for (String merchObject : merchTracker.keySet()) {
            System.out.print(merchTracker.get(merchObject) + " " + merchObject);
            total += merchPriceTracker.get(merchObject) * merchTracker.get(merchObject);
            if(merchTracker.get(merchObject) > 1){
                System.out.print("s");
            }
            System.out.print(" ($" + df.format(merchPriceTracker.get(merchObject)) + " each)");
            System.out.println();
        }
        
        System.out.println("\nYour total today is: $" + df.format(total));
        System.out.println("\nThanks for shopping with us!");
    }
    
    //changeState shifts store to its next available state
    public Store_State changeState() {
        return new Dinner();
    }
}
