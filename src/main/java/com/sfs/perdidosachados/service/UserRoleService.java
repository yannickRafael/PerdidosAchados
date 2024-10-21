package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.UserRole;
import com.sfs.perdidosachados.repository.UserRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    public Optional<UserRole> findById(int id) {
        return userRoleRepository.findById(id);
    }

    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    public void deleteById(int id) {
        userRoleRepository.deleteById(id);
    }

    public Optional<UserRole> update(int id, UserRole userRole) {
        Optional<UserRole> userRoleOptional = userRoleRepository.findById(id);
        if (userRoleOptional.isPresent()) {
            UserRole userRoleToUpdate = userRoleOptional.get();
            BeanUtils.copyProperties(userRole, userRoleToUpdate, "id");
            userRoleRepository.save(userRoleToUpdate);
            return Optional.of(userRoleToUpdate);
        }
        return Optional.empty();
    }
}
