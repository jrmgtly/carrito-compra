package com.carrito_compra.progra.entity;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class CarroEntity {

    public List<SelectorEntity> select = new ArrayList<>();
    public void agregarArticulo(SelectorEntity Articulo){
        select.add(Articulo);
    }
    public double getTotal(){
        return select.stream().mapToDouble(SelectorEntity::getSubtotal).sum();
    }
}
