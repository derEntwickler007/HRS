package com.ujwal.HRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujwal.HRS.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
