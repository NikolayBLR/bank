package com.example.bank.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.util.UUID;

public class ContractDTO {

        private UUID id;

        private UUID user;

        private String number;

        private Status status;


        public ContractDTO(UUID id, UUID user, Status status, String number) {
            this.id = id;
            this.user = user;
            this.status = status;
            this.number = number;

        }
        public ContractDTO () {}

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public UUID getUser() {
            return user;
        }

        public void setUser(UUID user) {
            this.user = user;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

}
