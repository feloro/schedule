package com.feloro.controller;

import com.feloro.database.domain.WorkShift;
import com.feloro.service.WorkShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class WorkShiftController {

    @Autowired
    WorkShiftService workShiftService;

    @GetMapping("/workshift")
    public List<WorkShift> getWorkShifts() {
        return workShiftService.getWokShifts();
    }

    @PostMapping("/workshift")
    public WorkShift getWorkShifts(@RequestBody WorkShift workShift) {
        return workShiftService.creteWokShifts(workShift);
    }

    @DeleteMapping("/workshift")
    public void deleteWorkShift(@RequestParam UUID workShiftId) {
        workShiftService.deleteWorkShift(workShiftId);
    }
}
