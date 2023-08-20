package com.bacc.stock.service.dto;

import lombok.Data;

@Data
public class ProductoDto {
    private String product;
    private String productIdentifier;
    private String nombreUnidad;
    private Integer cantidad;
}
