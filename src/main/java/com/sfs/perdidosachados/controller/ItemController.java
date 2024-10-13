package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Item;
import com.sfs.perdidosachados.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        try {
            List<Item> items = itemService.findAll();
            return ResponseEntity.status(HttpStatus.FOUND).body(items);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch items: " + e.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            Optional<Item> item = itemService.findById(id);
            if (item.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(item.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch item: " + e.getMessage());
        }
    }

    @GetMapping("/save")
    public ResponseEntity<?> save(@RequestBody Item item){
        try {
            Item itemSaved = itemService.save(item);
            return ResponseEntity.status(HttpStatus.CREATED).body(itemSaved);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create item: " + e.getMessage());
        }
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Item item){
        try {
            Item updatedItem = itemService.updateById(id, item);
            return ResponseEntity.status(HttpStatus.OK).body(updatedItem);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update item: " + e.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            itemService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Item deleted");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete item: " + e.getMessage());
        }
    }
}
