package com.travelport.record.test.resttemplate;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.travelport.record.test.parent.TestParent;


@RunWith(SpringRunner.class)
public class TestGetEmployeeData
{
	

	@Test
	public void testGetEmployeeDetail() throws Exception
	{
TestParent testParent = new TestParent();
		
		RestTemplate restTemplate = testParent.callRestTemplate();
		
		HttpEntity<String> entity = new HttpEntity<String>(null, testParent.headers);
		
		ResponseEntity<String> response = restTemplate.exchange(testParent.baseUrl + "/record/101", HttpMethod.GET, entity, String.class);
		        	
		Object expected = "{\"empId\":101,\"firstName\":\"Ajay\",\"lastName\":\"Kumar\",\"dob\":\"1995-12-11T18:30:00.000+00:00\",\"address\":\"Kolkata\",\"degree\":\"B.Tech\"}";
		
		int code = response.getStatusCodeValue();
		Assert.assertEquals(code, 200);
		Assert.assertEquals(expected, response.getBody());
		
		System.out.println(response.getBody());

		System.out.println(code);

	}

	
	

	
}
