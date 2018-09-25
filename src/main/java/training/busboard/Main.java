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
    		//Get a LatLongResults object that contains the latitude and longitude of the given postcode
			postcode = API.makeRequestLatLonFromPostcode(userPostcode);
			lat = String.valueOf(postcode.getLat());
	    	lon = String.valueOf(postcode.getLon());
	    	
	    	//get a busStops object that contains a list of the bus stops nearest to the lat/long
	    	busStops = API.makeRequestATCOFromLatLon(lat, lon);
	    	
	    	//add each bus stop's ATCO code to the list of ATCOs
	    	for (int i = 0; i < Math.min(busStops.getStops().size() - 1, 2); i++) {
	    		ATCOs.add(busStops.getATCO(i));
	    	}
	    	
	    	//get and print the timetable for each bus stop in the list of ATCOs
	    	for (String ATCO : ATCOs) {
	    		System.out.println(API.makeRequestBusStopTimetableFromATCO(ATCO));
	    	}
		} catch (BadAPIResponseException e) {
			System.out.println(e.error);
		}    	
    }
}	
