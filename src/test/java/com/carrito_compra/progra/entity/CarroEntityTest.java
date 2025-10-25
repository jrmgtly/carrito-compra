package com.carrito_compra.progra.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarroEntityTest {

    private CarroEntity carroEntity;

    @BeforeEach
    public void setUp() {
        carroEntity = new CarroEntity();
    }

    @Test
    public void testAgregarArticulo() {
        SelectorEntity articulo = new SelectorEntity(100.0);
        carroEntity.agregarArticulo(articulo);

        assertEquals(1, carroEntity.select.size(), "El carro debe tener un artículo.");
    }

    @Test
    public void testGetTotal() {
        carroEntity.agregarArticulo(new SelectorEntity(100.0));
        carroEntity.agregarArticulo(new SelectorEntity(50.0));

        double total = carroEntity.getTotal();

        assertEquals(150.0, total, "El total debe ser 150.0.");
    }

    @Test
    public void testGetTotalSinArticulos() {
        double total = carroEntity.getTotal();

        assertEquals(0.0, total, "El total debe ser 0.0 si no hay artículos.");
    }

}