package org.amal.reviewservice.adapters;

import org.amal.reviewservice.dto.CreateReviewDTO;
import org.amal.reviewservice.models.Booking;
import org.amal.reviewservice.models.Review;
import org.amal.reviewservice.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter{

  private BookingRepository bookingRepository;

   public CreateReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository){
     this.bookingRepository = bookingRepository;
   }

  @Override
  public Review convertDTO(CreateReviewDTO createReviewDTO) {
    Optional<Booking> booking = bookingRepository.findById(createReviewDTO.getBookingId());
    System.out.println(booking);
    return booking.map(value -> Review.builder()
        .rating(createReviewDTO.getRating())
        .booking(value)
        .content(createReviewDTO.getContent())
        .build()).orElse(null);
  }
}
