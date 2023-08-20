package com.bacc.stock.service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bacc.stock.model.ApiResponse;
import com.bacc.stock.model.Credenciales;
import com.bacc.stock.model.Producto;
import com.bacc.stock.service.ProductoService;
import com.bacc.stock.service.dto.CantidadProductosDto;
import com.bacc.stock.service.dto.ProductoDto;

@Service
public class ProductoServiceImpl implements ProductoService {
    // private String username="Openbravo";
    // private String password="1234";

    public List<Producto>  consumeApiWithBasicAuth(Credenciales credenciales) throws IOException{

        RestTemplate restTemplate = new RestTemplate();

        // Configurar autenticación básica
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(credenciales.getUsername(), credenciales.getPassword()));
        // restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password));

        String apiUrl = "https://obpreprod.sidesoftcorp.com/happypreprod//org.openbravo.service.json.jsonrest/MaterialMgmtStorageDetail";

        ApiResponse responseWrapper = restTemplate.getForObject(apiUrl, ApiResponse.class);

        List<Producto> productos = responseWrapper.getResponse().getData();
        
        return productos;
    }

    @Override
    public List<Producto> getAllProducts(Credenciales credenciales) throws IOException {
       return consumeApiWithBasicAuth(credenciales);
    }

    @Override
    public CantidadProductosDto getCantidadProductos(Credenciales credenciales) throws IOException {
        
        List<Producto> registros = consumeApiWithBasicAuth(credenciales);
        Integer totalRegistros = registros.size();

        Set<String> productosUnicos = new HashSet<>();
        for (Producto producto : registros) {
            productosUnicos.add(producto.getProduct());
        }

        Integer totalProductosDiferentes = productosUnicos.size();

        CantidadProductosDto cantidadProductos = new CantidadProductosDto(totalRegistros, totalProductosDiferentes);

        return cantidadProductos;
        

    }

    @Override
    public List<ProductoDto> getProductosMayorStock(Credenciales credenciales) throws IOException {
        Integer limite = 10;

        List<Producto> registros = consumeApiWithBasicAuth(credenciales);

        List<ProductoDto> registrosOrdenados = new ArrayList<>();

        for(Producto registro: registros){
            ProductoDto productoDto = new ProductoDto();
            productoDto.setCantidad(Integer.valueOf(registro.getCantidad()));
            productoDto.setNombreUnidad(registro.getNombreUnidad());
            productoDto.setProduct(registro.getProduct());
            productoDto.setProductIdentifier(registro.getProductIdentifier());
            registrosOrdenados.add(productoDto);
        }

        List<ProductoDto> mayoresRegistros = registrosOrdenados.stream()
            .sorted(Comparator.comparing(ProductoDto::getCantidad, Comparator.reverseOrder()))
            .limit(limite)
            .collect(Collectors.toList());
        
        return mayoresRegistros; 
    }

    @Override
    public List<ProductoDto> getProductosDiferenteA(Credenciales credenciales) throws IOException {
        String nombreComparar = "UNIDAD";
        List<Producto> registros = consumeApiWithBasicAuth(credenciales);

        List<Producto> registrosFiltrados = registros.stream()
                .filter(u->!u.getNombreUnidad().equals(nombreComparar))
                .toList();

        List<ProductoDto> registrosOrdenados = new ArrayList<>();

        for(Producto registro: registrosFiltrados){
            ProductoDto productoDto = new ProductoDto();
            productoDto.setCantidad(Integer.valueOf(registro.getCantidad()));
            productoDto.setNombreUnidad(registro.getNombreUnidad());
            productoDto.setProduct(registro.getProduct());
            productoDto.setProductIdentifier(registro.getProductIdentifier());
            registrosOrdenados.add(productoDto);
        }
        
        return registrosOrdenados;
    }
}
