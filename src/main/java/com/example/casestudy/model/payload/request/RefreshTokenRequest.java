package com.example.casestudy.model.payload.request;

import javax.validation.constraints.NotBlank;

public class RefreshTokenRequest {
    @NotBlank
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RefreshTokenRequest() {
    }

    public RefreshTokenRequest(@NotBlank String token, String username) {
        this.token = token;
    }
}
