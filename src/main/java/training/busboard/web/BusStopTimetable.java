package training.busboard.web;

import java.util.ArrayList;

public class BusStopTimetable {
	private String name;
	private BusDepartures departures;
	
	private String busStopName;
	
//	public String headerString = "Time\tLine\tDestination\n\t---------------------------------------";
	
	public void setBusStopName(String distance) {
		this.busStopName = this.name + " - " + distance + "m away";
	}
	
	public String getBusStopName() {
		return this.busStopName;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setDepartures(BusDepartures departures) {
		this.departures = departures;
	}
	
	public BusDepartures getDepartures() {
		return this.departures;
	}
	
	public class BusDepartures {
		private ArrayList<Bus> all;
		
		public void setAll(Bus bus) {
			this.all.add(bus);
		}

		public ArrayList<Bus> getAll() {
			return this.all;
		}
	}
}
