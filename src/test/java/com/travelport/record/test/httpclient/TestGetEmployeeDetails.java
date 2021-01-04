package com.travelport.record.test.httpclient;



import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.record.test.parent.TestParent;


@RunWith(SpringRunner.class)

public class TestGetEmployeeDetails
{
	@Test
	public void getAllEmployee() throws Exception
	{
		TestParent testParent = new TestParent();
		
		CloseableHttpClient client = testParent.callHttpClient();
		HttpGet request = new HttpGet(testParent.baseUrl + "/record/101");
		
		request.addHeader("Content-Type" , "application/json");
		
		CloseableHttpResponse response = client.execute(request);
		
		
		int code = response.getStatusLine().getStatusCode();
		System.out.println("Response code" + code);
		Assert.assertEquals(200,  code);
		
		String responseString = EntityUtils.toString(response.getEntity());
		System.out.println(responseString);
		
		Assert.assertEquals(true, responseString.contains("firstName"));
		Assert.assertEquals(true, responseString.contains("lastName"));
		Assert.assertEquals(true, responseString.contains("dob"));
		Assert.assertEquals(true, responseString.contains("address"));
		Assert.assertEquals(true, responseString.contains("degree"));

	
	}
	
}
