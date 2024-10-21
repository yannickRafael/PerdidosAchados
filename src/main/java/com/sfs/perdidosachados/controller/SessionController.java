package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Session;
import com.sfs.perdidosachados.model.Session;
import com.sfs.perdidosachados.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping()
    public ResponseEntity<?> getall() {
        return ResponseEntity.status(HttpStatus.FOUND).body(sessionService.findAll());
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> get(@RequestParam int id) {
        try {
            Optional<Session> session = sessionService.findById(id);
            if (session.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(session.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Session session) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(sessionService.save(session));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody Session session) {
        try {
            Optional<Session> updatedSession = sessionService.update(id, session);
            if (updatedSession.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(updatedSession.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int id) {
        try {
            Optional<Session> session = sessionService.findById(id);
            if (session.isPresent()) {
                sessionService.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Session deleted successfully");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
