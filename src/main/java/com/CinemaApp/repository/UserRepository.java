package com.CinemaApp.repository;

import com.CinemaApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAllByStatus(boolean status);
    Optional<User> findByUsername(String username);
}
