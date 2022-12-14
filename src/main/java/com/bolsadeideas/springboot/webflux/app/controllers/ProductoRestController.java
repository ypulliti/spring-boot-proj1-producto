package com.bolsadeideas.springboot.webflux.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bolsadeideas.springboot.webflux.app.models.dao.ProductDao;
import com.bolsadeideas.springboot.webflux.app.models.documents.BankProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@RestController
@RequestMapping("/api/products")
public class ProductoRestController {
	@Autowired
	private ProductDao dao;
	private static final Logger log = LoggerFactory.getLogger(ProductoRestController.class);
	@GetMapping
	public Flux<BankProduct> index(){

        Flux<BankProduct> productos = dao.findAll()
        		.map(c -> {
        			c.setName(c.getName().toUpperCase());
        			return c;
        			})
        		.doOnNext(prod -> log.info(prod.getName()));
        
        return productos;
	}

	@GetMapping("/{id}")
	public Mono<BankProduct> show(@PathVariable String id)
	{
		Flux<BankProduct> productos = dao.findAll();
		
		Mono<BankProduct> bProd = productos
				.filter(p -> p.getId().equals(id))
				.next()
				.doOnNext(prod -> log.info(prod.getName()));
				
		return bProd;
	}
}

