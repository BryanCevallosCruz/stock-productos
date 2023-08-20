package com.bacc.stock.service;

import java.io.IOException;
import java.util.List;

import com.bacc.stock.model.Producto;
import com.bacc.stock.service.dto.CantidadProductosDto;

public interface ProductoService {
   List<Producto> getAllProducts() throws IOException;
   CantidadProductosDto getCantidadProductos() throws IOException; 
}

