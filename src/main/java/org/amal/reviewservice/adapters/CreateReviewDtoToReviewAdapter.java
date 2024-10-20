package org.amal.reviewservice.adapters;

import org.amal.reviewservice.dto.CreateReviewDTO;
import org.amal.reviewservice.models.Review;

public interface CreateReviewDtoToReviewAdapter {
  public Review convertDTO(CreateReviewDTO createReviewDTO);
}
