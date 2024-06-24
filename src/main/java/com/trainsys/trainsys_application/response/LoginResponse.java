package com.trainsys.trainsys_application.response;

import java.util.concurrent.TimeUnit;

public class LoginResponse {
    private String token;

    private Long expiresIn;

    private String name;

    public String getToken() {
        return token;
    }

    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public LoginResponse setExpiresIn(Long expiresIn) {
        this.expiresIn = TimeUnit.MILLISECONDS.toHours(expiresIn);
        return this;
    }

    public String getName() {
        return name;
    }

    public LoginResponse setName(String name) {
        this.name = name;
        return this;
    }


    @Override
    public String toString() {
        return STR."LoginResponse{token='\{token}\{'\''}, expiresIn=\{expiresIn}, name='\{name}\{'\''}\{'}'}";
    }
}
