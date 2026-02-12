package com.example.bank.dto;

import com.example.bank.entity.Account;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Null;

import java.time.LocalDate;
import java.util.UUID;

public class CardDTO {
    @Null
    private UUID id;
    @Null
    private LocalDate validity;
    @Null
    private String cvv;
    private UUID account;

    public CardDTO(UUID id, LocalDate validity, UUID account, String cvv) {
        this.id = id;
        this.validity = validity;
        this.account = account;
        this.cvv = cvv;
    }

    public CardDTO() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public UUID getAccount() {
        return account;
    }

    public void setAccount(UUID account) {
        this.account = account;
    }
}
