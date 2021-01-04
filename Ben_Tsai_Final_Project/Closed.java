/**
 * Ben Tsai
 * 
 * Part of State Pattern
 */

import java.util.*;

//closed class represents the state of the store when it's closed
public class Closed implements Store_State {
    
    //getState retrieves welcoming statement to customer based on store state
    public String getState() {
        return "Unfortunately, we are closed! Please come back at any time between 11AM - 11PM!";
    }

    //launchOrderingInterface prints user prompts based on store state
    public void launchOrderingInterface(){
        while(true){
            Scanner sc = new Scanner(System.in);
            int input;

            while(true){
                System.out.println("\nIf you want to override our store hours to grade this final project,\nPress 1 for the lunch menu\nPress 2 for the dinner menu\nPress 3 to exit the program.\n");
                while(!sc.hasNextInt()){
                    System.out.println("\nPlease enter a number!");
                    sc.next();
                }
                input = sc.nextInt();
                if(input >= 1 && input <= 3){
                    break;
                }
                System.out.println("\nPlease enter a valid number!\n");
            }

            if(input == 1){
                this.changeState().launchOrderingInterface();
                break;
            }
            else if(input == 2){
                this.changeState().changeState().launchOrderingInterface();
                break;
            }
            else{
                break;
            }
        }
    }

    //changeState shifts store to its next available state
    public Store_State changeState() {
        return new Lunch();
    }
}
