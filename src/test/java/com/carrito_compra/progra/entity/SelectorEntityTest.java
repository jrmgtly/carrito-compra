package com.carrito_compra.progra.entity;

import com.carrito_compra.progra.entity.ArticuloEntity;
import com.carrito_compra.progra.entity.SelectorEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SelectorEntityTest {


    private ArticuloEntity articulo;
    private SelectorEntity selectorEntity;

    @BeforeEach
    public void setUp() {
        // Inicializamos el articulo
        articulo = new ArticuloEntity(1L, "Camiseta", 19.99, "camiseta.jpg");
        // Inicializamos el SelectorEntity
        selectorEntity = new SelectorEntity(3, articulo); // 3 camisetas
    }

    @Test
    public void testConstructor() {
        assertNotNull(selectorEntity, "El SelectorEntity no debe ser nulo.");
        assertEquals(3, selectorEntity.getCantidad(), "La cantidad debe ser 3.");
        assertEquals(articulo, selectorEntity.getArticulo(), "El artículo debe ser el esperado.");
    }

    @Test
    public void testGetSubtotal() {
        // El subtotal debe ser el precio del artículo por la cantidad
        double subtotalEsperado = articulo.getPrecio() * selectorEntity.getCantidad();
        assertEquals(subtotalEsperado, selectorEntity.getSubtotal(), 0.01, "El subtotal debe ser correcto.");
    }

    @Test
    public void testGetSubtotalSinArticulo() {
        // Probar caso donde el artículo es nulo
        SelectorEntity selectorSinArticulo = new SelectorEntity(3, null); // 3 camisetas, pero artículo es nulo
        assertEquals(0.0, selectorSinArticulo.getSubtotal(), "El subtotal debe ser 0 si no hay artículo.");
    }

    @Test
    public void testToString() {
        String expectedString = "SelectorEntity(articulo=ArticuloEntity(id=1, nombre=Camiseta, precio=19.99, imagen=camiseta.jpg), cantidad=3)";
        assertEquals(expectedString, selectorEntity.toString(), "El método toString() no devuelve el valor esperado.");
    }

}