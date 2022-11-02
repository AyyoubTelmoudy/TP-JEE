package com.example.ebanqueservice.web;

import com.example.ebanqueservice.dto.AccountRequestDTO;
import com.example.ebanqueservice.dto.AccountResponseDTO;
import com.example.ebanqueservice.entities.Account;
import com.example.ebanqueservice.repositories.AccountRepository;
import com.example.ebanqueservice.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    AccountRepository accountRepository;
    AccountService accountService;

    public AccountRestController(AccountRepository accountRepository, AccountService accountService) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }

    @GetMapping(value = "/accounts")
    public List<Account> getAllAccounts(){
     return  accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable(name = "id") String id)
    {
        return  accountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found !!!!!",id)));
    }
    @PostMapping("/accounts")
    public AccountResponseDTO save(@RequestBody AccountRequestDTO account)
    {
        return  accountService.addAccount(account);
    }

    @PutMapping ("/accounts/{id}")
    public Account update(@PathVariable(name = "id") String id,@RequestBody Account account)
    {
       Account acc= accountRepository.findById(id).orElseThrow();
       if(account.getBalance()!=null) acc.setBalance(account.getBalance());
        if(account.getCreatedAt()!=null) acc.setCreatedAt(new Date());
        if(account.getType()!=null) acc.setType(account.getType());
        if(account.getCurrency()!=null) acc.setCurrency(account.getCurrency());
        return  accountRepository.save(acc);
    }
    @DeleteMapping ("/accounts/{id}")
    public void delete(@PathVariable(name = "id") String id)
    {
       accountRepository.deleteById(id);
    }
}
