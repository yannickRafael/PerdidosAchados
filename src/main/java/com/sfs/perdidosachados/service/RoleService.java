package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.Role;
import com.sfs.perdidosachados.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> findById(int id) {
        return roleRepository.findById(id);
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }

    public Optional<Role> update(int id, Role role) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if (roleOptional.isPresent()) {
            Role roleToUpdate = roleOptional.get();
            BeanUtils.copyProperties(role, roleToUpdate, "id");
            roleRepository.save(roleToUpdate);
            return Optional.of(roleToUpdate);
        }
        return Optional.empty();
    }
}
