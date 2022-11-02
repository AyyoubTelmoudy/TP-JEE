package com.example.ebanqueservice.dto;

import com.example.ebanqueservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponseDTO {

    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
