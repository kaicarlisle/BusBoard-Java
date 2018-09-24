package training.busboard;

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
