package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.Resolv;
import com.sfs.perdidosachados.repository.ResolvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResolvService {
    
    @Autowired
    private ResolvRepository resolvRepository;

    public List<Resolv> findAll() {
        return resolvRepository.findAll();
    }

    public Optional<Resolv> findById(int id) {
        return resolvRepository.findById(id);
    }

    public Resolv save(Resolv resolv) {
        return resolvRepository.save(resolv);
    }

    public Resolv updateById(int id, Resolv resolv) {
        return resolvRepository.updateById(id, resolv);
    }

    public void deleteById(int id) {
        resolvRepository.deleteById(id);
    }
}
