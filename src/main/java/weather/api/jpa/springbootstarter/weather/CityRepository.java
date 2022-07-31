package weather.api.jpa.springbootstarter.weather;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface CityRepository extends CrudRepository<CityEntity, String> {

}
