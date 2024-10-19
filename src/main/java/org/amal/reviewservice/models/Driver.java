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
public class Driver extends BaseModel {
  private String name;

  @Column(nullable = false, unique = true)
  private String licenseNumber;

  @OneToMany(mappedBy = "driver")
  private List<Booking> bookingList = new ArrayList<>();

}
