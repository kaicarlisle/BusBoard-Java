package training.busboard;

import java.util.ArrayList;

public class BusStops {
	private ArrayList<BusStop> member;
	
	public String getATCO(Integer index) {
		return member.get(index).getAtcocode();
	}
	
	public ArrayList<BusStop> getStops() {
		return this.member;
	}
}
