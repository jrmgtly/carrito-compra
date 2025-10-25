package com.carrito_compra.progra.service;

import com.carrito_compra.progra.entity.ArticuloEntity;
import java.util.List;

public interface ArticuloInterfaceService {

    List<ArticuloEntity> listarArticulos();
    ArticuloEntity obtenerArticuloPorId(Long id);
    ArticuloEntity guardar(ArticuloEntity articulo);
    void borrar(Long id);

}
