package com.trainsys.trainsys_application.dto;

import java.time.LocalDate;

public class RegisterUserDto {
    private String email;
    private String password;
    private String name;
    private LocalDate dateBirth;
    private String cpf;
    private String plan;
    public String getEmail() {
        return email;
    }

    public RegisterUserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public RegisterUserDto setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return STR."RegisterUserDto{email='\{email}\{'\''}, password='\{password}\{'\''}, fullName='\{name}\{'\''}\{'}'}";
    }
}
