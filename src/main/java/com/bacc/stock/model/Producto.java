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
    // @JsonProperty("product$_identifier")
    // private String product$_identifier;
    @JsonProperty("_identifier")
    private String identifier;

    @JsonProperty("product$_identifier")
    private String productIdentifier;
}
