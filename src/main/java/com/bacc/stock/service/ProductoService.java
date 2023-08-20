package com.bacc.stock.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductoService {
    @Value("Openbravo")
    private String username;

    @Value("1234")
    private String password;

    public String consumeApiWithBasicAuth() {
        RestTemplate restTemplate = new RestTemplate();

        // Configurar autenticación básica
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password));

        String apiUrl = "https://obpreprod.sidesoftcorp.com/happypreprod//org.openbravo.service.json.jsonrest/MaterialMgmtStorageDetail"; // URL de la API que deseas consumir

        // Realizar la llamada a la API
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        // Manejar la respuesta según tus necesidades
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return "Error en la llamada a la API";
        }
    }
}
