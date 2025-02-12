package com.example.user_attendance_service.repository;

import com.example.user_attendance_service.model.UserLoginTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginTrackerRepository extends JpaRepository<UserLoginTracker, Long> {
}
