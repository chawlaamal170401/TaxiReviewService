package org.amal.reviewservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateReviewDTO {

  private String content;
  private Double rating;
  private Long bookingId;
}
