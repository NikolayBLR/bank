package com.example.bank.controllers;

import com.example.bank.dto.ContractDTO;
import com.example.bank.dto.UserDto;
import com.example.bank.service.BankServiceInt;
import com.example.bank.service.ConnectionBankService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/microservice")
@RestController
public class ConnectionController {
    private final BankServiceInt bankServiceInt;
    private final ConnectionBankService connectionBankService;

    public ConnectionController(BankServiceInt bankServiceInt, ConnectionBankService connectionBankService) {
        this.bankServiceInt = bankServiceInt;
        this.connectionBankService = connectionBankService;
    }

    @GetMapping ("/user/{id}")

    public UserDto getUser (@PathVariable UUID id) {
        return connectionBankService.getUser(id);
    }

    @GetMapping("/contract/{id}")
    public ContractDTO getContract (@PathVariable UUID id) {
        return connectionBankService.getContract(id);
    }

    @PostMapping ("/user")

    public UserDto postUser (@RequestBody @Validated UserDto userDto){
        return connectionBankService.postUser(userDto);
    }

    @PostMapping("/contract")

    public ContractDTO postContract (@RequestBody @Validated ContractDTO contractDTO) {
        return  connectionBankService.postContract(contractDTO);
    }


}
