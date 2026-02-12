package com.example.bank.dto;

import jakarta.validation.constraints.NotNull;

public class AccountDepositDTO {
    @NotNull
    String number;
    @NotNull
    Long count;

    public AccountDepositDTO(String number, Long count) {
        this.number = number;
        this.count = count;
    }
    public AccountDepositDTO() {}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

