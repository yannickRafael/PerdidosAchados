package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.Session;
import com.sfs.perdidosachados.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    public Optional<Session> findById(int id) {
        return sessionRepository.findById(id);
    }

    public Session save(Session session) {
        return sessionRepository.save(session);
    }

    public void deleteById(int id) {
        sessionRepository.deleteById(id);
    }

    public Optional<Session> update(int id, Session session) {
        Optional<Session> sessionOptional = sessionRepository.findById(id);
        if (sessionOptional.isPresent()) {
            Session sessionToUpdate = sessionOptional.get();
            BeanUtils.copyProperties(session, sessionToUpdate, "id");
            sessionRepository.save(sessionToUpdate);
            return Optional.of(sessionToUpdate);
        }
        return Optional.empty();
    }
}
