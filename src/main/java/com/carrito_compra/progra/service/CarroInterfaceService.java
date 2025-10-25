package com.carrito_compra.progra.service;

import com.carrito_compra.progra.entity.CarroEntity;
import com.carrito_compra.progra.entity.SelectorEntity;

public interface CarroInterfaceService {

    void agregarCarro(SelectorEntity articulo);

    CarroEntity obtenerCarro();
    void vaciarCarro();
    void eliminarArticulo(Long articuloId);

}
