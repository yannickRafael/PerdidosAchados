package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Phone;
import com.sfs.perdidosachados.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        try {
            List<Phone> phones = phoneService.findAll();
            return ResponseEntity.status(HttpStatus.FOUND).body(phones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch phones: " + e.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            Optional<Phone> phone = phoneService.findById(id);
            if(phone.isPresent()){
                return ResponseEntity.status(HttpStatus.FOUND).body(phone.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Phone not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch phone: " + e.getMessage());
        }
    }

    @GetMapping("/save")
    public ResponseEntity<?> save(@RequestBody Phone phone){
        try {
            Phone savedPhone = phoneService.save(phone);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPhone);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create phone: " + e.getMessage());
        }
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Phone phone){
        try {
            Phone updatedPhone = phoneService.updateById(id, phone);
            return ResponseEntity.status(HttpStatus.OK).body(updatedPhone);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update phone: " + e.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            phoneService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Phone deleted");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete phone: " + e.getMessage());
        }
    }
}
