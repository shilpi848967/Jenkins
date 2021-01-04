package com.travelport.record.test.httpclient;

import java.io.IOException;
import java.text.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.record.test.parent.TestParent;

@RunWith(SpringRunner.class)

public class TestUpdateEmployeeDetails {
	
	@Test
	public void update() throws ParseException, ClientProtocolException, IOException
	{
		
		TestParent testParent = new TestParent();
		CloseableHttpClient client = testParent.callHttpClient();
		
		HttpPut put = new HttpPut(testParent.baseUrl + "/update");
		
		String newData = "{\r\n" + 
				"        \"empId\": 105,\r\n" + 
				"        \"firstName\": \"Adil\",\r\n" + 
				"        \"lastName\": \"Kumar\",\r\n" + 
				"        \"dob\": \"2020-09-21T21:22:06.410+00:00\",\r\n" + 
				"        \"address\": \"Bangalore\",\r\n" + 
				"        \"degree\": \"B.Tech\"\r\n" + 
				"}";
		
		put.setHeader("Accept", "application/json");
	    put.setHeader("Content-type", "application/json");	
	    
		StringEntity entity = new StringEntity(newData);
		put.setEntity(entity);
		System.out.println("Executing request " + put.getRequestLine());
		
		CloseableHttpResponse response = client.execute(put);

	    
	    int code = response.getStatusLine().getStatusCode();
		System.out.println("Response code" + code);
		
		String responseString = EntityUtils.toString(response.getEntity());
		Assert.assertEquals(true, responseString.contentEquals(""));
		

	}
}
