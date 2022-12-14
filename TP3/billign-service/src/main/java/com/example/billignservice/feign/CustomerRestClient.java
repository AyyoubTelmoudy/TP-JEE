package com.example.billignservice.feign;

import com.example.billignservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name ="CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping(path = "/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id);

    @GetMapping(path = "/customers")
    public PagedModel<Customer> getCustomers();
}
