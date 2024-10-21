package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Local;
import com.sfs.perdidosachados.model.Local;
import com.sfs.perdidosachados.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping()
    public ResponseEntity<?> getall() {
        return ResponseEntity.status(HttpStatus.FOUND).body(localService.findAll());
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> get(@RequestParam int id) {
        try {
            Optional<Local> local = localService.findById(id);
            if (local.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(local.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Local not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Local local) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(localService.save(local));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody Local local) {
        try {
            Optional<Local> updatedLocal = localService.update(id, local);
            if (updatedLocal.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(updatedLocal.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Local not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int id) {
        try {
            Optional<Local> local = localService.findById(id);
            if (local.isPresent()) {
                localService.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Local deleted successfully");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Local not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
