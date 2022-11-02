package com.example.ebanqueservice.services;

import com.example.ebanqueservice.dto.AccountRequestDTO;
import com.example.ebanqueservice.dto.AccountResponseDTO;
import com.example.ebanqueservice.entities.Account;
import com.example.ebanqueservice.mappers.AccountMapper;
import com.example.ebanqueservice.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository;
    AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountResponseDTO addAccount(AccountRequestDTO accountRequestDTO) {
        Account account=Account.builder().id(UUID.randomUUID().toString()).
                createdAt(new Date())
                .balance(accountRequestDTO.getBalance())
                .type(accountRequestDTO.getType())
                .currency(accountRequestDTO.getCurrency())
                .build();
        Account savedAccount= accountRepository.save(account);

       return accountMapper.fromAccount(savedAccount);
    }
}
