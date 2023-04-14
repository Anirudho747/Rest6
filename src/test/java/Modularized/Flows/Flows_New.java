package Modularized.Flows;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class Flows_New {

    public String comparator(float actualTime,float expectedTime)
    {
        if(actualTime<=expectedTime)
        {
            return "lesser";
        }
        else
        {
            return "greater";
        }
    }

    public void provideURI(String uri,RequestSpecification httpRequest)
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = uri;

        // Get the RequestSpecification of the request to be sent to the server.
         httpRequest = RestAssured.given();
    }

    public void assertions(Response response1, int responseCode,float responseTime,String responseText)
    {
        Assert.assertEquals(response1.getStatusCode(),responseCode,"Code Mismatch");

        Assert.assertEquals(comparator(response1.getTime(),responseTime),"lesser","Time Mismatch");

        Assert.assertEquals(response1.prettyPrint().contains(responseText),true,"Text Not Found");
    }

}
