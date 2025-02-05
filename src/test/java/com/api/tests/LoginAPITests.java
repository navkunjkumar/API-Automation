package com.api.tests;

import com.api.base.AuthService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listners.TestListener.class)

public class LoginAPITests {

    @Test(description = "Verify if the Login API is working")
    public void loginTest(){
        LoginRequest loginRequest = new LoginRequest("09mitu.choudhary@gmail.com", "Mission@2026");
        System.out.println(loginRequest);
        AuthService authService = new AuthService();
       Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);

        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(loginResponse.getToken());

    }
}
