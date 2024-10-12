package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.Local;
import com.sfs.perdidosachados.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
import java.util.List;
import java.util.Optional;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    public List<Local> findAll() {
        return localRepository.findAll();
    }

    public Optional<Local> findById(int id) {
        return localRepository.findById(id);
    }

    public Local save(Local local) {
        return localRepository.save(local);
    }

    public Local updateById(int id, Local local) {
        return localRepository.updateById(id, local);
    }

    public void deleteById(int id) {
        localRepository.deleteById(id);
    }

}
