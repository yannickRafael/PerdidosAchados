package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.Phone;
import com.sfs.perdidosachados.repository.PhoneRepository;
import org.springframework.beans.BeanUtils;
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

    public void deleteById(int id) {
        phoneRepository.deleteById(id);
    }

    public Optional<Phone> update(int id, Phone phone) {
        Optional<Phone> phoneOptional = phoneRepository.findById(id);
        if (phoneOptional.isPresent()) {
            Phone phoneToUpdate = phoneOptional.get();
            BeanUtils.copyProperties(phone, phoneToUpdate, "id");
            phoneRepository.save(phoneToUpdate);
            return Optional.of(phoneToUpdate);
        }
        return Optional.empty();
    }
}
