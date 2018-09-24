package training.busboard;

public class Bus {
	private String line_name;
	private String best_departure_estimate;
	private String direction;
	
	public void setLine_Name(String line_name) {
		this.line_name = line_name;
	}

	public void setBest_departure_estimate(String best_departure_estimate) {
		this.best_departure_estimate = best_departure_estimate;
	}

	public String getDirection() {
		return direction;
	}
	
	public static String headerString() {
		return "Time\tLine\tDestination\n\t---------------------------------------";
	}
	
	@Override
	public String toString() {
		return this.best_departure_estimate + "\t" + this.line_name + "\t" + this.direction;
	}
}
