package com.example.ebanqueservice.services;

import com.example.ebanqueservice.dto.AccountRequestDTO;
import com.example.ebanqueservice.dto.AccountResponseDTO;

public interface AccountService {
    public AccountResponseDTO addAccount(AccountRequestDTO accountRequestDTO);
}
