package com.example.bank.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.antlr.v4.runtime.misc.NotNull;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Account {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private String number;
    @Min(0)
    private Long balance;


    public Account(String name, String number, Long balance) {
        this.name = name;
        this.number = number;
        this.balance = balance;
    }

    public String randomCVV (int length) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<length; i++) {
            int digit = secureRandom.nextInt(10);
            stringBuilder.append(digit);
        }
        return stringBuilder.toString();
    }


    public Account () {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
