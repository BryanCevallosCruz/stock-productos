package com.bacc.stock.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bacc.stock.model.Credenciales;
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

    @GetMapping("/")
    public String mostrarFormulario() {
        return "formulario";
    }

    @GetMapping("/pagina")
    public String mostrarPagina(Model model, 
        @RequestParam String username, @RequestParam String password ) throws IOException {
        Credenciales credenciales = new Credenciales();
        credenciales.setUsername(username);
        credenciales.setPassword(password);

        CantidadProductosDto cantidad = productoService.getCantidadProductos(credenciales);
        model.addAttribute("totalRegistros", cantidad.getTotalRegistros());
        model.addAttribute("totalProductosDiferentes", cantidad.getTotalProductosDiferentes());
        
        List<ProductoDto> productosMayorStock = productoService.getProductosMayorStock(credenciales);
        model.addAttribute("productosMayorStock", productosMayorStock);

        List<ProductoDto> productosDiferenteA = productoService.getProductosDiferenteA(credenciales);
        model.addAttribute("productosDiferenteA", productosDiferenteA);

        return "index"; 
    }
}
