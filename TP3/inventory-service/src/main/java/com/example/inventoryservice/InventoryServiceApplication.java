package com.example.inventoryservice;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	CommandLineRunner start(ProductRepository repository){
		return args -> {
   repository.save(new Product(null,"Ordinatuer",788,12));
   repository.save(new Product(null,"Imprimante",788,12));
   repository.save(new Product(null,"SmartPhone",788,12));
   repository.findAll().forEach(p->{System.out.println(p.getName());});
		};
	}


}
