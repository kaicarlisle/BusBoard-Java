package training.busboard.web;

public class Bus {
	public String line_name;
	public String best_departure_estimate;
	public String direction;
	
	public void setLine_Name(String line_name) {
		this.line_name = line_name;
	}

	public void setBest_departure_estimate(String best_departure_estimate) {
		this.best_departure_estimate = best_departure_estimate;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public String getDirection() {
		return this.direction;
	}
	
	public String getLine_Name() {
		return this.line_name;
	}
	
	public String getBest_Departure_Estimate() {
		return this.best_departure_estimate;
	}
}
