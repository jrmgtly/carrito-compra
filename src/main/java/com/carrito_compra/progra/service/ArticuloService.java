package com.carrito_compra.progra.service;

import com.carrito_compra.progra.entity.ArticuloEntity;
import com.carrito_compra.progra.repository.ArticuloRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ArticuloService implements ArticuloInterfaceService{

    private final ArticuloRepository articuloRepository;

    //Spring crea e inyecta las instancias de clases / inyecciones de dependencias automaticas
    @Autowired
    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override
    public List<ArticuloEntity> listarArticulos() {
        return articuloRepository.findAll();
    }

    @Override
    public ArticuloEntity obtenerArticuloPorId(Long id) {
        if (id == null) return null;
        Optional<ArticuloEntity>articulo = articuloRepository.findById(id);
        return articulo.orElse(null);
    }

    @Override
    public ArticuloEntity guardar(ArticuloEntity articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public void borrar(Long id) {
        articuloRepository.deleteById(id);
    }
}
