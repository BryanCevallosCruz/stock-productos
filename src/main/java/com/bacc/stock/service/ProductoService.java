package com.bacc.stock.service;

import java.io.IOException;
import java.util.List;

import com.bacc.stock.model.Credenciales;
import com.bacc.stock.model.Producto;
import com.bacc.stock.service.dto.CantidadProductosDto;
import com.bacc.stock.service.dto.ProductoDto;

public interface ProductoService {
   List<Producto> getAllProducts(Credenciales credenciales) throws IOException;
   CantidadProductosDto getCantidadProductos(Credenciales credenciales) throws IOException;
   List<ProductoDto> getProductosDiferenteA(Credenciales credenciales) throws IOException;
   List<ProductoDto> getProductosMayorStock(Credenciales credenciales) throws IOException;
}

