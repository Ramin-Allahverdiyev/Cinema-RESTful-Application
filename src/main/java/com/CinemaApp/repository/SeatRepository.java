package com.CinemaApp.repository;

import com.CinemaApp.entity.Category;
import com.CinemaApp.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
    @Query("SELECT COUNT(s) FROM Seat s WHERE s.hall.id = :hallId")
    Long countSeatsByHallId(Integer hallId);

    List<Seat> findAllBySeatStatus(int seatStatus);
    Optional<Seat> findByIdAndSeatStatus(int id, int status);
}
