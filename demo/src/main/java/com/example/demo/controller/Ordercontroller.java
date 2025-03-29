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

import com.example.demo.entity.Orders;
import com.example.demo.service.OrdersService;

@RestController
@RequestMapping("/api")
public class Ordercontroller {
    @Autowired
    OrdersService service;
    @GetMapping("/orders")
    public List<Orders> getUsers(){
        return service.getUsers();
    }
    @GetMapping("/ord")
    public Page<Orders> paginated(@RequestParam(defaultValue = "0") int page ,@RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "id") String sortby, @RequestParam(defaultValue = "true") boolean sortorder){
        return service.paginated(page,size,sortby,sortorder);
    }
    @PostMapping("/order")
        public Orders addUsers(@RequestBody Orders o){
            return service.addUsers(o);
        }    
        @PutMapping("/orders")
        public Orders UpdateOrders(@RequestParam int id, @RequestBody Orders o) {
            return service.UpdateOrders(id, o);
        }
        
        @DeleteMapping("/order")
            public String DeleteOrders(@RequestParam int id){
                return service.DeleteOrders(id);
            }
            @GetMapping("/ordersByStatus")
public List<Orders> getOrdersByStatus(@RequestParam String status) {
    return service.getOrdersByStatus(status);
}

}
