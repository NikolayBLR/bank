package com.example.bank;



import com.example.bank.dto.ContractDTO;
import com.example.bank.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "ContractsService", url = "http://localhost:8083")
public interface ConnectionServices{

    @GetMapping ("/system/contract/{id}")

    public ContractDTO getContract (@PathVariable UUID id);
    @GetMapping ("/system/user/{id}")
    public UserDto getUser (@PathVariable UUID id);
}
