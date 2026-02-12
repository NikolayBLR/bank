package com.example.bank.controllers;


import com.example.bank.dto.*;
import com.example.bank.service.BankServiceInt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Slf4j
@RequestMapping("/bank")
@RestController
public class Controller {
    private final BankServiceInt service;


    public Controller(BankServiceInt service) {
        this.service = service;
    }

    @PostMapping("/createaccount")
    public AccountDTO createAccount (@RequestBody @Validated AccountDTO account) {
        log.info("Создание счета");
        return service.createAccount(account);
    }

    @PostMapping("/cards")
    public ResponseEntity<CardDTO> createCard(@RequestBody @Validated CardDTO dto) {
        log.info("Создание карты");
        CardDTO saved = service.createCard(dto);
        return ResponseEntity.ok(saved); }

    @GetMapping("/{id}")

    public AccountDTO getbalance (@PathVariable UUID id) {
        log.info("Просмотр баланса");
        return service.getbalance(id);
    }
    @PostMapping("/account/deposit")

    public AccountDTO replenishmentAccount (@RequestBody @Validated AccountDepositDTO accountDepositDTO) {
        log.info("Пополнение счета");
        return service.replenishmentAccount(accountDepositDTO.getNumber(),accountDepositDTO.getCount());
    }
    @PostMapping("/account/translation")

    public List<AccountDTO> translation(@RequestBody @Validated AccountTranslationDTO accountTranslationDTO) {
        log.info("Перечисление с одной карты на другую ");
        return  service.translation(accountTranslationDTO.getNumber1(), accountTranslationDTO.getNumber2(), accountTranslationDTO.getCount());
    }

}
