package training.busboard.web;

import java.util.ArrayList;

public class GetBusResults {
	private ApiHandler API;
	private LatLongResults latLongPostcode;
	private String lat;
	private String lon;
	public BusStops busStops;
	public ArrayList<BusStopTimetable> timetables = new ArrayList<BusStopTimetable>();
	
    public GetBusResults(String userPostcode) {   	
    	this.API = new ApiHandler();
    	try {
    		//Get a LatLongResults object that contains the latitude and longitude of the given postcode
    		latLongPostcode = API.makeRequestLatLonFromPostcode(userPostcode);
			lat = String.valueOf(latLongPostcode.getLat());
	    	lon = String.valueOf(latLongPostcode.getLon());
	    	
	    	//get a busStops object that contains a list of the bus stops nearest to the lat/long
	    	busStops = API.makeRequestATCOFromLatLon(lat, lon);
	    	
	    	//get each timetable for the bus stop, and display it along with the distance
	    	for (int i = 0; i < Math.min(busStops.getStops().size() - 1, 2); i++) {
	    		BusStopTimetable timetable = API.makeRequestBusStopTimetableFromATCO(busStops.getATCO(i));
	    		timetable.setBusStopName(busStops.getStops().get(i).getDistance().toString());
	    		this.timetables.add(timetable);
	    	}
		} catch (BadAPIResponseException e) {
			System.out.println(e.error);
		}
    }
}	
