package org.amal.reviewservice.service;

import jakarta.persistence.EntityNotFoundException;
import org.amal.reviewservice.models.Review;
import org.amal.reviewservice.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

  private ReviewRepository reviewRepository;

  public ReviewServiceImpl(ReviewRepository reviewRepository){
    this.reviewRepository = reviewRepository;
  }

  @Override
  public List<Review> getAllReviews() {
    return reviewRepository.findAll();
  }

  @Override
  public Optional<Review> getReviewById(Long reviewId) throws EntityNotFoundException{
    Optional<Review> review = Optional.empty();
    try{
      review = reviewRepository.findById(reviewId);
      if(review.isEmpty()){
        throw new EntityNotFoundException("Review with id: " + reviewId + " not found");
      }
    } catch (Exception e){
      e.printStackTrace();
      System.out.println("Some Problem Detected" + e.getMessage());
    }
    return review;
  }

  @Override
  public Boolean deleteReviewById(Long reviewId) {
    try{
      Review review = reviewRepository.findById(reviewId).orElseThrow(EntityNotFoundException::new);
      reviewRepository.delete(review);
      return true;
    } catch (Exception e){
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public Review updateReviewById(Long reviewId, Review newReviewData) {
    Review review = null;
    try{
      review = reviewRepository.findById(reviewId).orElseThrow(EntityNotFoundException::new);
      if(review.getRating() != null){
        review.setRating(newReviewData.getRating());
      }
      if(review.getContent() != null){
        review.setContent(newReviewData.getContent());
      }
      reviewRepository.save(review);
    } catch (Exception e){
      e.printStackTrace();
    }
    return review;
  }

  @Override
  public Review createReview(Review review) {
    return reviewRepository.save(review);
  }
}
