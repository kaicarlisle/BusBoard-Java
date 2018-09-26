package training.busboard.web;

import java.util.ArrayList;

public class BusStopTimetable {
	private String name;
	private BusDepartures departures;
	
	private String distance;
	
	public void setDistance(String distance) {
		this.distance = distance;
	}
	
	public String getDistance() {
		return Integer.valueOf(this.distance).toString();
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
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
