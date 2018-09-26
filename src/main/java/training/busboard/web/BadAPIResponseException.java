package training.busboard.web;

public class BadAPIResponseException extends Exception {
	public String error;
	public String apiMessage;
	public String postcode;
	
	public BadAPIResponseException(String error, String apiresponsemessage) {
		this.error = error;
		this.apiMessage = apiresponsemessage;
	}
}
