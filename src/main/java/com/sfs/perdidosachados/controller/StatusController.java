package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Status;
import com.sfs.perdidosachados.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        try {
            List<Status> statuses = statusService.findAll();
            return ResponseEntity.status(HttpStatus.FOUND).body(statuses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch statuses: " + e.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            Optional<Status> statuses = statusService.findById(id);
            if (statuses.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(statuses.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Status not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch status: " + e.getMessage());
        }
    }

    @GetMapping("/save")
    public ResponseEntity<?> save(@RequestBody Status status){
        try {
            Status savedStatus = statusService.save(status);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedStatus);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save status: " + e.getMessage());
        }
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Status status){
        try {
            Status updatedStatus = statusService.updateById(id, status);
            return ResponseEntity.status(HttpStatus.OK).body(updatedStatus);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to updated status: " + e.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            statusService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Status deleted");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete status: " + e.getMessage());
        }
    }
}
