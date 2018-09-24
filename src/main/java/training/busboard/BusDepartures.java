package training.busboard;

import java.util.ArrayList;

public class BusDepartures {
	private ArrayList<Bus> all;
	
	public void setAll(Bus bus) {
		this.all.add(bus);
	}

	public ArrayList<Bus> getAll() {
		return this.all;
	}
}
