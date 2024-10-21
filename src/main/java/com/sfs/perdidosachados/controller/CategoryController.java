package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Category;
import com.sfs.perdidosachados.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getall() {
        return ResponseEntity.status(HttpStatus.FOUND).body(categoryService.findAll());
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> get(@RequestParam int id) {
        try {
            Optional<Category> category = categoryService.findById(id);
            if (category.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(category.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Category category) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody Category category) {
        try {
            Optional<Category> updatedCategory = categoryService.update(id, category);
            if (updatedCategory.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(updatedCategory.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int id) {
        try {
            Optional<Category> category = categoryService.findById(id);
            if (category.isPresent()) {
                categoryService.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Category deleted successfully");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
