package com.travelport.record.test.resttemplate;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.travelport.record.test.parent.TestParent;


@RunWith(SpringRunner.class)
public class TestGetAllEmployeeData 
{
	
	
	
	@Test
	public void testGetEmployeeDetail() throws Exception
	{
		TestParent testParent = new TestParent();
		
		RestTemplate restTemplate = testParent.callRestTemplate();
		
		HttpEntity<String> entity = new HttpEntity<String>(null, testParent.headers);
	
		ResponseEntity<String> response = restTemplate.exchange(testParent.baseUrl + "/record", HttpMethod.GET, entity, String.class);
		        	
		
		int code = response.getStatusCodeValue();   
		Assert.assertEquals(code, 200);
		Assert.assertEquals(true, response.getBody().contains("firstName"));
		Assert.assertEquals(true, response.getBody().contains("lastName"));
		Assert.assertEquals(true, response.getBody().contains("dob"));
		Assert.assertEquals(true, response.getBody().contains("address"));
		Assert.assertEquals(true, response.getBody().contains("degree"));
		System.out.println(code);
		System.out.println(response.getBody());

	
	}

	

	
}
