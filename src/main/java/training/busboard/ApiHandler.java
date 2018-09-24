package training.busboard;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//given an ATCO code, makes API get request, and handles returned JSON of buses
//returns JSON for each bus
public class ApiHandler {
	
	private	Client client;
	private String URL;
	
	private Gson gson;
	WebTarget target;
	Invocation.Builder invocationBuilder;
	Invocation getRequestInvocation;
	Response response;
	
	public ApiHandler() {
		this.client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
		this.gson = new GsonBuilder().create();
	}
	
	public Postcode makeRequestLatLonFromPostcode(String postcode) {
		this.URL = "http://api.postcodes.io/postcodes/"+postcode;
		
		this.target = this.client.target(this.URL);
		
		this.invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		this.getRequestInvocation = this.invocationBuilder.buildGet();
		this.response = this.getRequestInvocation.invoke();
		return this.gson.fromJson(this.response.readEntity(String.class), Postcode.class);
	}
	
	public BusStops makeRequestATCOFromLatLon(String lat, String lon) {
		this.URL = "http://transportapi.com/v3/uk/places.json?lat="+lat+"&lon="+lon+"&type=bus_stop&app_id=2e66d564&app_key=c30acca6ae1ea945a9855d194b2c2b1f";
		
		this.target = this.client.target(this.URL);
		
		this.invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		this.getRequestInvocation = this.invocationBuilder.buildGet();
		this.response = this.getRequestInvocation.invoke();
		return this.gson.fromJson(this.response.readEntity(String.class), BusStops.class);
	}
	
	public BusJSON makeRequestBusFromATCO(String ATCO) {
		this.URL = "https://transportapi.com/v3/uk/bus/stop/"+ATCO+"/live.json?app_id=2e66d564&app_key=c30acca6ae1ea945a9855d194b2c2b1f&group=no&limit=5&nextbuses=yes";
		
		this.target = this.client.target(this.URL);
		
		this.invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		this.getRequestInvocation = this.invocationBuilder.buildGet();
		this.response = this.getRequestInvocation.invoke();
		return this.gson.fromJson(this.response.readEntity(String.class), BusJSON.class);
	}
}
