package com.example.user_attendance_service.service;

import com.example.user_attendance_service.model.UserLoginTracker;
import com.example.user_attendance_service.repository.UserLoginTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserLoginTrackerService {
    @Autowired
    private UserLoginTrackerRepository repository;

    public List<UserLoginTracker> findAll() {
        return repository.findAll();
    }

    public Optional<UserLoginTracker> findById(Long id) {
        return repository.findById(id);
    }

    public UserLoginTracker save(UserLoginTracker tracker) {
        tracker.setLoginDate(new Date());
        tracker.setLoginTime(LocalTime.ofInstant(Instant.ofEpochMilli(new Date().getTime()), ZoneId.systemDefault()));
        return repository.save(tracker);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
