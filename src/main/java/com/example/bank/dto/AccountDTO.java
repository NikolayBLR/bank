package com.example.bank.dto;

import java.util.UUID;

public class AccountDTO {
    private UUID id;
    private String number;
    private Long balance;

    public AccountDTO(UUID id, String number, Long balance) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }

    public AccountDTO () {}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
