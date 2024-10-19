package org.amal.reviewservice.service;

import org.amal.reviewservice.models.Review;
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
    Review r = Review.builder()
              .comment("Amazing Ride")
              .rating(4.0)
              .build();

    reviewRepository.save(r);

  }
}
