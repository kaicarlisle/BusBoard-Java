package training.busboard;

public class Main {	
    public static void main(String args[]) {
    	ApiHandler API;
    	LatLongResults postcode;
    	String lat;
    	String lon;
    	BusStops busStops;
    	
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
	    	
	    	//get each timetable for the bus stop, and display it along with the distance
	    	for (int i = 0; i < Math.min(busStops.getStops().size() - 1, 2); i++) {
	    		BusStopTimetable timetable = API.makeRequestBusStopTimetableFromATCO(busStops.getATCO(i));
	    		System.out.println(timetable.display(busStops.getStops().get(i).getDistance().toString()));
	    	}
		} catch (BadAPIResponseException e) {
			System.out.println(e.error);
		}    	
    }
}	
