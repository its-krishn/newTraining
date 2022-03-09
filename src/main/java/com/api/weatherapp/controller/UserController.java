package com.api.weatherapp.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.api.weatherapp.dao.UserDao;
import com.api.weatherapp.model.UserData;

@RestController
public class UserController {
	private final RestTemplate restTemplate = new RestTemplateBuilder().build();
	private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apikey}";

	private String apiKey = "8b526e1c3254597357144184ad645355";
	
	private UserDao userDao;
	
	@Autowired
	public UserController(UserDao userDao) {
			super();
			this.userDao =userDao;}
			
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@DeleteMapping("/deleteUser/{email}")
	public String deleteUser(@PathVariable("email") String email) {
	userDao.deleteById(email);
	return "user is deleted";
	}
	
	@PutMapping("/updateUser/{email}")
	public UserData updateUser(@PathVariable("email") String email,@RequestBody UserData user) {
		userDao.deleteById(email);
		UserData result = new UserData();
		result = userDao.save(user);
		return result;
	}

	@PostMapping("/saveUser")
	public UserData saveUser(@RequestBody UserData user) {
		UserData result = new UserData();
	    result= userDao.save(user);
		return result;

	}

	@GetMapping("/current-weather/{city}")
	public ResponseEntity<String> getWeather(@PathVariable("city") String city) {
		return getCurrentWeather(city);
	}

	public ResponseEntity<String> getCurrentWeather(String city) {
		URI url = new UriTemplate(WEATHER_URL).expand(city,apiKey);
		return restTemplate.getForEntity(url, String.class);
	}
}