package org.amal.reviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends BaseModel{
  private String name;

  @OneToMany(mappedBy = "passenger")
  private List<Booking> bookingList = new ArrayList<>();

}
