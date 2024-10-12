package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.Phone;
import com.sfs.perdidosachados.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {
    
    @Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    public Optional<Phone> findById(int id) {
        return phoneRepository.findById(id);
    }

    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    public Phone updateById(int id, Phone phone) {
        return phoneRepository.updateById(id, phone);
    }

    public void deleteById(int id) {
        phoneRepository.deleteById(id);
    }
}
