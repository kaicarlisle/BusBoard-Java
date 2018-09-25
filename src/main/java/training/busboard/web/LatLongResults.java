package training.busboard.web;

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
	
	public class LatLong {
		private double longitude;
		private double latitude;
		
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		
		public double getLatitude() {
			return this.latitude;
		}
		
		public double getLongitude() {
			return this.longitude;
		}
	}
}
