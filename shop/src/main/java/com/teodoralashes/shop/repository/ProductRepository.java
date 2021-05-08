package com.teodoralashes.shop.repository;

import com.teodoralashes.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {

    Optional<Product> findOneById (Long id);
    Optional <Product> findOneByModel (String model);
}
