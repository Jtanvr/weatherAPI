package weather.api.jpa.springbootstarter.weather;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CityEntity {
	private float lat;
	private float lon;
	@Id
	private String city;
	private String state;
	
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public CityEntity() {
		
	}
	public CityEntity(float aLat,float aLon,String aCity,String aState) {
		this.setLat(aLat);
		this.setLon(aLon);
		this.setCity(aCity);
		this.setState(aState);
	}

}
