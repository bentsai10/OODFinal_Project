/**
 * Ben Tsai
 * 
 * Part of Builder Pattern
 */


//Exception thrown when BobaDrink not made in correct order
public class DrinkMakingStepViolation extends Exception {

    public DrinkMakingStepViolation() {
        super();
    }
    public DrinkMakingStepViolation(String message) {
        super(message);
    }
}
