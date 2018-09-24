package training.busboard;

public class BusJSON {
	private String name;
	private BusJsonDepartures departures;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String ret = this.name;
		for (BusJsonBus bus : this.departures.getAll()) {
			ret += "\n\t" + bus;
		}
		return ret;
	}

	public void setDepartures(BusJsonDepartures departures) {
		this.departures = departures;
	}
}
