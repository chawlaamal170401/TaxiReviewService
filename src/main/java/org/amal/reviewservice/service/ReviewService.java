package org.amal.reviewservice.service;

import org.amal.reviewservice.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
  List<Review> getAllReviews();

  Optional<Review> getReviewById(Long reviewId);

  Boolean deleteReviewById(Long reviewId);

  Review updateReviewById(Long reviewId, Review review);

  Review createReview(Review review);
}
