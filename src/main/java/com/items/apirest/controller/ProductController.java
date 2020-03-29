package com.items.apirest.controller;

import java.util.List;

import com.items.apirest.model.Product;
import com.items.apirest.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/")
@Api(value="PRODUCTS API REST")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping(value = "products", method = RequestMethod.GET)
    @ApiOperation(value = "It returns every item into to database")
    public List<Product> listAll() {

        return service.findAll();

    }

    @RequestMapping(value = "products", method = RequestMethod.POST)
    @ApiOperation(value = "it adds a new item into the list just switching the request method")
    public Product save(@RequestBody Product product){

        return service.save(product); 
    }

    @DeleteMapping(value = "products/{id}")
    @ApiOperation(value = "It deletes an item by id")
    public void delete(@PathVariable("id") long id){

         service.delete(id); 
    }

    @PutMapping(value = "products")
    @ApiOperation(value = "It updates an already existent item ")
    public Product update(@RequestBody Product product){
        return service.save(product);
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "It returns a specifc item by id")
    public Product findById(@PathVariable("id") long id){
        return service.findById(id);
    }


}