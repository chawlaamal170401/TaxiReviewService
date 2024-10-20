package org.amal.reviewservice.controller;


import jakarta.transaction.Transactional;
import org.amal.reviewservice.adapters.CreateReviewDtoToReviewAdapter;
import org.amal.reviewservice.dto.CreateReviewDTO;
import org.amal.reviewservice.dto.ReviewDTO;
import org.amal.reviewservice.models.Review;
import org.amal.reviewservice.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

  private ReviewService reviewService;
  private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

  public ReviewController(ReviewService reviewService, CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter){
    this.reviewService = reviewService;
    this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
  }

  @PostMapping
  @Transactional
  public ResponseEntity<?> createReview(@RequestBody CreateReviewDTO request){
    Review incomingReview = createReviewDtoToReviewAdapter.convertDTO(request);
    if(incomingReview == null){
      return new ResponseEntity<>("Invalid Request", HttpStatus.BAD_REQUEST);
    }
    Review review = reviewService.createReview(incomingReview);
    ReviewDTO response = ReviewDTO.builder()
                        .id(review.getId())
                        .content(review.getContent())
                        .rating(review.getRating())
                        .booking(review.getBooking().getId())
                        .createdAt(review.getCreatedAt())
                        .updatedAt(review.getUpdatedAt())
                        .build();
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }


  @GetMapping
  public ResponseEntity<List<Review>> getAllReviews(){
    List<Review> reviews = reviewService.getAllReviews();
    return new ResponseEntity<>(reviews, HttpStatus.OK);
  }

  @GetMapping("/{reviewId}")
  public ResponseEntity<?> getReviewById(@PathVariable Long reviewId){
    try{
      Optional<Review> review = reviewService.getReviewById(reviewId);
      return new ResponseEntity<>(review, HttpStatus.OK);
    }catch (Exception e){
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{reviewId}")
  public ResponseEntity<?> updateReview(@PathVariable Long reviewId, @RequestBody Review request){
    try {
      Review review = reviewService.updateReviewById(reviewId, request);
      return new ResponseEntity<>(review, HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{reviewId}")
  public ResponseEntity<?> deleteReview(@PathVariable Long reviewId){
    try {
      Boolean isDeleted = reviewService.deleteReviewById(reviewId);
      if(!isDeleted) return new ResponseEntity<>("Unable to Delete the requested Resource", HttpStatus.INTERNAL_SERVER_ERROR);
      return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
