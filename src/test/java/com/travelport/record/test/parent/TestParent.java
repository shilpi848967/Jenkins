package com.travelport.record.test.parent;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class TestParent {

	public static final String baseUrl = "http://localhost:8080/employee";
	
	public static final HttpHeaders headers = new HttpHeaders();

	public CloseableHttpClient callHttpClient() throws ClientProtocolException, IOException {
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		return client;
	}
	
	
	
	public RestTemplate callRestTemplate()
	{
		RestTemplate restTemplate = new RestTemplate();

		
		return restTemplate;
	}

	

	
	


}
 