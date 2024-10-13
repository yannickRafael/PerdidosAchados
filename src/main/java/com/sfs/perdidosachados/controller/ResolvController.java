package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Resolv;
import com.sfs.perdidosachados.service.ResolvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class ResolvController {

    @Autowired
    private ResolvService resolvService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        try {
            List<Resolv> resolvs = resolvService.findAll();
            return ResponseEntity.status(HttpStatus.FOUND).body(resolvs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch resolvs: " + e.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            Optional<Resolv> resolv = resolvService.findById(id);
            if (resolv.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(resolv.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resolv not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch resolv: " + e.getMessage());
        }
    }

    @GetMapping("/save")
    public ResponseEntity<?> save(@RequestBody Resolv resolv){
        try {
            Resolv savedResolv = resolvService.save(resolv);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedResolv);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create resolv: " + e.getMessage());
        }
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Resolv resolv){
        try {
            Resolv updatedResolv = resolvService.updateById(id, resolv);
            return ResponseEntity.status(HttpStatus.OK).body(updatedResolv);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update resolv: " + e.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            resolvService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Resolv deleted");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete resolv: " + e.getMessage());
        }
    }
}
