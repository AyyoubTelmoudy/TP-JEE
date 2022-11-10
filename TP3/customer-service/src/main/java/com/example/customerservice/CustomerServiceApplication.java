package com.example.customerservice;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication  {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository repository){
        return args -> {
 repository.save(new Customer(null,"Mohammed","mohamed@gmail.com"));
            repository.save(new Customer(null,"ayyoub","ayyoub@gmail.com"));
            repository.save(new Customer(null,"aymane","aymane@gmail.com"));
            repository.findAll().forEach(c->{System.out.println(c.toString());});
        };
    }
}
