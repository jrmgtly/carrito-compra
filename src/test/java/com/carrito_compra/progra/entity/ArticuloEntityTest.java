package com.carrito_compra.progra.entity;

import com.carrito_compra.progra.entity.ArticuloEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArticuloEntityTest {

    private ArticuloEntity articulo;

    @BeforeEach
    public void setUp() {
        // Inicializamos un ArticuloEntity con los valores del constructor
        articulo = new ArticuloEntity(1L, "Camiseta", 19.99, "camiseta.jpg");
    }

    @Test
    public void testArticuloEntityConstructorConParametros() {
        assertNotNull(articulo, "El artículo no debe ser nulo.");
        assertEquals(1L, articulo.getId(), "El ID debe ser 1.");
        assertEquals("Camiseta", articulo.getNombre(), "El nombre debe ser 'Camiseta'.");
        assertEquals(19.99, articulo.getPrecio(), 0.01, "El precio debe ser 19.99.");
        assertEquals("camiseta.jpg", articulo.getImagen(), "La imagen debe ser 'camiseta.jpg'.");
    }

    @Test
    public void testArticuloEntityConstructorVacio() {
        // Crear el artículo usando el constructor vacío
        ArticuloEntity articuloVacio = new ArticuloEntity();

        assertNull(articuloVacio.getId(), "El ID debe ser nulo.");
        assertNull(articuloVacio.getNombre(), "El nombre debe ser nulo.");
        assertEquals(0.0, articuloVacio.getPrecio(), 0.01, "El precio debe ser 0.0.");
        assertNull(articuloVacio.getImagen(), "La imagen debe ser nula.");
    }

    @Test
    public void testSettersAndGetters() {
        articulo.setNombre("Pantalón");
        articulo.setPrecio(29.99);

        assertEquals("Pantalón", articulo.getNombre(), "El nombre debe haber sido actualizado.");
        assertEquals(29.99, articulo.getPrecio(), 0.01, "El precio debe haber sido actualizado.");
    }

    @Test
    public void testToString() {
        String expectedString = "ArticuloEntity(id=1, nombre=Camiseta, precio=19.99, imagen=camiseta.jpg)";

        // Verificamos que el toString() de Lombok devuelve la representación correcta
        assertEquals(expectedString, articulo.toString(), "El método toString() no devuelve el valor esperado.");

    }
}