package training.busboard;

import java.util.ArrayList;

public class Main {	
    public static void main(String args[]) {
    	ApiHandler API;
    	LatLongResults postcode;
    	String lat;
    	String lon;
    	BusStops busStops;
    	ArrayList<String> ATCOs = new ArrayList<String>();
    	
    	UserInput input = new UserInput();
    	String userPostcode = input.getInput();
    	input.closeScanner();
    	
    	API = new ApiHandler();
    	try {
			postcode = API.makeRequestLatLonFromPostcode(userPostcode);
			lat = String.valueOf(postcode.getLat());
	    	lon = String.valueOf(postcode.getLon());
	    	
	    	busStops = API.makeRequestATCOFromLatLon(lat, lon);
	    	for (int i = 0; i < busStops.getStops().size() - 1; i++) {
	    		ATCOs.add(busStops.getATCO(i));
	    	}
	    	
	    	for (String ATCO : ATCOs) {
	    		System.out.println(API.makeRequestBusStopTimetableFromATCO(ATCO));
	    	}
		} catch (BadAPIResponseException e) {
			System.out.println(e.error);
		}
    	
    }
}	
