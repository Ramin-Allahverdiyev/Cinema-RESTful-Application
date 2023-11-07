package com.CinemaApp.repository;

import com.CinemaApp.entity.Category;
import com.CinemaApp.entity.SeatType;
import com.CinemaApp.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session,Integer> {
    List<Session> findAllBySessionStatus(int sessionStatus);
    Optional<Session> findByIdAndSessionStatus(int id, int status);
}
