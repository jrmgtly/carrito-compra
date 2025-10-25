package com.carrito_compra.progra.service;

import com.carrito_compra.progra.entity.CarroEntity;
import com.carrito_compra.progra.entity.SelectorEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class CarroService implements CarroInterfaceService {

    private CarroEntity carroEntity;

    public CarroService() {
        this.carroEntity = new CarroEntity();
    }

    @Override
    public void agregarCarro(SelectorEntity articulo) {
        boolean encontrado = false;

        for (SelectorEntity item : carroEntity.getSelect()) {
            if (item.getArticulo() != null &&
                    item.getArticulo().getId().equals(articulo.getArticulo().getId())) {
                // Si el artículo ya existe, sumamos la cantidad
                item.setCantidad(item.getCantidad() + articulo.getCantidad());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            // Si no existía, lo agregamos como nuevo
            carroEntity.agregarArticulo(articulo);
        }
    }

    @Override
    public CarroEntity obtenerCarro() {
        return carroEntity;
    }

    @Override
    public void vaciarCarro() {
        this.carroEntity = new CarroEntity();
    }

    @Override
    public void eliminarArticulo(Long articuloId) {
        Iterator<SelectorEntity> iterator = carroEntity.select.iterator();

        while (iterator.hasNext()) {
            SelectorEntity item = iterator.next();
            if (item.getArticulo() != null &&
                    item.getArticulo().getId().equals(articuloId)) {
                iterator.remove();
                break;
            }
        }
    }
}
