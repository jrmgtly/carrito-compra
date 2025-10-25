package com.carrito_compra.progra.repository;

import com.carrito_compra.progra.entity.ArticuloEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ArticuloRepository extends JpaRepository<ArticuloEntity, Long>{

}
