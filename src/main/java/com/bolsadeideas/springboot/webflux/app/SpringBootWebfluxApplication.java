package com.bolsadeideas.springboot.webflux.app;

import java.util.Date;

import com.bolsadeideas.springboot.webflux.app.models.dao.ProductDao;
import com.bolsadeideas.springboot.webflux.app.models.documents.BankProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootWebfluxApplication implements CommandLineRunner{

	@Autowired
	private ProductDao dao;
	
	@Autowired
	private ReactiveMongoTemplate mongoTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootWebfluxApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		mongoTemplate.dropCollection("bankclients").subscribe();

		Flux.just(
					new BankProduct("credito empresarial", "Credito", 0, 0),
					new BankProduct("credito personal", "credito",0, 0),
					new BankProduct("ahorro", "cuenta bancaria", 0, 30),
					new BankProduct("cuenta corriente", "Cuenta bancaria", 10, -1),
					new BankProduct("plazo fijo", "Cuenta bancaria", 0, 1)
				)
		.flatMap(c -> {
			c.setCreateAt(new Date());
			return dao.save(c);
			})
		.subscribe(c -> log.info("Insert: " + c.getId() + " " + c.getName()));
		
	}
}
