package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Image;
import com.sfs.perdidosachados.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {


    @Autowired
    private ImageService imageService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        try {
            List<Image> images = imageService.findAll();
            return ResponseEntity.status(HttpStatus.FOUND).body(images);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch images: " + e.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            return ResponseEntity.ok("");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch **: " + e.getMessage());
        }
    }

    @GetMapping("/save")
    public ResponseEntity<?> save(@ResponseBody){
        try {
            return ResponseEntity.ok("");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch **: " + e.getMessage());
        }
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ){
        try {
            return ResponseEntity.ok("");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch **: " + e.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            return ResponseEntity.ok("");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch categorias: " + e.getMessage());
        }
    }
}
