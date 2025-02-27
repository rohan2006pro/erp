package com.sgp.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgp.erp.model.Attendance;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    // Find attendance by date and student register number
    @Query("SELECT a FROM Attendance a WHERE a.student.registrationNumber = ?2 AND a.attendanceDate = ?1")
    List<Attendance> findAttendanceByDateAndRegistrationNumber(LocalDate date, String registrationNumber);

    // Find attendance within a date range for a student
    @Query("SELECT a FROM Attendance a WHERE a.student.registrationNumber = ?1 AND a.attendanceDate BETWEEN ?2 AND ?3")
    List<Attendance> findAttendanceByRegistrationNumberAndDateRange(String registrationNumber, LocalDate startDate,
            LocalDate endDate);
}
