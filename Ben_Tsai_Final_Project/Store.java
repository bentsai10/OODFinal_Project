/**
 * Ben Tsai
 * 
 * Part of State Pattern
 */

import java.util.List;

//Store class representing the boba shop
public class Store {
    
    //Store_state instance variable representing current store state
    private static Store_State state;
	
    public Store( Store_State state ) {
        this.state = state;
    }

    //get user welcome statement based on store state
    public String getState() {
        return state.getState();
    }
    //print the user prompts based on store state
    public void launchOrderingInterface() {
        state.launchOrderingInterface();
    }
}
