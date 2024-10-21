package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Claim;
import com.sfs.perdidosachados.model.Claim;
import com.sfs.perdidosachados.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/claim")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping()
    public ResponseEntity<?> getall() {
        return ResponseEntity.status(HttpStatus.FOUND).body(claimService.findAll());
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> get(@RequestParam int id) {
        try {
            Optional<Claim> claim = claimService.findById(id);
            if (claim.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(claim.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Claim not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Claim claim) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(claimService.save(claim));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody Claim claim) {
        try {
            Optional<Claim> updatedClaim = claimService.update(id, claim);
            if (updatedClaim.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(updatedClaim.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Claim not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int id) {
        try {
            Optional<Claim> claim = claimService.findById(id);
            if (claim.isPresent()) {
                claimService.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Claim deleted successfully");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Claim not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
