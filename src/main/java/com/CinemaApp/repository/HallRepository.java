package com.CinemaApp.repository;

import com.CinemaApp.entity.Category;
import com.CinemaApp.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HallRepository extends JpaRepository<Hall,Integer> {
    List<Hall> findAllByHallStatus(int hallStatus);
    Optional<Hall> findByIdAndHallStatus(int id, int status);
}
