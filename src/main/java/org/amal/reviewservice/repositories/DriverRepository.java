package org.amal.reviewservice.repositories;

import org.amal.reviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
