package training.busboard;

public class Postcode {
	
	private PostcodeDetails result;
	
	public void setResult(PostcodeDetails details) {
		this.result = details;
	}
	
	public double getLat() {
		return result.getLatitude();
	}
	
	public double getLon() {
		return result.getLongitude();
	}
}
