package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Status;
import com.sfs.perdidosachados.model.Status;
import com.sfs.perdidosachados.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping()
    public ResponseEntity<?> getall() {
        return ResponseEntity.status(HttpStatus.FOUND).body(statusService.findAll());
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> get(@RequestParam int id) {
        try {
            Optional<Status> status = statusService.findById(id);
            if (status.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(status.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Status not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Status status) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(statusService.save(status));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody Status status) {
        try {
            Optional<Status> updatedStatus = statusService.update(id, status);
            if (updatedStatus.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(updatedStatus.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Status not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int id) {
        try {
            Optional<Status> status = statusService.findById(id);
            if (status.isPresent()) {
                statusService.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Status deleted successfully");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Status not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
