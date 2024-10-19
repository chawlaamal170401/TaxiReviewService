package org.amal.reviewservice.service;

import org.amal.reviewservice.models.*;
import org.amal.reviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {
  private ReviewRepository reviewRepository;

  public ReviewService(ReviewRepository reviewRepository){
    this.reviewRepository = reviewRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("*************");

    Booking b = Booking.builder()
                .bookingStatus(BookingStatus.CAB_ARRIVED)
                .totalDistance(13L)
                .build();

    Review r = Review.builder()
              .content("Amazing Ride")
              .rating(5.0)
              .booking(b)
              .build();

    reviewRepository.save(r);

  }
}
