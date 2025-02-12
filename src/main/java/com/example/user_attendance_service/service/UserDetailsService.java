package com.example.user_attendance_service.service;

import com.example.user_attendance_service.model.UserDetails;
import com.example.user_attendance_service.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository repository;

    public List<UserDetails> findAll() {
        return repository.findAll();
    }

    public Optional<UserDetails> findById(Long id) {
        return repository.findById(id);
    }

    public UserDetails save(UserDetails user) {
        return repository.save(user);
    }

    public UserDetails updateUser(Long id, UserDetails updatedUser) {
        return repository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setEnabled(updatedUser.isEnabled());
            return repository.save(user);
        }).orElse(null);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public Optional<UserDetails> getUserByUsername(String username) {
        return repository.findByUsername(username);
    }
}
