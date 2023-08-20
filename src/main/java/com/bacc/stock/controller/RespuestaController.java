package com.bacc.stock.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bacc.stock.service.Impl.ProductoServiceImpl;
import com.bacc.stock.service.dto.CantidadProductosDto;
import com.bacc.stock.service.dto.ProductoDto;

@Controller
@RequestMapping
public class RespuestaController {
    private final ProductoServiceImpl productoService;

    public RespuestaController(ProductoServiceImpl productoService){
        this.productoService = productoService;
    }

    @GetMapping("/pagina")
    public String mostrarPagina(Model model) throws IOException {
        CantidadProductosDto cantidad = productoService.getCantidadProductos();
        model.addAttribute("totalRegistros", cantidad.getTotalRegistros());
        model.addAttribute("totalProductosDiferentes", cantidad.getTotalProductosDiferentes());
        
        List<ProductoDto> productosMayorStock = productoService.getProductosMayorStock();
        model.addAttribute("productosMayorStock", productosMayorStock);

        List<ProductoDto> productosDiferenteA = productoService.getProductosDiferenteA();
        model.addAttribute("productosDiferenteA", productosDiferenteA);

        return "index"; // Nombre del archivo HTML sin la extensión .html
    }
}
