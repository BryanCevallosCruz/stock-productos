package com.bacc.stock.service.Impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bacc.stock.model.ApiResponse;
import com.bacc.stock.model.Producto;
import com.bacc.stock.service.ProductoService;
import com.bacc.stock.service.dto.CantidadProductosDto;

@Service
public class ProductoServiceImpl implements ProductoService {
     @Value("Openbravo")
    private String username;

    @Value("1234")
    private String password;

    public List<Producto>  consumeApiWithBasicAuth() throws IOException{

        RestTemplate restTemplate = new RestTemplate();

        // Configurar autenticación básica
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password));

        String apiUrl = "https://obpreprod.sidesoftcorp.com/happypreprod//org.openbravo.service.json.jsonrest/MaterialMgmtStorageDetail";

        ApiResponse responseWrapper = restTemplate.getForObject(apiUrl, ApiResponse.class);

        List<Producto> productos = responseWrapper.getResponse().getData();
        
        return productos;
    }

    @Override
    public List<Producto> getAllProducts() throws IOException {
       return consumeApiWithBasicAuth();
    }

    @Override
    public CantidadProductosDto getCantidadProductos() throws IOException {
        List<Producto> registros = consumeApiWithBasicAuth();
        Integer totalRegistros = registros.size();

        Set<String> productosUnicos = new HashSet<>();
        
        for (Producto producto : registros) {
            productosUnicos.add(producto.getProduct());
        }

        Integer totalProductosDiferentes = productosUnicos.size();

        CantidadProductosDto cantidadProductos = new CantidadProductosDto(totalRegistros, totalProductosDiferentes);

        return cantidadProductos;
        

    }
}
