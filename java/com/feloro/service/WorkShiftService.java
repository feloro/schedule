package com.feloro.service;

import com.feloro.database.domain.WorkShift;
import com.feloro.database.repository.WorkShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkShiftService {

    @Autowired
    WorkShiftRepository workShiftRepository;

    public List<WorkShift> getWokShifts() {
        return workShiftRepository.findAll();
    }

    public WorkShift creteWokShifts(WorkShift workShift) {
        return workShiftRepository.save(workShift);
    }

    public WorkShift getWorkShift(UUID workShiftId) {
        return workShiftRepository.findById(workShiftId).orElse(null);
    }

    public void deleteWorkShift(UUID workShiftId) {
        workShiftRepository.deleteById(workShiftId);
    }
}
