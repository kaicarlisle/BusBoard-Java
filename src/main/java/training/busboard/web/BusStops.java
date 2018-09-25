package training.busboard.web;

import java.util.ArrayList;

public class BusStops {
	private ArrayList<BusStop> member;
	
	public void setMember(BusStop busStop) {
		member.add(busStop);
	}
	
	public String getATCO(Integer index) {
		return member.get(index).getAtcocode();
	}
	
	public ArrayList<BusStop> getStops() {
		return this.member;
	}
	
	public class BusStop {
		private String atcocode;
		private Float distance;

		public String getAtcocode() {
			return atcocode;
		}
		
		public void setAtcocode(String atco) {
			this.atcocode = atco;
		}
		
		public void setDistance(Float distance) {
			this.distance = distance;
		}
		
		public Float getDistance() {
			return this.distance;
		}
	}
}
