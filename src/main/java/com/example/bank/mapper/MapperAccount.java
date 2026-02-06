package com.example.bank.mapper;

import com.example.bank.dto.AccountDTO;
import com.example.bank.entity.Account;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MapperAccount {

    public Account  toAccount (AccountDTO accountDTO);

    public AccountDTO toAccountDTO (Account account);

}
