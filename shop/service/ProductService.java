package com.teodoralashes.shop.service;


import com.teodoralashes.shop.dto.CreateProductDTO;
import com.teodoralashes.shop.dto.EditProductDTO;
import com.teodoralashes.shop.dto.ProductResponseDTO;
import com.teodoralashes.shop.model.Product;
import com.teodoralashes.shop.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    public ProductResponseDTO edit(EditProductDTO requestDTO) {
        Product product = this.findOneById(requestDTO.getId());

        product = this.modelMapper.map(requestDTO, Product.class);

        product = this.productRepository.save(product);

        return this.modelMapper.map(product, ProductResponseDTO.class);
    }

    public void delete(Long id) {
        Product product = this.findOneById(id);

        product.setDeleted(!product.isDeleted());

        product = this.productRepository.save(product);
    }

    public ProductResponseDTO getById (Long id) {
        Product product = this.findOneById(id);

        return this.modelMapper.map(product, ProductResponseDTO.class);
    }

    public List<ProductResponseDTO> getAll() {
        List<Product> list = this.productRepository.findAll();

        List<ProductResponseDTO> listDTO = new ArrayList<>();
        for(Product product : list) {
            listDTO.add(this.modelMapper.map(product, ProductResponseDTO.class));
        }

        return listDTO;
    }

    public Product findOneById(Long id) {
        return this.productRepository.findOneById(id).orElseThrow(() -> new EntityNotFoundException("Proizvod sa tim ID-em ne postoji!"));
    }
    public ProductResponseDTO create (CreateProductDTO requestDTO){
        Product product = new Product();
        product.setCategory(requestDTO.getCategory());
        product.setCount(requestDTO.getCount());
        product.setLength(requestDTO.getLength());
        product.setModel(requestDTO.getModel());
        product.setPrice(requestDTO.getPrice());
        product.setImgUrl(requestDTO.getImgUrl());
        product.setDescription(requestDTO.getDescription());
        
        product= this.productRepository.save(product);
        return this.modelMapper.map(product, ProductResponseDTO.class);

    }

}
