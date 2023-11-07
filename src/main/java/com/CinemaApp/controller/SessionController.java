package com.CinemaApp.controller;

import com.CinemaApp.dto.request.SessionRequest;
import com.CinemaApp.dto.response.SessionResponse;
import com.CinemaApp.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${root.url}/session")
@RequiredArgsConstructor
public class SessionController {
    private final SessionService sessionService;

    @PostMapping("/save")
    public SessionResponse saveSession(@RequestBody SessionRequest request){
        return sessionService.saveSession(request);
    }
    @GetMapping("/{id}")
    public SessionResponse getSession(@PathVariable int id){
        return sessionService.getSession(id);
    }

    @PutMapping("/{id}")
    public SessionResponse updateSession(@PathVariable int id,@RequestBody SessionRequest request){
        return sessionService.updateSession(id,request);
    }

    @GetMapping("/all")
    public List<SessionResponse> getAllSessions(){
        return sessionService.getAllSessions();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSession(@PathVariable int id) {
        sessionService.deleteSession(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
