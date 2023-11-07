package com.CinemaApp.repository;

import com.CinemaApp.entity.Category;
import com.CinemaApp.entity.Session;
import com.CinemaApp.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    List<Ticket> findAllByTicketStatus(int ticketStatus);
    Optional<Ticket> findByIdAndTicketStatus(int id, int status);
}
