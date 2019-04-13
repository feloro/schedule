package com.feloro.database.repository;

import com.feloro.database.domain.WorkShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkShiftRepository extends JpaRepository <WorkShift, UUID> {
}
