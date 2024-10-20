package org.amal.reviewservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "bookingList"})
public class Passenger extends BaseModel{
  private String name;

  @OneToMany(mappedBy = "passenger")
  private List<Booking> bookingList = new ArrayList<>();

}
