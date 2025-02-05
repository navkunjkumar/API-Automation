package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.model.request.LoginRequest;
import com.api.model.request.ProfileRequest;
import com.api.model.response.LoginResponse;
import com.api.model.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTests {
    @Test(description = "update user profile")
    public void updateProfileTest(){
        AuthService authService = new AuthService();
        Response response =  authService.login(new LoginRequest("09mitu.choudhary@gmail.com", "Mission@2026"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());
        System.out.println("-------------------------------------");

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        // Assert.assertEquals(userProfileResponse.getUsername(), "Mitu");
        System.out.println("------------------------------------------");

        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName("Mitu")
                .lastName("Kumari")
                .email("09mitu.choudhary@gmail.com")
                .mobileNumber("7272727272")
                .build();

        response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest );
        System.out.println(response.asPrettyString());

    }
}
