package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Local;
import com.sfs.perdidosachados.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        try {
            List<Local> locals = localService.findAll();
            return ResponseEntity.status(HttpStatus.FOUND).body(locals);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch locals: " + e.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            Optional<Local> local = localService.findById(id);
            if (local.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(local.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Local not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch local: " + e.getMessage());
        }
    }

    @GetMapping("/save")
    public ResponseEntity<?> save(@RequestBody Local local){
        try {
            Local savedLocal = localService.save(local);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedLocal);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save local: " + e.getMessage());
        }
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Local local){
        try {
            Local updatedLocal = localService.updateById(id, local);
            return ResponseEntity.status(HttpStatus.OK).body(updatedLocal);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update local: " + e.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            localService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Local deleted");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete local: " + e.getMessage());
        }
    }
}
