package com.carrito_compra.progra.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "articulos")
@Data
public class ArticuloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;
    private String imagen;

    //Creacion de constructor vacio
    public ArticuloEntity() {
    }

    //Creacion de constructor con atributos
    public ArticuloEntity(Long id, String nombre, double precio, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public double getPrecio(){return precio;}
    public void setPrecio(double precio){this.precio=precio;}

}
