package com.bacc.stock.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CantidadProductosDto {
    private Integer totalRegistros;
    private Integer totalProductosDiferentes;
}
