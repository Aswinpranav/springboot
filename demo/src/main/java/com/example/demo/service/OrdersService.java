package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Orders;
import com.example.demo.repository.OrderRepository;

@Service
public class OrdersService{

    @Autowired
    OrderRepository repo;


    public Orders addUsers(Orders o){
        return repo.save(o);
    }

    public List<Orders> getUsers(){
        return repo.findAll();
    }
    
    public Orders UpdateOrders(int id,Orders o){
        o.setId(id);
        return repo.save(o);
    }
    public String DeleteOrders(int id){
       repo.deleteById(id);
       return "deleted Successfully";
    }
     public Page<Orders> paginated(int page,int size,String sortBy,boolean sortOrder){
        Sort sort = sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable=PageRequest.of(page,size,sort);
        return repo.findAll(pageable);
    }
    public List<Orders> getOrdersByStatus(String status) {
        return repo.findByStatus(status);
    }
    
}