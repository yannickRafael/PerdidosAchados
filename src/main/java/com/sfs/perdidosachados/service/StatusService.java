package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.Status;
import com.sfs.perdidosachados.repository.StatusRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    public Optional<Status> findById(int id) {
        return statusRepository.findById(id);
    }

    public Status save(Status status) {
        return statusRepository.save(status);
    }

    public void deleteById(int id) {
        statusRepository.deleteById(id);
    }

    public Optional<Status> update(int id, Status status) {
        Optional<Status> statusOptional = statusRepository.findById(id);
        if (statusOptional.isPresent()) {
            Status statusToUpdate = statusOptional.get();
            BeanUtils.copyProperties(status, statusToUpdate, "id");
            statusRepository.save(statusToUpdate);
            return Optional.of(statusToUpdate);
        }
        return Optional.empty();
    }
}
