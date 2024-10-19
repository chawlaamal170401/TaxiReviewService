package org.amal.reviewservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking_review")
public class Review extends BaseModel{

  private String comment;

  private Double rating;

}
