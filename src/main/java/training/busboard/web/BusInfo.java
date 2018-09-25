package training.busboard.web;

import java.util.ArrayList;

public class BusInfo {
    private ArrayList<BusStopTimetable> timetables;

    public BusInfo(ArrayList<BusStopTimetable> timetables) {
        this.timetables = timetables;
    }

    public ArrayList<BusStopTimetable> getTimetables() {
        return timetables;
    }
}
