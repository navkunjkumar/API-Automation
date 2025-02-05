package com.api.tests;

import com.api.base.AuthService;
import com.api.model.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class AccountCreationTests {
    @Test(description = "Verify the sign up feature")
    public void AccountCreationTest(){
        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .username("jatin")
                .password("jatin@12345")
                .email("jatinsharma123345@gmail.com")
                .firstName("Jatin")
                .lastName("Sharma")
                .mobileNumber("2323232323")
                .build();

        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        System.out.println(response.asPrettyString());
    }

}
