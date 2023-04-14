package Modularized.TestCases;

import FA.flows.Flows_New;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Login_Logout_Cycle {

    Flows_New flows_new  = new Flows_New();
    RequestSpecification httpRequest = RestAssured.given();

    private String createUserURI = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/users";
    private String logOffURI = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/logout";
    private String deleteURI = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/remove-account";
    private String fetchUserURI = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/users";
    private String createProfileURI = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/user-profile";
    private String profileImageURI = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/profile-image";
    private String deviceToken = "fv1_9EtgcUGYgBxyWm4jCi:APA91bGgcPClIiTLBuAHBvO5KePxO0GIzIPNBCXhtaXO3B0xEgkOS-LylRlem933cd4OKRAYMH_Xc8UesND-hKdjW257umpXy3_53E7UCM73w6UnVDbNHb42zCV2xQvg4D3877V2R1S6 ";
    private String token = "Bearer "+"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpZCI6Mjk0LCJtb2JpbGVfbnVtYmVyIjoiKzkxIDc1NTAxMzQ3NDAiLCJpYXQiOjE2Njk2OTg1NjN9.MESyV2vU88q432Jq2bRF5ZsAi_gHzDA0OwVJ4VPok1-A9n2Vs3iKJsOCTSNRi0HXhNOIX7i1eLKM-u6Bcw8KWg";


    @Test
    public void mobileUser_Creation_LogOff_LogIn_Deletion()
    {
        post_NewUserCreation();
        post_ProfileCreation();
        post_ProfileImage();
        get_fetchUserDetail();
        post_logOff();
        delete_RemoveAccount();
    }

    public void post_NewUserCreation()
    {
        flows_new.provideURI(createUserURI,httpRequest);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("User-Agent", "PostmanRuntime/7.26.8");
        httpRequest.header("Connection", "keep-alive");
        httpRequest.header("Accept-Encoding", "gzip, deflate, br");
        httpRequest.header("devicetoken", deviceToken);

        //Create a JSON Object
        JSONObject requestParams = new JSONObject();
        //Add Key-Value sets to the JSON Object
        requestParams.put("date_of_birth", "1980-10-24");
        requestParams.put("mobile_number", "+91 8109779453");
        requestParams.put("referred_by", "7c99hbf5");
        //Change Datatype of JSON Object
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST);

        flows_new.assertions(response,200, 9000.00F,"User created successfully.");

    }

    public void post_ProfileCreation()
    {
        flows_new.provideURI(createProfileURI,httpRequest);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("User-Agent", "PostmanRuntime/7.26.8");
        httpRequest.header("Connection", "keep-alive");
        httpRequest.header("Accept-Encoding", "gzip, deflate, br");
        httpRequest.header("Authorization", token);

        //Create a JSON Object
        JSONObject requestParams = new JSONObject();
        //Add Key-Value sets to the JSON Object
        requestParams.put("name", "Tom Clancy");
        requestParams.put("date_of_birth", "2000-07-21");
        requestParams.put("gender", "male");
        requestParams.put("username", "Randomuser");
        requestParams.put("about_me", "This is Test User");
        //Change Datatype of JSON Object
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST);

        flows_new.assertions(response,200, 9000.00F,"User profile updated successfully.");

    }

    public void post_ProfileImage()
    {
        flows_new.provideURI(profileImageURI,httpRequest);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("User-Agent", "PostmanRuntime/7.26.8");
        httpRequest.header("Connection", "keep-alive");
        httpRequest.header("Accept-Encoding", "gzip, deflate, br");
        httpRequest.header("Authorization", token);

        //Create a JSON Object
        JSONObject requestParams = new JSONObject();
        //Add Key-Value sets to the JSON Object
        requestParams.put("userProfileImage", "Photo Location");

        //Change Datatype of JSON Object
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST);

        flows_new.assertions(response,200, 9000.00F,"Profile Photo updated successfully.");
    }

    public void get_fetchUserDetail()
    {
        flows_new.provideURI(fetchUserURI,httpRequest);
        httpRequest.header("Authorization", token);
        Response response = httpRequest.request(Method.GET, "");
        flows_new.assertions(response,200, 9000.00F,"Success");
    }

    public void post_logOff()
    {
        flows_new.provideURI(logOffURI,httpRequest);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("User-Agent", "PostmanRuntime/7.26.8");
        httpRequest.header("Connection", "keep-alive");
        httpRequest.header("Accept-Encoding", "gzip, deflate, br");
        httpRequest.header("Authorization", token);

        //Create a JSON Object
        JSONObject requestParams = new JSONObject();
        //Add Key-Value sets to the JSON Object
        requestParams.put("deviceToken", "");
        //Change Datatype of JSON Object
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST);

        flows_new.assertions(response,200, 9000.00F,"success.");

    }

    public void delete_RemoveAccount()
    {
        flows_new.provideURI(deleteURI,httpRequest);

        httpRequest.header("Authorization", token);
        Response response = httpRequest.request(Method.DELETE);
        flows_new.assertions(response,200, 9000.00F,"Account deleted successfully.");
    }
}
