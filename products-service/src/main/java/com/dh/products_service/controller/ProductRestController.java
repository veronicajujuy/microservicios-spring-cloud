package com.dh.products_service.controller;

import com.dh.products_service.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @GetMapping()
    public Product getProduct() {
        return new Product("1", "Notebook", 2000.0, "Instance 2");
    }
}
