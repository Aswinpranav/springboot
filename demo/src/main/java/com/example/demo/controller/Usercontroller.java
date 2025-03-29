package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class Usercontroller {
    @Autowired
    UserService service;

    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/use")
    public Page<User> paginated(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size,
                                @RequestParam(defaultValue = "id") String sortby,
                                @RequestParam(defaultValue = "true") boolean sortorder) {
        return service.paginated(page, size, sortby, sortorder);
    }

    @GetMapping("/usersByEmail")
    public List<User> getUsersByEmail(@RequestParam String email) {
        return service.getUsersByEmail(email);
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUsers(@RequestBody User u) {
        Object result = service.addUsers(u);
        if (result instanceof String) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/user")
    public ResponseEntity<?> UpdateUser(@RequestParam int id, @RequestBody User u) {
        Object result = service.UpdateUser(id, u);
        if (result instanceof String) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/user")
    public ResponseEntity<?> DeleteUser(@RequestParam int id) {
        Object result = service.DeleteUser(id);
        if (result instanceof String) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
