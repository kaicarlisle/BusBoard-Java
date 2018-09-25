package training.busboard.web;

import java.util.ArrayList;

public class BusStopTimetable {
	private String name;
	private BusDepartures departures;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String display(String distance) {
		String ret = this.name + " - " + distance + "m away";
		ret += "\n\t" + Bus.headerString();
		for (Bus bus : this.departures.getAll()) {
			ret += "\n\t" + bus;
		}
		ret += "\n";
		return ret;
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
