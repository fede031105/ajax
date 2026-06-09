package com.upiiz.ajax.services;

import com.upiiz.ajax.entities.ProductoEntity;
import com.upiiz.ajax.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{
    //Chef
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoEntity> listado() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<ProductoEntity> productoPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public ProductoEntity agregarProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public ProductoEntity actualizarProducto(Long Id, ProductoEntity producto) {
        producto.setId(Id);
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}