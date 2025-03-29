package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Gardener;
import com.example.demo.service.GardenerService;

@RestController
@RequestMapping("/api")
public class Gardenercontroller {  // Fixed class name
    @Autowired
    GardenerService service;

    @GetMapping("/gardeners")
    public List<Gardener> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/gard")
    public Page<Gardener> paginated(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "id") String sortBy,
                                    @RequestParam(defaultValue = "true") boolean sortOrder) {
        return service.paginated(page, size, sortBy, sortOrder);
    }

    @PostMapping("/gardener")
    public Gardener addUsers(@RequestBody Gardener g) {
        return service.addUsers(g);
    }    

    @PutMapping("/gardeners")
    public Gardener updateGardener(@RequestParam int id, @RequestBody Gardener g) {
        return service.updateGardener(id, g);
    }
        
    @DeleteMapping("/gardener")
    public String deleteGardener(@RequestParam int id) {
        return service.deleteGardener(id);
    }

    @GetMapping("/gardenersBySpecialization")
    public List<Gardener> getGardenersBySpecialization(@RequestParam String specialization) {
        return service.getGardenersBySpecialization(specialization);
    }
}
