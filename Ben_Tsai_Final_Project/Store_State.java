/**
 * Ben Tsai
 * 
 * Part of State Pattern
 */

import java.util.List;

//Store_state interface includes 3 essential methods to retrieve welcome statement, launch user prompts, and shift to the next state based on the current state
public interface Store_State {
    public String getState();
    public void launchOrderingInterface();
    public Store_State changeState();
}
