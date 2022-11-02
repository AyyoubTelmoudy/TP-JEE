package com.example.ebanqueservice;

import com.example.ebanqueservice.entities.Account;
import com.example.ebanqueservice.enums.AccountType;
import com.example.ebanqueservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class EBanqueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBanqueServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountRepository accountRepository){
        return  args -> {
            for (int i = 0; i < 10; i++) {
                Account account=Account.builder().id(UUID.randomUUID().toString()).
                        type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT).
                        balance(10000+Math.random()*90000).
                        createdAt(new Date()).
                        currency("MAD").build();
                accountRepository.save(account);
            }
        };
    }

}
