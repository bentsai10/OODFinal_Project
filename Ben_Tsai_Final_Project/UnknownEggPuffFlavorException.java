/**
 * Ben Tsai
 * 
 * Part of Prototype Pattern
*/

//Custom exception thrown when an unknown flavor of egg puffs are ordered
public class UnknownEggPuffFlavorException extends Exception {

    public UnknownEggPuffFlavorException() {
        super();
    }
    public UnknownEggPuffFlavorException(String message) {
        super(message);
    }
}
