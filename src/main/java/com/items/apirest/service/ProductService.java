package com.items.apirest.service;

import java.util.List;

import com.items.apirest.model.Product;

public interface ProductService {

    List<Product> findAll(); 

    Product findById(Long id); 

    Product save(Product product);

    void delete(Long id); 




    


}