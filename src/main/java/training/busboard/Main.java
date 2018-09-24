package training.busboard;

import java.util.ArrayList;

public class Main {	
    public static void main(String args[]) {
    	ApiHandler API;
    	BusStops busStops;
    	ArrayList<String> ATCOs = new ArrayList<String>();
    	
    	UserInput input = new UserInput();
    	String lat = input.getInput();
    	String lon = input.getInput();
    	input.closeScanner();
    	
    	API = new ApiHandler(); 
    	busStops = API.makeRequestATCOFromLatLon(lat, lon);
    	ATCOs.add(busStops.getATCO(1));
    	ATCOs.add(busStops.getATCO(2));
    	
    	for (String ATCO : ATCOs) {
    		API.makeRequestBusFromATCO(ATCO);
    	}
    }
}	
