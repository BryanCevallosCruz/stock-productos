package com.bacc.stock.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bacc.stock.model.Producto;
import com.bacc.stock.service.Impl.ProductoServiceImpl;
import com.bacc.stock.service.dto.CantidadProductosDto;


@RestController
public class ProductoController {
    private final ProductoServiceImpl productoService;

    public ProductoController(ProductoServiceImpl productoService){
        this.productoService = productoService;
    }

    @GetMapping(value="/consume-api", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Producto> consumeApi() throws IOException {
        return productoService.consumeApiWithBasicAuth();
    }

    @GetMapping(value="/cantidad-productos", produces = MediaType.APPLICATION_JSON_VALUE)
    public CantidadProductosDto geCantidadProductos() throws IOException {
        return productoService.getCantidadProductos();
    }
}
