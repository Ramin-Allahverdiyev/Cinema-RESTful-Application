package com.CinemaApp.repository;

import com.CinemaApp.entity.Category;
import com.CinemaApp.entity.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType,Integer> {
    List<SeatType> findAllBySeatTypeStatus(int seatTypeStatus);
    Optional<SeatType> findByIdAndSeatTypeStatus(int id, int status);
}
