package com.travel.travelwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.travel.travelwebsite.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
