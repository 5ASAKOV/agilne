package com.teodoralashes.shop.controller;

import com.teodoralashes.shop.dto.CreateProductDTO;
import com.teodoralashes.shop.dto.EditProductDTO;
import com.teodoralashes.shop.dto.ProductResponseDTO;
import com.teodoralashes.shop.dto.SignUpDTO;
import com.teodoralashes.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/products")
@CrossOrigin("http://localhost:3000")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping ("/{id}")
    public ResponseEntity<ProductResponseDTO>  handleGetOneById (@PathVariable("id") Long id) {
        return new ResponseEntity<ProductResponseDTO>( productService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> handleGetAll() {
        return new ResponseEntity<List<ProductResponseDTO>> (productService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void handleDelete(@PathVariable("id") Long id) {
        this.productService.delete(id);
    }

    @PutMapping
    public ResponseEntity<ProductResponseDTO> handleEdit(@RequestBody EditProductDTO requestDTO) {
        return new ResponseEntity<ProductResponseDTO> (productService.edit(requestDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO>  handleCreate (@RequestBody CreateProductDTO requestDTO) {
        return new ResponseEntity<ProductResponseDTO>( productService.create(requestDTO), HttpStatus.CREATED);
    }
}
