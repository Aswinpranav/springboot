package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import com.example.demo.entity.Gardener;
import com.example.demo.entity.Orders;
import com.example.demo.repository.GardenerRepository;

@Service
public class GardenerService {

    @Autowired
    GardenerRepository repo;

    @PersistenceContext
    private EntityManager entityManager;

    public Gardener addUsers(Gardener g) {
        List<Orders> orders = g.getOrders();
        for(Orders order : orders){
            if(order != null){
                order.setGardener(g);
            }
        }
        return repo.save(g);
    }

    public List<Gardener> getUsers() {
        return repo.findAll();
    }

    @Transactional
    public Gardener updateGardener(int id, Gardener updatedGardener) {
        Gardener existingGardener = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Gardener not found with ID: " + id));

        // Update properties
        existingGardener.setName(updatedGardener.getName());
        existingGardener.setSpecialization(updatedGardener.getSpecialization());
        existingGardener.setOrders(updatedGardener.getOrders());

        return repo.save(existingGardener);
    }

    public String deleteGardener(int id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    public Page<Gardener> paginated(int page, int size, String sortBy, boolean sortOrder) {
        Sort sort = sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return repo.findAll(pageable);
    }

    public List<Gardener> getGardenersBySpecialization(String specialization) {
        return repo.findBySpecialization(specialization);
    }
}
