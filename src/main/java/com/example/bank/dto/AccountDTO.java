package com.example.bank.dto;

import java.util.UUID;

public class AccountDTO {
    private UUID id;
    private String number;
    private String name;
    private Long balance;

    public AccountDTO(UUID id, String number, String name, Long balance) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.balance = balance;
    }

    public AccountDTO () {}

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
