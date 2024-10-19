package org.amal.reviewservice.service;

import org.amal.reviewservice.models.*;
import org.amal.reviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {
  private final ReviewRepository reviewRepository;

  public ReviewService(ReviewRepository reviewRepository){
    this.reviewRepository = reviewRepository;
  }

  @Override
  public void run(String... args) {
    System.out.println("*************");
  }
}
