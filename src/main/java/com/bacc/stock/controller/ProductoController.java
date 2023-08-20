package com.bacc.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bacc.stock.service.ProductoService;

@RestController
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping("/consume-api")
    public String consumeApi() {
        return productoService.consumeApiWithBasicAuth();
    }
}
