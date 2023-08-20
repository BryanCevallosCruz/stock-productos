package com.bacc.stock.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bacc.stock.model.Producto;
import com.bacc.stock.service.ProductoService;

@RestController
// @RequestMapping("/v1")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping(value="/consume-api", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Producto> consumeApi() throws IOException {
        return productoService.consumeApiWithBasicAuth();
    }
}
