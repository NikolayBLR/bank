package com.example.bank.service;


import com.example.bank.dto.AccountDTO;
import com.example.bank.dto.CardDTO;
import com.example.bank.entity.Account;
import com.example.bank.entity.Card;
import com.example.bank.mapper.MapperAccount;
import com.example.bank.mapper.MapperCard;
import com.example.bank.repository.RepositoryAccount;
import com.example.bank.repository.RepositoryCard;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class BankService implements BankServiceInt {

    public final MapperAccount mapperAccount;
    public final RepositoryAccount repositoryAccount;
    public final RepositoryCard repositoryCard;
    public final MapperCard mapperCard;
    public final ConnectionServices connectionServices;

    public BankService(MapperAccount mapperAccount, RepositoryAccount repositoryAccount, RepositoryCard repositoryCard, MapperCard mapperCard, ConnectionServices connectionServices) {
        this.mapperAccount = mapperAccount;
        this.repositoryAccount = repositoryAccount;
        this.repositoryCard = repositoryCard;
        this.mapperCard = mapperCard;
        this.connectionServices = connectionServices;
    }

    public AccountDTO createAccount (AccountDTO account) {
        Account account1 = mapperAccount.toAccount(account);
        account1.setNumber(account1.randomCVV(16));
        var saved = repositoryAccount.save(account1);
        return mapperAccount.toAccountDTO(saved);
    }

    public CardDTO createCard (CardDTO card) {
        Card card1 = mapperCard.toCard(card);

        LocalDate date = LocalDate.now();
        card1.setId(UUID.randomUUID());
        card1.setNumber(card1.randomCVV(16));
        card1.setCvv(card1.randomCVV(3));
        card1.setValidity(date);
        var saved = repositoryCard.save(card1);
        return mapperCard.toCardDTO(saved);
    }

    public AccountDTO getbalance (UUID id) {
        Account account = repositoryAccount.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found"));
        return mapperAccount.toAccountDTO(account);
    }

    public AccountDTO replenishmentAccount (String number, Long count) {
        Card card = repositoryCard.findBynumber(number).orElseThrow(()-> new EntityNotFoundException("Not found"));
        Account account = card.getAccount();
        account.setBalance(account.getBalance() + count);
        var saved = repositoryAccount.save(account);
        return mapperAccount.toAccountDTO(saved);

    }
    @Transactional
    @Override
    public List<AccountDTO> translation(String number, String number1,Long count) {
        Card card = repositoryCard.findBynumber(number).orElseThrow(() -> new EntityNotFoundException("Not found"));
        Card card1 = repositoryCard.findBynumber(number1).orElseThrow(() -> new EntityNotFoundException("Not found"));
        Account account = card.getAccount();
        Account account1 = card1.getAccount();
        if (count >= 0) { account.setBalance(account.getBalance()-count); }
        else account.setBalance(account.getBalance()+count);
        var saved = repositoryAccount.save(account);
        var a = mapperAccount.toAccountDTO(saved);
        if (count >= 0)
        account1.setBalance(account1.getBalance()+count);
        else account1.setBalance(account1.getBalance()-count);
        var saved1 = repositoryAccount.save(account1);
        var b = mapperAccount.toAccountDTO(saved1);
        List<AccountDTO> accountDTOS= new ArrayList<>();
        accountDTOS.add(a);
        accountDTOS.add(b);
        return accountDTOS;

    }

}
