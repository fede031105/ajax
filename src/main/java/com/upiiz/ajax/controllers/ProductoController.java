package com.upiiz.ajax.controllers;

import com.upiiz.ajax.entities.ProductoEntity;
import com.upiiz.ajax.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {

    //Que inyectamos
    @Autowired
    private ProductoService productoService;

    //Tradicional- Solo me regresa la pagina sin datos
    @GetMapping("/productos")
    public String productos(){
        return "productos";
    }

    //CRUD - Usando AJAX
    //Usando AJAX
    //R - Leer - Listado de Productos usando AJAX
    @GetMapping("/productos/api/productos")
    @ResponseBody
    public ResponseEntity<List<ProductoEntity>> listadoProductosAJAX(){
        return ResponseEntity.ok(productoService.listado());
    }

    //R - Leer - Un producto por su id
    @GetMapping("/productos/api/productos/{id}")
    @ResponseBody
    public ResponseEntity<Optional<ProductoEntity>> productoByIdAJAX(@PathVariable Long id){
        return ResponseEntity.ok(productoService.productoPorId(id));
    }

    //C - Crear - Agregar producto usando AJAX
    @PostMapping("/productos/api/productos")
    @ResponseBody
    public ResponseEntity<ProductoEntity> crearProductosAJAX(@RequestBody ProductoEntity producto){
        return ResponseEntity.ok(productoService.agregarProducto(producto));
    }

    //U - Update - Actualizar producto usando AJAX
    @PatchMapping("/productos/api/productos/{id}")
    @ResponseBody
    public ResponseEntity<ProductoEntity> actualizarProductoAJAX(@PathVariable Long id, @RequestBody ProductoEntity producto){
        return ResponseEntity.ok(productoService.actualizarProducto(id,producto));
    }

    //D - Delete - Eliminar producto usando AJAX
    @DeleteMapping("/productos/api/productos/{id}")
    @ResponseBody
    public void eliminarProductoAJAX(@PathVariable Long id){
        productoService.eliminarProducto(id);
    }

}