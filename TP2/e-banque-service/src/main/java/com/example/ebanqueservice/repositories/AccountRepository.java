package com.example.ebanqueservice.repositories;

import com.example.ebanqueservice.entities.Account;
import com.example.ebanqueservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account,String> {

    @RestResource(path = "/byType")
    List<Account> findByType(@Param("t") AccountType type);
}
