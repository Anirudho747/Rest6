package Modularized.TestCases;



import Modularized.Flows.Flows_New;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class AllIn1_New {


    Flows_New flows_new  = new Flows_New();
    RequestSpecification httpRequest = RestAssured.given();

    private String params = "?page=1&q=dore&per_page=400";
    private String URI = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/user-detail";
    private String URI2 = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/users";
    private String URI3 = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/remove-account";
    private String token = "Bearer "+"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpZCI6Mjk0LCJtb2JpbGVfbnVtYmVyIjoiKzkxIDc1NTAxMzQ3NDAiLCJpYXQiOjE2Njk2OTg1NjN9.MESyV2vU88q432Jq2bRF5ZsAi_gHzDA0OwVJ4VPok1-A9n2Vs3iKJsOCTSNRi0HXhNOIX7i1eLKM-u6Bcw8KWg";
    private String deviceToken = "fv1_9EtgcUGYgBxyWm4jCi:APA91bGgcPClIiTLBuAHBvO5KePxO0GIzIPNBCXhtaXO3B0xEgkOS-LylRlem933cd4OKRAYMH_Xc8UesND-hKdjW257umpXy3_53E7UCM73w6UnVDbNHb42zCV2xQvg4D3877V2R1S6 ";


    @Test
    public void get_fetchUserDetail()
    {
        flows_new.provideURI(URI,httpRequest);
        httpRequest.header("Authorization", token);
        Response response = httpRequest.request(Method.GET, "");
        flows_new.assertions(response,200, 9000.00F,"Success");
    }

    @Test
    public void getWithParams_fetchUserList()
    {
        flows_new.provideURI(URI,httpRequest);
        httpRequest.header("Authorization", token);
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("User-Agent", "PostmanRuntime/7.26.8");
        httpRequest.header("Connection", "keep-alive");
        Response response = httpRequest.request(Method.GET, params);
        flows_new.assertions(response,200, 9000.00F,"Success");
    }

    @Test
    public void post_blockUser()
    {
        flows_new.provideURI(URI,httpRequest);
        httpRequest.header("Authorization", token);
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("User-Agent", "PostmanRuntime/7.26.8");
        httpRequest.header("Connection", "keep-alive");
        Response response = httpRequest.request(Method.POST);
        flows_new.assertions(response,200, 9000.00F,"Success");
    }

    @Test
    public void postWithBody_registerUser()
    {
        flows_new.provideURI(URI,httpRequest);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("User-Agent", "PostmanRuntime/7.26.8");
        httpRequest.header("Connection", "keep-alive");
        httpRequest.header("Accept-Encoding", "gzip, deflate, br");
        httpRequest.header("devicetoken", deviceToken);

        //Create a JSON Object
        JSONObject requestParams = new JSONObject();
        //Add Key-Value sets to the JSON Object
        requestParams.put("date_of_birth", "1980-10-24");
        requestParams.put("mobile_number", "+91 8179779453");
        requestParams.put("referred_by", "7c99hbf5");
        //Change Datatype of JSON Object
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST);

        flows_new.assertions(response,200, 9000.00F,"User created successfully.");

    }

    @Test
    public void put_updateGroupDetails()
    {
        flows_new.provideURI(URI,httpRequest);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("User-Agent", "PostmanRuntime/7.26.8");
        httpRequest.header("Connection", "keep-alive");
        httpRequest.header("Accept-Encoding", "gzip, deflate, br");
        httpRequest.header("devicetoken", deviceToken);

        //Create a JSON Object
        JSONObject requestParams = new JSONObject();
        //Add Key-Value sets to the JSON Object
        requestParams.put("date_of_birth", "1980-10-24");
        requestParams.put("mobile_number", "+91 8179779453");
        requestParams.put("referred_by", "7c99hbf5");
        //Change Datatype of JSON Object
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.PUT);

        flows_new.assertions(response,200, 9000.00F,"User created successfully.");

    }

    @Test
    public void delete_removeUser()
    {
        flows_new.provideURI(URI,httpRequest);
        httpRequest.header("Authorization", token);
        Response response = httpRequest.request(Method.DELETE);
        flows_new.assertions(response,200, 9000.00F,"Account deleted successfully.");
    }


}
