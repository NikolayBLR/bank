package com.example.bank.service;

import com.example.bank.dto.ContractDTO;
import com.example.bank.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ConnectionBankService {

    private final ConnectionServices connectionServices;

    public ConnectionBankService(ConnectionServices connectionServices) {
        this.connectionServices = connectionServices;

    }

    public UserDto getUser(UUID id) {
        return connectionServices.getUser(id);
    }

    public ContractDTO getContract(UUID id) {
        return connectionServices.getContract(id);
    }

    public UserDto postUser (UserDto userDto) {
        return connectionServices.postUser(userDto);
    }

    public ContractDTO postContract(ContractDTO contractDTO) {
        return  connectionServices.postContract(contractDTO);
    }
}
