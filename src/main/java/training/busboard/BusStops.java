package training.busboard;

public class BusStops {
	private String source;
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getATCO(Integer index) {
		return "0180BAC30592";
	}
	
	@Override
	public String toString() {
		return this.source;
	}
}
