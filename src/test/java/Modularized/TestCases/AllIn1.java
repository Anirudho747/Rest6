package Modularized.TestCases;

import Modularized.Flows.Flows;
import org.testng.annotations.Test;


public class AllIn1 {

    private String params = "?page=1&q=dore&per_page=400";
    Flows flows  = new Flows();

    private String URI = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/user-detail";
    private String URI2 = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/users";
    private String URI3 = "http://fanamp-staging-api-83717343.us-east-1.elb.amazonaws.com/api/v1/remove-account";
    private String token = "Bearer "+"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpZCI6Mjk0LCJtb2JpbGVfbnVtYmVyIjoiKzkxIDc1NTAxMzQ3NDAiLCJpYXQiOjE2Njk2OTg1NjN9.MESyV2vU88q432Jq2bRF5ZsAi_gHzDA0OwVJ4VPok1-A9n2Vs3iKJsOCTSNRi0HXhNOIX7i1eLKM-u6Bcw8KWg";
    private String deviceToken = "fv1_9EtgcUGYgBxyWm4jCi:APA91bGgcPClIiTLBuAHBvO5KePxO0GIzIPNBCXhtaXO3B0xEgkOS-LylRlem933cd4OKRAYMH_Xc8UesND-hKdjW257umpXy3_53E7UCM73w6UnVDbNHb42zCV2xQvg4D3877V2R1S6 ";

    @Test
    public void get_fetchUserDetail()

    {
        flows.getWithoutParameters(URI,token,200, 9000.00F,"Success");
    }

    @Test
    public void getWithParams_fetchUserList()
    {
        flows.getWithParameters(URI,token,params,200, 9000.00F,"Success");
    }

    @Test
    public void post_blockUser()
    {
        flows.postWithoutBody(URI,token,201, 9000.00F,"Success");
    }

    @Test
    public void postWithBody_registerUser() { flows.postWithBody(URI2,deviceToken,201, 9000.00F,"User created successfully."); }

    @Test
    public void put_updateGroupDetails() { flows.putWithBody(URI3,token,200, 9000.00F,"Group Updated successfully."); }

    @Test
    public void delete_removeUser()
    {
        flows.delete(URI3,token,200, 9000.00F,"Account deleted successfully.");
    }


}
