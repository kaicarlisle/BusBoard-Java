package training.busboard;

public class BusStopTimetable {
	private String name;
	private BusDepartures departures;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String ret = this.name;
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
}
