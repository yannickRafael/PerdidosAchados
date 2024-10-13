package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.User;
import com.sfs.perdidosachados.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        try {
            List<User> users = userService.findAll();
            return ResponseEntity.status(HttpStatus.FOUND).body(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch users: " + e.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            Optional<User> user = userService.findById(id);
            if (user.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(user.get());
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch user: " + e.getMessage());
        }
    }

    @GetMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user){
        try {
            User savedUser = userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save user: " + e.getMessage());
        }
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody User user){
        try {
            User updatedUser = userService.updateById(id, user);
            return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user: " + e.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User deleted");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user: " + e.getMessage());
        }
    }
}
