package com.bacc.stock.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bacc.stock.model.ApiResponse;
import com.bacc.stock.model.Producto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductoService {
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
}

