package com.example.bank.repository;

import com.example.bank.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RepositoryCard extends JpaRepository<Card, UUID> {
    Optional<Card> findBynumber (String number);
}
