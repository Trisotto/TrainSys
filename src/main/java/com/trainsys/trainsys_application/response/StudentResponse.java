package com.trainsys.trainsys_application.response;

import com.trainsys.trainsys_application.dto.AddressDto;

import java.time.LocalDate;

public class StudentResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDate dateBirth;
    private String cpf;
    private String contact;
    private AddressDto address;
    private String cep;
    private String street;
    private String state;
    private String neighborhood;
    private String city;
    private String number;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
