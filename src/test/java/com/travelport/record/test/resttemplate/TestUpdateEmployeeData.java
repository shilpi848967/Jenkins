package com.travelport.record.test.resttemplate;



import java.text.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.travelport.record.test.parent.TestParent;

@RunWith(SpringRunner.class)

public class TestUpdateEmployeeData
{
	
	
	
	
	@Test
	public void testUpdateEmployeeDetail() throws ParseException, Exception
	{
TestParent testParent = new TestParent();
		
		RestTemplate restTemplate = testParent.callRestTemplate();
		
		testParent.headers.add("Accept", "application/json");
		testParent.headers.add("Content-Type", "application/json");
		
		String newData = "{\r\n" + 
				"        \"empId\": 105,\r\n" + 
				"        \"firstName\": \"Adil\",\r\n" + 
				"        \"lastName\": \"Kumar\",\r\n" + 
				"        \"dob\": \"2020-09-21T21:22:06.410+00:00\",\r\n" + 
				"        \"address\": \"Bangalore\",\r\n" + 
				"        \"degree\": \"B.Tech\"\r\n" + 
				"}";
		
		HttpEntity<String> entity = new HttpEntity<>(newData, testParent.headers);
		
		ResponseEntity<String> response = restTemplate.exchange(testParent.baseUrl + "/update", HttpMethod.PUT, entity, String.class);
		
		
		
		int code = response.getStatusCodeValue();
		Assert.assertEquals(code, 200);
		
		System.out.println(code);
		System.out.println(response.getBody());
		HttpEntity<String> getEntity = new HttpEntity<String>(null, testParent.headers);
		
		ResponseEntity<String> getResponse = restTemplate.exchange(testParent.baseUrl + "/record/105", HttpMethod.GET, getEntity, String.class);
		        	
		
		
		Assert.assertEquals(true, getResponse.getBody().contains("Adil"));
		Assert.assertEquals(true, getResponse.getBody().contains("firstName"));
		Assert.assertEquals(true, getResponse.getBody().contains("dob"));
		System.out.println(getResponse.getBody());

		
	}

	
	

	
}
