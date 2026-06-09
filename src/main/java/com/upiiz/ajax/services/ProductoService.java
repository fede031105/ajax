package com.upiiz.ajax.services;

import com.upiiz.ajax.entities.ProductoEntity;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    //Metodos - La Carta del Restaurant
    List<ProductoEntity> listado();
    Optional<ProductoEntity> productoPorId(Long id);
    ProductoEntity agregarProducto(ProductoEntity producto);
    ProductoEntity actualizarProducto(Long Id, ProductoEntity producto);
    void eliminarProducto(Long id);
}