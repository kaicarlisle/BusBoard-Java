package training.busboard.web;

import java.util.ArrayList;

public class BusInfo {
    private ArrayList<BusStopTimetable> timetables;
    private String postcode;

    public BusInfo(ArrayList<BusStopTimetable> timetables) {
        this.timetables = timetables;
    }

    public ArrayList<BusStopTimetable> getTimetables() {
        return timetables;
    }
    
    public void setPostcode(String postcode) {
    	this.postcode = postcode;
    }
    
    public String getPostcode() {
    	return this.postcode;
    }
}
