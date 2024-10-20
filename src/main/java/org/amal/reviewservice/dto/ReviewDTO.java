package org.amal.reviewservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
  private Long id;
  private String content;
  private Long booking;
  private Double rating;
  private Date createdAt;
  private Date updatedAt;
}
