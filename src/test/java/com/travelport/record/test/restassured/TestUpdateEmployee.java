package com.travelport.record.test.restassured;

import org.junit.Test;

import com.travelport.record.test.parent.TestParent;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import java.io.File;

import io.restassured.response.Response;

import io.restassured.http.ContentType;

public class TestUpdateEmployee {
    
    
    
    @Test
    public void updateEmployee() 
    {
    	TestParent testParent = new TestParent();
        
        RestAssured.baseURI = testParent.baseUrl;
        
        File json = new File("data/updateData.txt");
        
        Response response = given().contentType(ContentType.JSON).log().all().body(json)
                .put("/update");
        response.prettyPrint();
        
    }

 

}
 