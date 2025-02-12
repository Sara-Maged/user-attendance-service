package com.example.user_attendance_service.controller;

import com.example.user_attendance_service.model.UserLoginTracker;
import com.example.user_attendance_service.service.UserLoginTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login-tracker")
public class UserLoginTrackerController {
    @Autowired
    private UserLoginTrackerService service;

    @GetMapping
    public List<UserLoginTracker> getAllTrackers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserLoginTracker> getTrackerById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserLoginTracker createTracker(@RequestBody UserLoginTracker tracker) {
        return service.save(tracker);
    }

    @DeleteMapping("/{id}")
    public void deleteTracker(@PathVariable Long id) {
        service.delete(id);
    }
}
