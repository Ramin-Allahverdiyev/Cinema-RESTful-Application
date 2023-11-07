package com.CinemaApp.service;

import com.CinemaApp.dto.request.TicketRequest;
import com.CinemaApp.dto.response.TicketResponse;

import java.util.List;

public interface TicketService {
    TicketResponse saveTicket(TicketRequest request);
    TicketResponse getTicket(int id);
    TicketResponse updateTicket(int id, TicketRequest request);
    List<TicketResponse> getAllTickets();
    void deleteTicket(int id);
}
