package com.sfs.perdidosachados.controller;

import com.sfs.perdidosachados.model.Claim;
import com.sfs.perdidosachados.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/category")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        try {
            List<Claim> claims = claimService.findAll();
            return ResponseEntity.status(HttpStatus.FOUND).body(claims);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch claims: " + e.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            Optional<Claim> claim = claimService.findById(id);
            if (claim.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(claim.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Claim not found");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch Claim: " + e.getMessage());
        }
    }

    @GetMapping("/save")
    public ResponseEntity<?> save(@RequestBody Claim claim){
        try {
            Claim savedClaim = claimService.save(claim);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedClaim);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save Claim: " + e.getMessage());
        }
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Claim claim){
        try {
            Claim updatedClaim = claimService.updateById(id, claim);
            return ResponseEntity.status(HttpStatus.OK).body(updatedClaim);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update claim: " + e.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            claimService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Claim deleted");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete claim: " + e.getMessage());
        }
    }
}
