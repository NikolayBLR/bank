package com.example.bank.dto;

public class AccountTranslationDTO {
    String number1;
    String number2;
    Long count;

    public AccountTranslationDTO(String number1, String number2, Long count) {
        this.number1 = number1;
        this.number2 = number2;
        this.count = count;
    }

    public AccountTranslationDTO() {

    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

