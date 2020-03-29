package com.items.apirest.service.serviceImpl;

import java.util.List;

import com.items.apirest.model.Product;
import com.items.apirest.repository.ProductRepository;
import com.items.apirest.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository; 


    @Override
    public List<Product> findAll() {
        
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        
        return productRepository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);

    }
    
}