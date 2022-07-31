package weather.api.jpa.springbootstarter.weather;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	public String RequestParamDate = "date";
	
	public List<WeatherEntity> getWeather() {
		
		List<WeatherEntity> weatherAll = new ArrayList<>();
		weatherRepository.findAll().forEach(weatherAll::add);
		return weatherAll;
	}

	
	
	public WeatherEntity getWeatherID(String id) {
		
		WeatherEntity weatherEntityID = weatherRepository.findOne(Integer.parseInt(id));
			
		return weatherEntityID;
	}
	
	public boolean addWeatherEntity(WeatherEntity weatherObj) {
		
		boolean weatherIDCreated = false;
		/*
		 * Weather Data ID is Unique. If a new weather data is coming with existing weather ID, 
		 * do not add. 
		 */
		if(!weatherRepository.exists(weatherObj.getID())) {	
			//Save the location
			cityRepository.save(weatherObj.getLocation());
			//Save the weather
			weatherRepository.save(weatherObj);
			weatherIDCreated = true;
		}
		return weatherIDCreated;
	}

	public void eraseWeather() {
		/*
		 *  erase all the data.
		 */
		weatherRepository.deleteAll();
		
	}

	/*
	 * The method takes Date as input argument and returns the 
	 * (unsorted) weather data for the specified date. 
	 */
	public List<WeatherEntity> getDateWeathers(String date) {

		//Code to Verify the date. 
		LocalDate lDate = LocalDate.parse(date);
		List<WeatherEntity> weatherDate = new ArrayList<>();
		weatherRepository.findByDate(date).forEach(weatherDate::add);
		//List<WeatherEntity> sWeatherDate = sWeathers.stream().filter(w -> w.getDate().equals(lDate)).collect(Collectors.toList());
		return weatherDate;
	}

	/*
	 * The method returns the weather data collection, sorted in ascending order of Weather ID{dataID}
	 */
	public List<WeatherEntity> getsWeathersSorted() {
		
		List <WeatherEntity> sWeatherList= this.getWeather();
		sWeatherList.sort(Comparator.comparing(WeatherEntity::getID));
		return sWeatherList;
	}



	public List<WeatherEntity> getWeatherData(Map<String, String> weatherQuery) {

		List<WeatherEntity> weatherList;
		if(weatherQuery.containsKey(RequestParamDate)){
			weatherList = getDateWeathers(weatherQuery.get(RequestParamDate));
		}else {
			weatherList = getsWeathersSorted();
		}
		return weatherList;
	}

}
