package com.carrito_compra.progra.entity;

import lombok.Data;

@Data
public class SelectorEntity {

    private ArticuloEntity articulo;
    private int cantidad;

    //Creacion de constructor
    public SelectorEntity(int cantidad, ArticuloEntity articulo) {
        this.cantidad = cantidad;
        this.articulo = articulo;
    }

    //Creacion de constructor vacio
    public SelectorEntity(double v) {
    }

    //Funcion extra para calcular el sub total de la compra
    public double getSubtotal() {
        if(articulo == null){
            return 0;
        }
        return articulo.getPrecio() * cantidad;
    }
}
