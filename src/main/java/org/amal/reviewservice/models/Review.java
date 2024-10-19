package org.amal.reviewservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
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

  private String content;

  private Double rating;

  @OneToOne(cascade = {CascadeType.ALL})
  private Booking booking;

  @Override
  public String toString() {
    return "Review: " + this.content + " " + this.rating + " " + " booking: " + this.booking.getId() + " " + this.createdAt;
  }

}
