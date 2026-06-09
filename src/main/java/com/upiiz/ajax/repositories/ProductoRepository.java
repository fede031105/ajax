package com.upiiz.ajax.repositories;

import com.upiiz.ajax.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {

}