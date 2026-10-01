package com.soniya.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.soniya.bean.Customer;
import com.soniya.bean.Driver;

@Service
public class DriverService {
	@Value("${rest_webservice_url}")
	private String url;
	
	private RestTemplate restTemplate=new RestTemplate();

	public boolean register(Driver driver) {
		String api="/driver/register";
		HttpEntity<Driver> requestEntity=new HttpEntity<Driver>(driver);
		ResponseEntity<Boolean> result=restTemplate.exchange(url+api,HttpMethod.POST,requestEntity,Boolean.class);
		return result.getBody();
	}

	public Driver findByEmail(String email) {
		String api="/driver/findByEmail/"+email;
		ResponseEntity<Driver> result=restTemplate.exchange(url+api,HttpMethod.GET,null,Driver.class);
		return result.getBody();
	}
	
}
