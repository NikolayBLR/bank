package com.example.bank.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.time.LocalDate;
import java.util.UUID;

public class UserDto {
        @Null
        private UUID id;
        @NotNull
        private String surname;
        @NotNull
        private String name;
        @Null
        private LocalDate date;

        public UserDto(UUID id, String surname, String name, LocalDate date) {
            this.id = id;
            this.surname = surname;
            this.name = name;
            this.date = date;
        }
        public UserDto () {}
        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

}
