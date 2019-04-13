package com.feloro.database.repository;

import com.feloro.database.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {

    public List<Schedule> findAllByUser_Id(UUID uesrId);
}
