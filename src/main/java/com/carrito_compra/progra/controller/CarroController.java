package com.carrito_compra.progra.controller;

import com.carrito_compra.progra.entity.ArticuloEntity;
import com.carrito_compra.progra.entity.CarroEntity;
import com.carrito_compra.progra.entity.SelectorEntity;
import com.carrito_compra.progra.service.ArticuloInterfaceService;
import com.carrito_compra.progra.service.CarroInterfaceService;
import com.carrito_compra.progra.service.CarroService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/carro")
public class CarroController {

    private final CarroInterfaceService carroService;
    private final ArticuloInterfaceService articuloService;

    public CarroController(CarroInterfaceService carroService, ArticuloInterfaceService articuloService) {
        this.carroService = carroService;
        this.articuloService = articuloService;
    }

    @GetMapping
    public String verCarro(Model model){
        CarroEntity carroEntity = carroService.obtenerCarro();
        model.addAttribute("carro", carroEntity);
        return "carro";
    }

    @GetMapping("json")
    @ResponseBody
    public CarroEntity obtenerCarroJson(){
        return carroService.obtenerCarro();
    }

    @GetMapping("/json/{item}")
    @ResponseBody
    public List<SelectorEntity> obtenerItemsJSON(){
        return carroService.obtenerCarro().select;
    }

    @PostMapping("/agregar")
    public String agregarArticulo(@RequestParam Long articuloId){
        ArticuloEntity a = articuloService.obtenerArticuloPorId(articuloId);

        if(a != null){
            SelectorEntity item = new SelectorEntity(1, a);
            carroService.agregarCarro(item);
        }
        return "redirect:/carro";
    }

    @PostMapping("/eliminar")
    public String eliminarArticulo(@RequestParam Long articuloId){
        carroService.eliminarArticulo(articuloId);
        return  "redirect:/carro";
    }

    @PostMapping("/vaciar")
    public String vaciarCarro() {
        carroService.vaciarCarro();
        return "redirect:/carro";
    }
}
