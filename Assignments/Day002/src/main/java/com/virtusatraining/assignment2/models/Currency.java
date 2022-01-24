package com.virtusatraining.assignment2.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Currency_Id")
    private long currencyId;
    @Column(name="Currency_Name", length = 50, nullable = false)
    private String currencyName;
    @Column(name="Country_Name", length = 50, nullable = false)
    private String countryName;
    @Column(name="Currency_Symbol", length = 50, nullable = false)
    private String currencySymbol;
}
