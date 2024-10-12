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

}
