package com.example.demo.service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public String getMesg() {
        return "Hello World";
    }

    public Object addUsers(User u) {
        if (u.getId() < 0) {
            return "Invalid ID: ID cannot be negative";
        }
        if (!Pattern.matches(EMAIL_REGEX, u.getEmail())) {
            return "Invalid Email: Email format is incorrect";
        }
        // Check for duplicate ID
        Optional<User> existingUser = repo.findById(u.getId());
        if (existingUser.isPresent()) {
            return "Duplicate ID: ID already exists";
        }

        return repo.save(u);
    }

    public List<User> getUsers() {
        return repo.findAll();
    }

    public Object UpdateUser(int id, User u) {
        if (id < 0) {
            return "Invalid ID: ID cannot be negative";
        }
        if (!Pattern.matches(EMAIL_REGEX, u.getEmail())) {
            return "Invalid Email: Email format is incorrect";
        }
        u.setId(id);
        return repo.save(u);
    }

    public String DeleteUser(int id) {
        if (id < 0) {
            return "Invalid ID: ID cannot be negative";
        }
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    public Page<User> paginated(int page, int size, String sortBy, boolean sortOrder) {
        Sort sort = sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return repo.findAll(pageable);
    }

    public List<User> getUsersByEmail(String email) {
        return repo.findByEmail(email);
    }
}
