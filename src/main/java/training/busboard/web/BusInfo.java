package training.busboard.web;

import java.util.ArrayList;

public class BusInfo {
    private ArrayList<BusStopTimetable> timetable;

    public BusInfo(ArrayList<BusStopTimetable> timetable) {
        this.timetable = timetable;
    }

    public ArrayList<BusStopTimetable> getTimetable() {
        return timetable;
    }
    
    public void setDisplayString() {
    	for (BusStopTimetable t : this.timetable) {
    		t.displayString = t.display("35");
    	}
    }
}
