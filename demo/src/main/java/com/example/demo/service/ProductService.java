package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public String getMesg() {
        return "Hello World";
    }

    public Object addUsers(Product p) {
      
        Optional<Product> existingProduct = repo.findById(p.getId());
        if (existingProduct.isPresent()) {
            return "Duplicate ID: ID already exists";
        }

        return repo.save(p);
    }

    public List<Product> getUsers() {
        return repo.findAll();
    }

    public Object UpdateProduct(int id, Product p) {
        if (id < 0) {
            return "Invalid ID: ID cannot be negative";
        }
        p.setId(id);
        return repo.save(p);
    }

    public String DeleteProduct(int id) {
        if (id < 0) {
            return "Invalid ID: ID cannot be negative";
        }
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    public Page<Product> paginated(int page, int size, String sortBy, boolean sortOrder) {
        Sort sort = sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return repo.findAll(pageable);
    }

    public List<Product> getProductsByName(String name) {
        return repo.findByName(name);
    }
}
