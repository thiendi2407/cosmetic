package com.cosmetic_app.data.payloads.response;

public class LoginResponse {

    private String token;

    public LoginResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
