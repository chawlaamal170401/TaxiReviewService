package org.amal.reviewservice.repositories;

import org.amal.reviewservice.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

  Integer countAllByRatingIsLessThanEqual(Double rating);

  List<Review> findAllByRatingIsLessThanEqual(Double rating);

  List<Review> findAllByCreatedAtBefore(Date givenDate);

  @Query("select r from Booking b inner join Review r where b.id = :bookingId")
  Review findReviewByBookingId(Long bookingId);

}
