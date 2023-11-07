package com.CinemaApp.service.impl;

import com.CinemaApp.Model.ExistStatus;
import com.CinemaApp.dto.request.TicketRequest;
import com.CinemaApp.dto.response.TicketResponse;
import com.CinemaApp.exception.NotFoundException;
import com.CinemaApp.mapper.TicketMapper;
import com.CinemaApp.repository.TicketRepository;
import com.CinemaApp.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    @Override
    public TicketResponse saveTicket(TicketRequest request) {
        var ticket = TicketMapper.INSTANCE.dtoToEntity(request);
        var savedTicket = ticketRepository.save(ticket);
        return TicketMapper.INSTANCE.entityToDto(savedTicket);
    }

    @Override
    public TicketResponse getTicket(int id) {
        var ticket = ticketRepository.findByIdAndTicketStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Ticket is not found for this id!"));
        return TicketMapper.INSTANCE.entityToDto(ticket);
    }

    @Override
    public TicketResponse updateTicket(int id, TicketRequest request) {
        var ticket = ticketRepository.findByIdAndTicketStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Ticket is not found for this id!"));
        TicketMapper.INSTANCE.dtoToEntity(ticket,request);
        var updatedTicket = ticketRepository.save(ticket);
        return TicketMapper.INSTANCE.entityToDto(updatedTicket);
    }

    @Override
    public List<TicketResponse> getAllTickets() {
        var allTickets = ticketRepository.findAllByTicketStatus(ExistStatus.ACTIVE.getId());
        return TicketMapper.INSTANCE.entityListToDtoList(allTickets);
    }

    @Override
    public void deleteTicket(int id) {
        var ticket = ticketRepository.findByIdAndTicketStatus(id,ExistStatus.ACTIVE.getId())
                .orElseThrow(() -> new NotFoundException("Ticket is not found for this id!"));
        ticket.setTicketStatus(ExistStatus.DEACTIVE.getId());
        ticketRepository.save(ticket);
    }
}
