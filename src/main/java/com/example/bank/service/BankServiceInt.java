package com.example.bank.service;

import com.example.bank.dto.AccountDTO;
import com.example.bank.dto.CardDTO;
import com.example.bank.dto.ContractDTO;
import com.example.bank.dto.UserDto;
import com.example.bank.entity.Account;
import feign.Contract;

import java.util.List;
import java.util.UUID;

public interface BankServiceInt {
    AccountDTO createAccount(AccountDTO accountDTO);
    CardDTO createCard(CardDTO cardDTO);
    AccountDTO getbalance (UUID id);
    AccountDTO replenishmentAccount (String number, Long count);
    List<AccountDTO> translation (String number, String number1, Long count);
    public ContractDTO getContract (UUID id);
    public UserDto getUser (UUID id);
}
