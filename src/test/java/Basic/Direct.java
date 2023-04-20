package Basic;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Direct {

    private String URI = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/";
    private String deviceToken = "fv1_9EtgcUGYgBxyWm4jCi:APA91bGgcPClIiTLBuAHBvO5KePxO0GIzIPNBCXhtaXO3B0xEgkOS-LylRlem933cd4OKRAYMH_Xc8UesND-hKdjW257umpXy3_53E7UCM73w6UnVDbNHb42zCV2xQvg4D3877V2R1S6 ";
    private String userToken = "Bearer "+"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpZCI6NzQ5LCJtb2JpbGVfbnVtYmVyIjoiKzkxIDgwMDAwMDAwNzAiLCJpYXQiOjE2ODE0ODQyMTZ9.woPowT66EMyBbs3BchAqLKC9I-ejEDDj8dkPRHuEaPQTb5-VTJNBvYSRS2Ar_25f9obb5iKirNxqucaAALPJ-A";
    private String eventURI = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/admin/events/";
    private String authorization="Bearer "+"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidHlwZSI6MSwiZW1haWwiOiJhZG1pbi1kYXNoQGZhbmFtcC5jbyIsImV4cCI6MTY4MjQ5ODAwMSwiaWF0IjoxNjc5OTA2MDAxfQ.kTWnlbvSRSjsQtZc3YxGkofKKkjosJUK9w3W13ddrdQXWq7p9GbgkyppaEIvlZmWomJuQc6Ed38-rTWfD2qF_w";
    
    @Test(enabled=false)
    public void get_UserDetail()
    {

        // We are telling that the request does not have the port # as 8080 and host as local host in first sentence, then we give the actual host
        RequestSpecification httpRequest = RestAssured
                                           .given()
                                           .baseUri(URI)
                                           .basePath("user-detail?userId=1");

        // Add a header as key value
        httpRequest.header("Authorization",userToken);

        Response response = httpRequest.request(Method.GET,"");

        Assert.assertEquals(response.getStatusCode(),200,"Code Mismatch");

        Assert.assertEquals(response.prettyPrint().contains("Success"),true,"Text Not Found");

    }

    @Test(enabled=false)
    public void get_UserDetail_withParam()
    {

        // We are telling that the request does not have the port # as 8080 and host as local host in first sentence, then we give the actual host
        RequestSpecification httpRequest = RestAssured
                .given()
                .baseUri(URI)
                .basePath("user-detail");

        // Add a header as key value
        httpRequest.header("Authorization",userToken);

        Response response = httpRequest.request(Method.GET,"?userId=1");

        Assert.assertEquals(response.getStatusCode(),200,"Code Mismatch");

        Assert.assertEquals(response.prettyPrint().contains("Success"),true,"Text Not Found");

    }

    @Test(enabled=false)
    public void post_CreateUser_withParam()
    {
        RequestSpecification httpRequest = RestAssured
                                           .given()
                                           .baseUri(URI)
                                           .basePath("users");
        // Add headers as key value
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("User-Agent", "PostmanRuntime/7.26.8");
        httpRequest.header("Connection", "keep-alive");
        httpRequest.header("Accept-Encoding", "gzip, deflate, br");
        httpRequest.header("devicetoken", deviceToken);

        //Create a JSON Object
        JSONObject requestParams = new JSONObject();

        //Add Key-Value sets to the JSON Object
        requestParams.put("date_of_birth", "1980-10-24");
        requestParams.put("mobile_number", "+91 8139779453");
        requestParams.put("referred_by", "7c99hbf5");

        //Change Datatype of JSON Object
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST);

        Assert.assertEquals(response.getStatusCode(),201,"Code Mismatch");

        Assert.assertEquals(response.prettyPrint().contains("User created successfully."),true,"Text not present");

    }


    @Test(enabled=true)
    public void put_updateGroupDetails_withParam()
    {
            RequestSpecification httpRequest = RestAssured
                                               .given()
                                               .baseUri(URI)
                                               .basePath("groups/1/details");

        // Add headers as key value
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("User-Agent", "PostmanRuntime/7.26.8");
        httpRequest.header("Connection", "keep-alive");
        httpRequest.header("Accept-Encoding", "gzip, deflate, br");
        httpRequest.header("Authorization", userToken);

        JSONObject requestParams = new JSONObject();

        //Add Key-Value sets to the JSON Object
        requestParams.put("displayName", "some Amazing Name");
        requestParams.put("profileImage", "Link to the image");

        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.PUT);

        Assert.assertEquals(response.getStatusCode(),201,"Code Mismatch");

        Assert.assertEquals(response.prettyPrint().contains("User created successfully."),true,"Text not present");
    }
    
    @Test(enabled=false)
    public void put_CreateUser_withComplexParam()
    {
        RequestSpecification httpRequest = RestAssured
                                           .given()
                                           .baseUri(eventURI)
                                           .basePath("1049/gamification/questions/1172/answer/");
        // Add headers as key value
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("User-Agent", "PostmanRuntime/7.26.8");
        httpRequest.header("Connection", "keep-alive");
        httpRequest.header("Accept-Encoding", "gzip, deflate, br");
        httpRequest.header("Authorization", authorization);

        //Create a JSON String for parameters
        String jsonString = 
        		"{\r\n" + 
        		" \"questionTemplateId\" : 7,\r\n” +
        		" \"correctAnswer\" : {\r\n”+
        		" \”answer\” : [ \r\n” +
        		" { \r\n" +
        		" \"optionNumber\" :\”2\”,\r\n”+
        		" \”optionText\” : \”Opt2\”,\r\n” +
        		" }\r\n”+
                " ]\r\n” +
                " }\r\n” +
        		"}";

        //Add Key-Value sets to the JSON Object
        requestParams.put("date_of_birth", "1980-10-24");
        requestParams.put("mobile_number", "+91 8139779453");
        requestParams.put("referred_by", "7c99hbf5");

        //Add parameters saved in form of Json String
        httpRequest.body(jsonString());

        Response response = httpRequest.request(Method.POST);

        Assert.assertEquals(response.getStatusCode(),201,"Code Mismatch");

        Assert.assertEquals(response.prettyPrint().contains("User created successfully."),true,"Text not present");

    }

    @Test
    public void delete_removeUser()
    {
        RequestSpecification httpRequest = RestAssured
                .given()
                .baseUri(URI)
                .basePath("remove-account");

        // Add a header as key value
        httpRequest.header("Authorization", userToken);

        // Post the request and check the response
        Response response = httpRequest.request(Method.DELETE);

        Assert.assertEquals(response.getStatusCode(),200,"Code Mismatch");

        Assert.assertEquals(response.prettyPrint().contains("Account deleted successfully."),true,"Text not present");

    }

}



/*


http://makeseleniumeasy.com/2019/12/02/rest-assured-tutorial-10-lets-write-first-put-request-in-rest-assured/ 

{
    "firstname" : "Amod",
    "lastname" : "Mahajan",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}


String jsonString = 
"{\r\n" + 
"\"firstname\" : \"Amod\",\r\n" +
"\"lastname\" : \"Mahajan\",\r\n"+
"\"totalprice\" : 111,\r\n" +
"\"depositpaid\" : true,\r\n" +
"\"bookingdates\" : {\r\n"+
"\"checkin\" : \"2018-01-01\",\r\n" +
"\"checkout\" : \"2019-01-01\"\r\n"+
 "},\r\n" +
 "\"additionalneeds\" : \"Breakfast\"\r\n" +
"}";


*/