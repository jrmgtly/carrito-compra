package com.carrito_compra.progra.controller;

import com.carrito_compra.progra.entity.ArticuloEntity;
import com.carrito_compra.progra.service.ArticuloInterfaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {

    private final ArticuloInterfaceService articuloService;

    //Constructor
    public ArticuloController(ArticuloInterfaceService articuloService){
       this.articuloService = articuloService;
    }

    //El mapeo de la screen de articulos
    @GetMapping
    public String listarArticulos(Model model){
        List<ArticuloEntity>articuloEntities = articuloService.listarArticulos();
        model.addAttribute("articulos", articuloEntities);
                return "articulos";
    }

    //El mapeo de los registros JSON
    @GetMapping("/json")
    @ResponseBody
    public List<ArticuloEntity>listarArticulosJson(){
        return articuloService.listarArticulos();
    }

    //El mapeo de obtener articulo JSON
    @GetMapping("/json/{id}")
    @ResponseBody
    public ArticuloEntity obtenerArticulosJson(@PathVariable Long id){
        return articuloService.obtenerArticuloPorId(id);
    }
}
