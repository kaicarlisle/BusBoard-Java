package training.busboard.web;

public class BadAPIResponseException extends Exception {
	public String error;
	
	public BadAPIResponseException(String error) {
		this.error = error;
	}
}
