package training.busboard.web;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ApiHandler {
	
//	private final String app_id = "2e66d564";
//	private final String app_key = "c30acca6ae1ea945a9855d194b2c2b1f";
//	private final String app_id = "dbc94df4";
//	private final String app_key = "a876bfc7ec7950d303969fa493b9ba6d";
	private final String app_id = "98496a88";
	private final String app_key = "358b514a641897ec2e1933b73df320b8";
	
	private	Client client;
	private String URL;
	
	private Gson gson;
	WebTarget target;
	Invocation.Builder invocationBuilder;
	Invocation getRequestInvocation;
	Response response;
	int responseStatus;
	
	public ApiHandler() {
		this.client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
		this.gson = new GsonBuilder().create();
	}
	
	public LatLongResults makeRequestLatLonFromPostcode(String postcode) throws BadAPIResponseException {
		this.URL = "http://api.postcodes.io/postcodes/"+postcode;
		makeRequest();
		LatLongResults results = this.gson.fromJson(this.response.readEntity(String.class), LatLongResults.class);
		if (this.responseStatus != 200 || results == null) {
			throw new BadAPIResponseException("Bad postcode");
		}
		return results;
	}
	
	public BusStops makeRequestATCOFromLatLon(String lat, String lon) throws BadAPIResponseException {
		this.URL = "http://transportapi.com/v3/uk/places.json?lat="+lat+"&lon="+lon+"&type=bus_stop&app_id="+app_id+"&app_key="+app_key;
		makeRequest();
		BusStops results = this.gson.fromJson(this.response.readEntity(String.class), BusStops.class);
		if (this.responseStatus != 200 || results == null) {
			throw new BadAPIResponseException("No bus stops found");
		}
		return results;
	}
	
	public BusStopTimetable makeRequestBusStopTimetableFromATCO(String ATCO) throws BadAPIResponseException {
		this.URL = "https://transportapi.com/v3/uk/bus/stop/"+ATCO+"/live.json?group=no&limit=5&nextbuses=yes&app_id="+app_id+"&app_key="+app_key;
		makeRequest();
		BusStopTimetable results = this.gson.fromJson(this.response.readEntity(String.class), BusStopTimetable.class);
		if (this.responseStatus != 200 || results.getDepartures().getAll() == null) {
			throw new BadAPIResponseException("No buses timetabled");
		}
		return results;
	}
	
	private void makeRequest() {
		this.target = this.client.target(this.URL);
		this.invocationBuilder = this.target.request(MediaType.APPLICATION_JSON);
		this.getRequestInvocation = this.invocationBuilder.buildGet();
		this.response = this.getRequestInvocation.invoke();
		this.responseStatus = this.response.getStatus();
	}
}
