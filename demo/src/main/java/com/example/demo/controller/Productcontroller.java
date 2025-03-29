package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class Productcontroller {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getUsers();
    }

    @GetMapping("/prod")
    public Page<Product> paginated(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String sortby,
                                   @RequestParam(defaultValue = "true") boolean sortorder) {
        return service.paginated(page, size, sortby, sortorder);
    }

    @PostMapping("/product")
    public Object addProduct(@RequestBody Product u) {
        return service.addUsers(u); 
    }

    @PutMapping("/products")
    public Object UpdateProduct(@RequestParam int id, @RequestBody Product u) {
        return service.UpdateProduct(id, u);
    }

    @DeleteMapping("/product")
    public String DeleteProduct(@RequestParam int id) {
        return service.DeleteProduct(id);
    }

    @GetMapping("/productsByName")
    public List<Product> getProductsByName(@RequestParam String name) {
        return service.getProductsByName(name);
    }
}
