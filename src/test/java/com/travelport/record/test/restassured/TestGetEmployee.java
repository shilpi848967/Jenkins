package com.travelport.record.test.restassured;

import org.junit.Assert;
import org.junit.Test;

import com.travelport.record.test.parent.TestParent;

import io.restassured.RestAssured;
import io.restassured.response.Response;

 



public class TestGetEmployee {
    
    @Test
    public void getAllEmployee()
    {
    	TestParent testParent = new TestParent();
        
        Response response = RestAssured.get(testParent.baseUrl + "/record/101");
        String data = response.getBody().asString();
        System.out.println(data);
        System.out.println(response.statusCode());
        System.out.println(response.getBody().asString());
        Assert.assertEquals(true, data.contains("firstName"));
		Assert.assertEquals(true, data.contains("lastName"));
		Assert.assertEquals(true, data.contains("dob"));
		Assert.assertEquals(true, data.contains("address"));
		Assert.assertEquals(true, data.contains("degree"));
            
    }
    
    

 

}