package com.bacc.stock.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @JsonProperty("id")
    private String id;

    @JsonProperty("product")
    private String product;

    @JsonProperty("product$_identifier")
    private String productIdentifier;

    @JsonProperty("uOM$_identifier")
    private String nombreUnidad;

    @JsonProperty("quantityOnHand")
    private String cantidad;
}
