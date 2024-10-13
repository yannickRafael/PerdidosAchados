package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Image;
import com.sfs.perdidosachados.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
            Optional<Image> image = imageService.findById(id);
            if (image.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(image.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch image: " + e.getMessage());
        }
    }

    @GetMapping("/save")
    public ResponseEntity<?> save(@RequestBody Image image){
        try {
            Image savedImage = imageService.save(image);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedImage);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create image: " + e.getMessage());
        }
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Image image){
        try {
            Image updatedImage = imageService.updateById(id, image);
            return ResponseEntity.status(HttpStatus.OK).body(updatedImage);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update image: " + e.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            imageService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Image deleted:");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete image: " + e.getMessage());
        }
    }
}
