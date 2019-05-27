package com.feloro.database.repository;

import com.feloro.database.domain.Attendance;
import com.feloro.database.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, UUID> {

    public List<Attendance> findAllByUserAndDate(User user, Date date);
}
