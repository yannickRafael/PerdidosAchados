package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Item;
import com.sfs.perdidosachados.model.Item;
import com.sfs.perdidosachados.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping()
    public ResponseEntity<?> getall() {
        return ResponseEntity.status(HttpStatus.FOUND).body(itemService.findAll());
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> get(@RequestParam int id) {
        try {
            Optional<Item> item = itemService.findById(id);
            if (item.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(item.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Item item) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(item));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody Item item) {
        try {
            Optional<Item> updatedItem = itemService.update(id, item);
            if (updatedItem.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(updatedItem.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int id) {
        try {
            Optional<Item> item = itemService.findById(id);
            if (item.isPresent()) {
                itemService.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Item deleted successfully");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
