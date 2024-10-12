package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.model.User;
import com.sfs.perdidosachados.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User updateById(int id, User user) {
        return userRepository.updateById(id, user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
