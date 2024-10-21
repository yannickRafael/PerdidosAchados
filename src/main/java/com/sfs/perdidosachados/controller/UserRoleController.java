package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.UserRole;
import com.sfs.perdidosachados.model.UserRole;
import com.sfs.perdidosachados.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping()
    public ResponseEntity<?> getall() {
        return ResponseEntity.status(HttpStatus.FOUND).body(userRoleService.findAll());
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> get(@RequestParam int id) {
        try {
            Optional<UserRole> userRole = userRoleService.findById(id);
            if (userRole.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(userRole.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserRole not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody UserRole userRole) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userRoleService.save(userRole));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody UserRole userRole) {
        try {
            Optional<UserRole> updatedUserRole = userRoleService.update(id, userRole);
            if (updatedUserRole.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(updatedUserRole.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserRole not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int id) {
        try {
            Optional<UserRole> userRole = userRoleService.findById(id);
            if (userRole.isPresent()) {
                userRoleService.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("UserRole deleted successfully");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserRole not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
