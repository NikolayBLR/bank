package com.example.bank.mapper;

import com.example.bank.dto.CardDTO;
import com.example.bank.entity.Account;
import com.example.bank.entity.Card;
import com.example.bank.repository.RepositoryAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class MapperCard {
    @Autowired
     RepositoryAccount accountRepository;
    @Mapping(source = "account", target = "account")
    public abstract Card toCard(CardDTO cardDTO);

    public abstract CardDTO toCardDTO(Card card);

   public Account map(UUID value) { if (value == null) return null;

        return accountRepository.findById(value) .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public UUID map(Account value) { return value == null ? null : value.getId(); }
}
