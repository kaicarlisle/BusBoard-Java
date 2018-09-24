package training.busboard;

public class LatLongResults {
	
	private LatLong result;
	
	public void setResult(LatLong details) {
		this.result = details;
	}
	
	public double getLat() {
		return result.getLatitude();
	}
	
	public double getLon() {
		return result.getLongitude();
	}
}
