package weather.api.jpa.springbootstarter.weather;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	
	
	@RequestMapping("/weather")
	public List<WeatherEntity> getWeather(@RequestParam Map<String,String> weatherQuery) {
		
		return  weatherService.getWeatherData(weatherQuery);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/weather")
	public ResponseEntity<Object> addWeatherCity(@RequestBody WeatherEntity weatherObj) {
		
		HttpStatus httpStatusResponse;
		boolean weatherDataCreated = weatherService.addWeatherEntity(weatherObj);
		
		if (weatherDataCreated)
			httpStatusResponse = HttpStatus.CREATED;
		else
			httpStatusResponse = HttpStatus.BAD_REQUEST;
	
		return new ResponseEntity<Object>(httpStatusResponse);
	
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/erase")
	public void eraseWeather() {
			weatherService.eraseWeather();
	}

}
