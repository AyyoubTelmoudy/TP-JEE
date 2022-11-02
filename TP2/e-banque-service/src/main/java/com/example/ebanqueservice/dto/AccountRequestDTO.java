package com.example.ebanqueservice.dto;

import com.example.ebanqueservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;
}
