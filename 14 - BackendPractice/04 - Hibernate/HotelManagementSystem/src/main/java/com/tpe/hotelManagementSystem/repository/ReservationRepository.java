package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.domain.Reservation;

public interface ReservationRepository {

    //Step 49a create saveReservation
    Reservation saveReservation(Reservation reservation);
}
