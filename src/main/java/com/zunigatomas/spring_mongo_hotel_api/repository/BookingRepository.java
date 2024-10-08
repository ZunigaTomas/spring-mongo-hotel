package com.zunigatomas.spring_mongo_hotel_api.repository;

import com.zunigatomas.spring_mongo_hotel_api.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends MongoRepository<Booking,String> {
    Optional<Booking> findByBookingConfirmationCode(String confirmationCode);
    @Query(" {'checkInDate':  { $lte: ?1 }, 'checkOutDate': { $gte: ?0 }} ")
    List<Booking> findBookingsByDateRange(LocalDate checkInDate, LocalDate checkOutDate);
}
