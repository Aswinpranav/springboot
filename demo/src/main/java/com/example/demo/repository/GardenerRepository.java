package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Gardener;
import java.util.List;

@Repository
public interface GardenerRepository extends JpaRepository<Gardener, Integer> {

    @Query("SELECT g FROM Gardener g WHERE g.specialization = :specialization")
    List<Gardener> findBySpecialization(@Param("specialization") String specialization);
}
