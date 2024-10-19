package org.amal.reviewservice.repositories;

import org.amal.reviewservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
