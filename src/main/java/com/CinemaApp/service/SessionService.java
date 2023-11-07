package com.CinemaApp.service;

import com.CinemaApp.dto.request.SessionRequest;
import com.CinemaApp.dto.response.SessionResponse;

import java.util.List;

public interface SessionService {
    SessionResponse saveSession(SessionRequest request);
    SessionResponse getSession(int id);
    SessionResponse updateSession(int id, SessionRequest request);
    List<SessionResponse> getAllSessions();
    void deleteSession(int id);
}
