package com.example.customer.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    //Street Address
    @Column(name="Street_Address", nullable = true)
    private String streetAddress;
    //City
    @Column(name="Address_City", nullable = true)
    private String city;
    //State
    @Column(name="Address_State", nullable = true)
    private String state;
    //Country
    @Column(name="Address_Country", nullable = true)
    private String country;
    //Zip
    @Column(name="Address_Zip", nullable = true)
    private String zip;
}
