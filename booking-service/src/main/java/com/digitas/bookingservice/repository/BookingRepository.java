package com.digitas.bookingservice.repository;

import com.digitas.bookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    @Query("FROM Booking b where b.id= ?1")
    Booking findByid(@Param("id") Long id);
}
