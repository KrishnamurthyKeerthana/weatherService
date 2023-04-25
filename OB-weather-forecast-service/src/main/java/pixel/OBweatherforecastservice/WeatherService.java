package pixel.OBweatherforecastservice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String API_KEY = "8cae42534261f435988da8cfa9a83d49";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    private RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherForecast getWeatherForecast(String location) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY + "&units=imperial";
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        return new WeatherForecast(response.getMain().getTemp(), response.getMain().getHumidity(), response.getWind().getSpeed());
    }
}
