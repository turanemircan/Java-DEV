package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.domain.Guest;

public interface GuestService {

    //Step 35e saveGuest
    Guest saveGuest();

    //Step 50d create findGuestById
    void findGustById(Long id);

}
