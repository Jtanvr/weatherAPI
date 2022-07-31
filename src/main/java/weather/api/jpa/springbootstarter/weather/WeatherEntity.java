package weather.api.jpa.springbootstarter.weather;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class WeatherEntity {
	@Id
	private int id;
	private String date;
	@ManyToOne
	private CityEntity location;

	private float[] temperature = new float[24];
	
	public WeatherEntity() {
		
	}
	public WeatherEntity(int wID,String wDate, CityEntity wLocation, float[] wTempArray) {
		super();
		this.id = wID;
		this.date= wDate;
		this.location=wLocation;
		this.temperature = wTempArray;
	}
	public int getID() {
		return id;
	}
	public void setID(int dataID) {
		this.id = dataID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String wDate) {
		this.date = wDate;
	}
	public CityEntity getLocation() {
		return location;
	}
	public void setLocation(CityEntity wLocation) {
		this.location = wLocation;
	}
	
	public float[] getTemperature() {
		return temperature;
	}
	public void setTemperature(float[] temperature) {
		this.temperature = temperature;
	}
	

}
