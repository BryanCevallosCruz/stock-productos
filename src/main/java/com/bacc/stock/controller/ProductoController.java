package com.bacc.stock.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bacc.stock.model.Producto;
import com.bacc.stock.service.Impl.ProductoServiceImpl;
import com.bacc.stock.service.dto.CantidadProductosDto;
import com.bacc.stock.service.dto.ProductoDto;


@RestController
@RequestMapping("/v1")
public class ProductoController {
    private final ProductoServiceImpl productoService;

    public ProductoController(ProductoServiceImpl productoService){
        this.productoService = productoService;
    }

    @GetMapping(value="/todo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Producto> geProductos() throws IOException {
        return productoService.getAllProducts();
    }

    @GetMapping(value="/cantidad-productos", produces = MediaType.APPLICATION_JSON_VALUE)
    public CantidadProductosDto geCantidadProductos() throws IOException {
        return productoService.getCantidadProductos();
    }

    @GetMapping(value="/mayor-stock", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductoDto> getProductosMayorStock() throws IOException {
        return productoService.getProductosMayorStock();
    }

    @GetMapping(value="/diferente-UNIDAD", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductoDto> getProductoDiferenteA() throws IOException {
        return productoService.getProductosDiferenteA();
    }

}
