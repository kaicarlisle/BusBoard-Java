package training.busboard;

import java.util.ArrayList;

public class Main {	
    public static void main(String args[]) {
    	ApiHandler API;
    	Postcode postcode;
    	String lat;
    	String lon;
    	BusStops busStops;
    	ArrayList<String> ATCOs = new ArrayList<String>();
    	
    	UserInput input = new UserInput();
    	String userPostcode = input.getInput();
    	input.closeScanner();
    	
    	API = new ApiHandler();
    	postcode = API.makeRequestLatLonFromPostcode(userPostcode);
    	lat = String.valueOf(postcode.getLat());
    	lon = String.valueOf(postcode.getLon());
    	
    	busStops = API.makeRequestATCOFromLatLon(lat, lon);
    	ATCOs.add(busStops.getATCO(0));
    	ATCOs.add(busStops.getATCO(1));
    	
    	for (String ATCO : ATCOs) {
    		System.out.println(API.makeRequestBusFromATCO(ATCO));
    	}
    }
}	
