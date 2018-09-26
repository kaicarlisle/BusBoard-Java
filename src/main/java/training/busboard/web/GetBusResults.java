package training.busboard.web;

import java.util.ArrayList;

public class GetBusResults {
	private final static Integer max_number_of_bus_stops = 2;
	
	private ApiHandler API;
	private LatLongResults latLongPostcode;
	private String lat;
	private String lon;
	private BusStops busStops;
	private ArrayList<BusStopTimetable> timetables = new ArrayList<BusStopTimetable>();
	private BusStopTimetable timetable;
		
    public GetBusResults(String userPostcode) throws BadAPIResponseException {   	
    	this.API = new ApiHandler();
		//Get a LatLongResults object that contains the latitude and longitude of the given postcode
		latLongPostcode = API.makeRequestLatLonFromPostcode(userPostcode);
		lat = String.valueOf(latLongPostcode.getLat());
    	lon = String.valueOf(latLongPostcode.getLon());
    	
    	//get a busStops object that contains a list of the bus stops nearest to the lat/long
    	busStops = API.makeRequestATCOFromLatLon(lat, lon);
    	
    	//get each timetable for the bus stop, and add it to the list of timetables
    	//also set the bus Stop display string
    	for (int i = 0; i < Math.min(busStops.getStops().size() - 1, max_number_of_bus_stops); i++) {
    		this.timetable = this.API.makeRequestBusStopTimetableFromATCO(this.busStops.getATCO(i));
    		this.timetable.setDistance(this.busStops.getStops().get(i).getDistance().toString());
    		this.timetables.add(timetable);
    	}
    }
    
    public ArrayList<BusStopTimetable> getTimetables() {
    	return this.timetables;
    }
}	
