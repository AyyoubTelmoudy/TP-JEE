package com.example.ebanqueservice.mappers;

import com.example.ebanqueservice.dto.AccountResponseDTO;
import com.example.ebanqueservice.entities.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountResponseDTO fromAccount(Account account)
    {
        AccountResponseDTO accountResponseDTO=new AccountResponseDTO();
        BeanUtils.copyProperties(account,accountResponseDTO);
      return  accountResponseDTO;
    }
}
