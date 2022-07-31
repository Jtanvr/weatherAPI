package weather.api.jpa.springbootstarter.weather;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface WeatherRepository extends CrudRepository<WeatherEntity,Integer> {
	public List<WeatherEntity> findByDate(String date);

}
