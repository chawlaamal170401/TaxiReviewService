package org.amal.reviewservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking_review")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{

  private String content;

  private Double rating;

  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  private Booking booking;

  @Override
  public String toString() {
    return "Review: " + this.content + " " + this.rating + " " + " booking:  " + this.createdAt;
  }

}
