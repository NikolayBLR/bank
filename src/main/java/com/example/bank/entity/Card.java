package com.example.bank.entity;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Card {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String number;
    @Column(name = "validity")
    private LocalDate validity;
    private String cvv;
    @ManyToOne
    @JoinColumn(name= "account_id ")
    private Account account;

    public Card(UUID id, String number, LocalDate validity, String cvv, Account account) {
        this.id = id;
        this.number = number;
        this.validity = validity;
        this.cvv = cvv;
        this.account = account;
    }




    public Card() {}

    public String randomCVV (int length) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<length; i++) {
            int digit = secureRandom.nextInt(10);
            stringBuilder.append(digit);
        }
        return stringBuilder.toString();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

