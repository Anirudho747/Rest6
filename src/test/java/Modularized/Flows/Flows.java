package Modularized.Flows;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class Flows {

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

    public void getWithoutParameters(String uri,String token, int responseCode,float responseTime,String responseText)
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = uri;

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // Add a header as key value
        httpRequest.header("Authorization", token);

        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");

        Assert.assertEquals(response.getStatusCode(),responseCode,"Code Mismatch");

        Assert.assertEquals(comparator(response.getTime(),responseTime),"lesser","Time Mismatch");

        Assert.assertEquals(response.prettyPrint().contains(responseText),true,"Text Not Found");


    }

    public void getWithParameters(String uri,String token,String param,int responseCode,float responseTime,String responseText)
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = uri;

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // Add a header as key value
        httpRequest.header("Authorization", token);

        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, param);

        Assert.assertEquals(response.getStatusCode(),responseCode,"Code Mismatch");

        Assert.assertEquals(comparator(response.getTime(),responseTime),"lesser","Time Mismatch");

        Assert.assertEquals(response.prettyPrint().contains(responseText),true,"Text Not Found");
    }

    public void postWithoutBody(String uri,String token,int responseCode,float responseTime,String responseText)
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI =uri;

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // Add a header as key value
        httpRequest.header("Authorization", token);

        // Post the request and check the response
        Response response = httpRequest.request(Method.POST);

        Assert.assertEquals(response.getStatusCode(),responseCode,"Code Mismatch");

        Assert.assertEquals(comparator(response.getTime(),responseTime),"lesser","Time Mismatch");

        Assert.assertEquals(response.prettyPrint().contains(responseText),true,"Text Not Found");
    }

    public void putWithoutBody(String uri,String token,int responseCode,float responseTime,String responseText)
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI =uri;

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // Add a header as key value
        httpRequest.header("Authorization", token);

        // Post the request and check the response
        Response response = httpRequest.request(Method.PUT);

        Assert.assertEquals(response.getStatusCode(),responseCode,"Code Mismatch");

        Assert.assertEquals(comparator(response.getTime(),responseTime),"lesser","Time Mismatch");

        Assert.assertEquals(response.prettyPrint().contains(responseText),true,"Text Not Found");
    }

    public void putWithBody(String uri,String token,int responseCode,float responseTime,String responseText)
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI =uri;

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // Add a header as key value
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("User-Agent", "PostmanRuntime/7.26.8");
        httpRequest.header("Connection", "keep-alive");
        httpRequest.header("Accept-Encoding", "gzip, deflate, br");
        httpRequest.header("Authorization", token);

        //Create a JSON Object
        JSONObject requestParams = new JSONObject();

        //Add Key-Value sets to the JSON Object
        requestParams.put("displayName", "some Amazing Name");
        requestParams.put("profileImage", "Link to the image");
        requestParams.put("Key", "Value");

        //Change Datatype of JSON Object
        httpRequest.body(requestParams.toJSONString());


        // Post the request and check the response
        Response response = httpRequest.request(Method.PUT);

        Assert.assertEquals(response.getStatusCode(),responseCode,"Code Mismatch");

        Assert.assertEquals(comparator(response.getTime(),responseTime),"lesser","Time Mismatch");

        Assert.assertEquals(response.prettyPrint().contains(responseText),true,"Text Not Found");
    }

    public void postWithBody(String uri,String devtoken,int responseCode,float responseTime,String responseText)
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI =uri;

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // Add a header as key value
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("User-Agent", "PostmanRuntime/7.26.8");
        httpRequest.header("Connection", "keep-alive");
        httpRequest.header("Accept-Encoding", "gzip, deflate, br");
        httpRequest.header("devicetoken", devtoken);

        //Create a JSON Object
        JSONObject requestParams = new JSONObject();

        //Add Key-Value sets to the JSON Object
        requestParams.put("date_of_birth", "1980-10-24");
        requestParams.put("mobile_number", "+91 8179779453");
        requestParams.put("referred_by", "7c99hbf5");

        //Change Datatype of JSON Object
        httpRequest.body(requestParams.toJSONString());


        // Post the request and check the response
        Response response = httpRequest.request(Method.POST);

        Assert.assertEquals(response.getStatusCode(),responseCode,"Code Mismatch");

        Assert.assertEquals(comparator(response.getTime(),responseTime),"lesser","Time Mismatch");

        Assert.assertEquals(response.prettyPrint().contains(responseText),true,"Text Not Found");
    }

    public void delete(String uri,String token,int responseCode,float responseTime,String responseText)
    {
       // Specify the base URL to the RESTful web service
        RestAssured.baseURI =uri;

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // Add a header as key value
        httpRequest.header("Authorization", token);

        // Post the request and check the response
        Response response = httpRequest.request(Method.DELETE);

        Assert.assertEquals(response.getStatusCode(),responseCode,"Code Mismatch");

        Assert.assertEquals(comparator(response.getTime(),responseTime),"lesser","Time Mismatch");

        Assert.assertEquals(response.prettyPrint().contains(responseText),true,"Text Not Found");
    }


}
