package training.busboard;

import java.util.ArrayList;

public class BusJsonDepartures {
	private ArrayList<BusJsonBus> all;
	
	public void setAll(BusJsonBus bus) {
		this.all.add(bus);
	}

	public ArrayList<BusJsonBus> getAll() {
		return this.all;
	}
}
