package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.domain.Guest;

public interface GuestRepository {

    //Step 34a
    void saveGuest(Guest guest);

    //Step 50a create findGuestById
    Guest findGuestById(Long id);
}
