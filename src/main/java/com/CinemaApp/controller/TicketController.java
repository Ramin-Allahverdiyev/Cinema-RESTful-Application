package com.CinemaApp.controller;

import com.CinemaApp.dto.request.TicketRequest;
import com.CinemaApp.dto.response.TicketResponse;
import com.CinemaApp.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/ticket")
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public TicketResponse saveTicket(@RequestBody TicketRequest request){
        return ticketService.saveTicket(request);
    }
    @GetMapping("/{id}")
    public TicketResponse getHall(@PathVariable int id){
        return ticketService.getTicket(id);
    }

    @PutMapping("/{id}")
    public TicketResponse updateHall(@PathVariable int id,@RequestBody TicketRequest request){
        return ticketService.updateTicket(id,request);
    }

    @GetMapping("/all")
    public List<TicketResponse> getAllHalls(){
        return ticketService.getAllTickets();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHall(@PathVariable int id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
