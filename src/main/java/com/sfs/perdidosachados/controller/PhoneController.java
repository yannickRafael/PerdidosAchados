package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Phone;
import com.sfs.perdidosachados.model.Phone;
import com.sfs.perdidosachados.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping()
    public ResponseEntity<?> getall() {
        return ResponseEntity.status(HttpStatus.FOUND).body(phoneService.findAll());
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> get(@RequestParam int id) {
        try {
            Optional<Phone> phone = phoneService.findById(id);
            if (phone.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(phone.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Phone not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Phone phone) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(phoneService.save(phone));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody Phone phone) {
        try {
            Optional<Phone> updatedPhone = phoneService.update(id, phone);
            if (updatedPhone.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(updatedPhone.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Phone not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int id) {
        try {
            Optional<Phone> phone = phoneService.findById(id);
            if (phone.isPresent()) {
                phoneService.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Phone deleted successfully");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Phone not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
