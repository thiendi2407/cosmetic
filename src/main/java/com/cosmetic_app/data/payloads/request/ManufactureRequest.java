package com.lekwacious.employee_app.data.payloads.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ManufactureRequest {
    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String address;

    @NotBlank
    @NotNull
    private String phoneNumber;

    @Email
    private String email;

    @NotBlank
    @NotNull
    private double country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCountry() {
        return country;
    }

    public void setCountry(double country) {
        this.country = country;
    }
}
