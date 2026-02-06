package com.example.bank;

import com.example.bank.dto.AccountDTO;
import com.example.bank.dto.CardDTO;
import com.example.bank.entity.Account;
import com.example.bank.entity.Card;
import com.example.bank.mapper.MapperAccount;
import com.example.bank.mapper.MapperCard;
import com.example.bank.repository.RepositoryAccount;
import com.example.bank.repository.RepositoryCard;
import com.example.bank.service.BankService;
import com.example.bank.service.BankServiceInt;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
@Slf4j
@ExtendWith(MockitoExtension.class)
public class AccountTest {
    @InjectMocks
    private BankService bankService;
    @Mock
    private RepositoryAccount repositoryAccount;
    @Mock
    private RepositoryCard repositoryCard;
    @Mock
    private MapperAccount mapperAccount;
    @Mock
    private MapperCard mapperCard;
@Test
    void createAccount ()  {
    Account account = new Account();
    when(repositoryAccount.save(account)).thenReturn(account);

    AccountDTO accountDTO = new AccountDTO();

    when(mapperAccount.toAccountDTO(account)).thenReturn(accountDTO);

    AccountDTO accountDTO1 = bankService.createAccount(account);
    assertEquals(accountDTO1,accountDTO);
    log.info("Объекты равны");

    verify(repositoryAccount, times(1)).save(account);
    verify(mapperAccount,times(1)).toAccountDTO(account);




    }
    @Test
    void getBalance () {
    UUID id = UUID.randomUUID();
    Account account = new Account();
    when(repositoryAccount.findById(id)).thenReturn(Optional.of(account));
    AccountDTO accountDTO = new AccountDTO();
    when(mapperAccount.toAccountDTO(account)).thenReturn(accountDTO);
    AccountDTO accountDTO1 = bankService.getbalance(id);
    assertEquals(accountDTO,accountDTO1);
    verify(repositoryAccount,times(1)).findById(id);
    verify(mapperAccount,times(1)).toAccountDTO(account);


    }

    @Test
    void getBalanceNotFound () {
    UUID id = UUID.randomUUID();
    when(repositoryAccount.findById(id)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> bankService.getbalance(id));
        verify(repositoryAccount,times(1)).findById(id);

    }
    @Test
    void createCard() {
    CardDTO cardDTO = new CardDTO();
    Card card = new Card();
    when(mapperCard.toCard(any(CardDTO.class))).thenReturn(card);
    when(repositoryCard.save(card)).thenReturn(card);
    CardDTO cardDTO2 = new CardDTO();
        when(mapperCard.toCardDTO(card)).thenReturn(cardDTO2);
    CardDTO cardDTO1 = bankService.createCard(cardDTO);
    assertEquals(cardDTO2, cardDTO1);
    verify(repositoryCard, times(1)).save(card);
    verify(mapperCard,times(1)).toCard(cardDTO);
    verify(mapperCard, times(1)).toCardDTO(card);

    }
    @Test
    void replenishmentAccount () {
    Card card = new Card();
    when(repositoryCard.findBynumber("1")).thenReturn(Optional.of(card));
    Account account = new Account();
    card.setAccount(account);
    Long count = 100L;
    account.setBalance(0L);
    AccountDTO  accountDTO = bankService.replenishmentAccount("1", count);
    assertEquals(100L,account.getBalance());

    }

    @Test void translation () {
    Card card = new Card();
    Card card1 = new Card();
    when(repositoryCard.findBynumber("1")).thenReturn(Optional.of(card));
    when(repositoryCard.findBynumber("2")).thenReturn(Optional.of(card1));
    Account account = new Account();
    Account account1 = new Account();
    card.setAccount(account);
    card1.setAccount(account1);
    account.setBalance(200L);
    account1.setBalance(0L);
        List<AccountDTO> list = new ArrayList<>();
        List<AccountDTO> list1 = bankService.translation("1","2",100L);
    assertEquals(100L,account.getBalance());
    assertEquals(100L, account1.getBalance());
}



}
