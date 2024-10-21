package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Role;
import com.sfs.perdidosachados.model.Role;
import com.sfs.perdidosachados.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping()
    public ResponseEntity<?> getall() {
        return ResponseEntity.status(HttpStatus.FOUND).body(roleService.findAll());
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> get(@RequestParam int id) {
        try {
            Optional<Role> role = roleService.findById(id);
            if (role.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(role.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Role role) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(roleService.save(role));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody Role role) {
        try {
            Optional<Role> updatedRole = roleService.update(id, role);
            if (updatedRole.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(updatedRole.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int id) {
        try {
            Optional<Role> role = roleService.findById(id);
            if (role.isPresent()) {
                roleService.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Role deleted successfully");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
