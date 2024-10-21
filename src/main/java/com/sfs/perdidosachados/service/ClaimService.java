package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.Claim;
import com.sfs.perdidosachados.repository.ClaimRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    public List<Claim> findAll() {
        return claimRepository.findAll();
    }

    public Optional<Claim> findById(int id) {
        return claimRepository.findById(id);
    }

    public Claim save(Claim claim) {
        return claimRepository.save(claim);
    }

    public void deleteById(int id) {
        claimRepository.deleteById(id);
    }

    public Optional<Claim> update(int id, Claim claim) {
        Optional<Claim> claimOptional = claimRepository.findById(id);
        if (claimOptional.isPresent()) {
            Claim claimToUpdate = claimOptional.get();
            BeanUtils.copyProperties(claim, claimToUpdate, "id");
            claimRepository.save(claimToUpdate);
            return Optional.of(claimToUpdate);
        }
        return Optional.empty();
    }
}
