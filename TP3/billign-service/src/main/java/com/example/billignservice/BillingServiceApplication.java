package com.example.billignservice;

import com.example.billignservice.entities.Bill;
import com.example.billignservice.entities.ProductItem;
import com.example.billignservice.feign.CustomerRestClient;
import com.example.billignservice.feign.ProductItemRestClient;
import com.example.billignservice.model.Customer;
import com.example.billignservice.model.Product;
import com.example.billignservice.repositories.BillRepository;
import com.example.billignservice.repositories.ProductItemRepository;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository itemRepository, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient)
    {
        return  args -> {
            String token="eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJOMnBIcm9FQlJqeWUtczBDekdTUVlqOWdwVlMyTjhvV0ZkeWhESVNIS0hvIn0.eyJleHAiOjE2NzA0NjIzODksImlhdCI6MTY3MDQ2MjA4OSwianRpIjoiMWQ2ZmMxZDEtMTg1MC00Mjg4LTkyNDUtNzIzZjNkOTNkYzc2IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy9teXJlYWxtIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjZkMzFkZGI0LWEwOGYtNGI5Yy05OTJkLWY1YjI4MjkxOTFhNiIsInR5cCI6IkJlYXJlciIsImF6cCI6InByb2R1Y3RzLWFwcCIsInNlc3Npb25fc3RhdGUiOiJkZDBiY2RjZC1kZGQ2LTRmNDMtYjYyNS0yMDVmNWE5ZmEzM2UiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiZGVmYXVsdC1yb2xlcy1teXJlYWxtIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsIlVTRVIiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJkZDBiY2RjZC1kZGQ2LTRmNDMtYjYyNS0yMDVmNWE5ZmEzM2UiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJoYXNzYW4iLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ1c2VyMSIsImdpdmVuX25hbWUiOiJoYXNzYW4iLCJmYW1pbHlfbmFtZSI6IiIsImVtYWlsIjoidXNlcjFAZ21haWwuY29tIn0.AvOrEGPPqS2IVBd4yvTK_zshglhTqSutdOVuuQSHFFwpJooY7Zp4T88b2vL78P-IK0rLeB4gZG85tnewOBd_wSsAtqOtJX6-2mxXNnJUHE4CL6C4vLWqssRFlxg1IqO2lxyx0BFYKNt6BF6K9YHPQM2mOHIJAovsXLqizCYolngpebh-9iJH4E-XAOEFtBPJVVLbBRkPhuTuTQsUpftr9TNsl4pa8xc17d-vvc6G4kxuLo9xTt4TxziPOnUqsxvEyrd6lPhLt5hn-wC-UyXVemRCMCywNM7grS2C0VEYolXm2UO3l-qc6k5_1QBKGhUwgURZEDYgIo3KVrKQfUjF5w";
            Customer customer=customerRestClient.getCustomerById(1L,"Bearer "+token);
           Bill bill= billRepository.save(new Bill(null,new Date(),null,customer.getId(),null));
            PagedModel<Product> products=productItemRestClient.pageProducts("Bearer "+token);
            products.forEach(product -> {
                ProductItem productItem=new ProductItem();
                productItem.setPrice(product.getPrice());
                productItem.setQuantity(1+ new Random().nextInt(100));
                productItem.setProductID(product.getId());
                productItem.setBill(bill);
                itemRepository.save(productItem);
            });
        };
    }

}
