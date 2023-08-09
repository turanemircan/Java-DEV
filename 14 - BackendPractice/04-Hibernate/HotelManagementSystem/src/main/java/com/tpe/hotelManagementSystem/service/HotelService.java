package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.domain.Hotel;

public interface HotelService {

    Hotel saveHotel();

    Hotel findHotelById(Long id);
}
