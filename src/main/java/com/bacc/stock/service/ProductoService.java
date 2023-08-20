package com.bacc.stock.service;

import java.io.IOException;
import java.util.List;

import com.bacc.stock.model.Producto;
import com.bacc.stock.service.dto.CantidadProductosDto;
import com.bacc.stock.service.dto.ProductoDto;

public interface ProductoService {
   List<Producto> getAllProducts() throws IOException;
   CantidadProductosDto getCantidadProductos() throws IOException;
   List<ProductoDto> getProductosDiferenteA() throws IOException;
   List<ProductoDto> getProductosMayorStock() throws IOException;
}

