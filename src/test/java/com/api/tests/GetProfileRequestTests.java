package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;
import com.api.model.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetProfileRequestTests {
    @Test(description = "Get User profile")
    public void getProfileInfoTests(){
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("09mitu.choudhary@gmail.com", "Mission@2026"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());

        UserProfileManagementService userManagement = new UserProfileManagementService() ;
        response = userManagement.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getUsername());


    }
}
