package com.CinemaApp.service.impl;

import com.CinemaApp.Model.ExistStatus;
import com.CinemaApp.dto.request.SessionRequest;
import com.CinemaApp.dto.response.SessionResponse;
import com.CinemaApp.exception.NotFoundException;
import com.CinemaApp.mapper.SessionMapper;
import com.CinemaApp.repository.SessionRepository;
import com.CinemaApp.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    @Override
    public SessionResponse saveSession(SessionRequest request) {
        var session = SessionMapper.INSTANCE.dtoToEntity(request);
        var savedSession = sessionRepository.save(session);
        return SessionMapper.INSTANCE.entityToDto(savedSession);
    }

    @Override
    public SessionResponse getSession(int id) {
        var session = sessionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Session is not found for this id!"));
        return SessionMapper.INSTANCE.entityToDto(session);
    }

    @Override
    public SessionResponse updateSession(int id, SessionRequest request) {
        var session = sessionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Session is not found for this id!"));
        SessionMapper.INSTANCE.dtoToEntity(session,request);
        var updatedSession = sessionRepository.save(session);
        return SessionMapper.INSTANCE.entityToDto(updatedSession);
    }

    @Override
    public List<SessionResponse> getAllSessions() {
        var allSessions = sessionRepository.findAllBySessionStatus(ExistStatus.ACTIVE.getId());
        return SessionMapper.INSTANCE.entityListToDtoList(allSessions);
    }

    @Override
    public void deleteSession(int id) {
        var session = sessionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Session is not found for this id!"));
        session.setSessionStatus(ExistStatus.DEACTIVE.getId());
        sessionRepository.save(session);
    }
}
