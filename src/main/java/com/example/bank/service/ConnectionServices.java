package com.example.bank;



import com.example.bank.dto.ContractDTO;
import com.example.bank.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "ContractsService", url = "http://localhost:8083")

public interface ConnectionServices{

    @GetMapping ("/system/contract/{id}")

    public ContractDTO getContract (@PathVariable UUID id);

    @GetMapping ("/system/user/{id}")

    public UserDto getUser (@PathVariable UUID id);

    @PostMapping("/system/user")

    public UserDto postUser (@RequestBody UserDto userDto);

    @PostMapping("/system/contract")
    ContractDTO postContract(@RequestBody ContractDTO contractDTO);
}
