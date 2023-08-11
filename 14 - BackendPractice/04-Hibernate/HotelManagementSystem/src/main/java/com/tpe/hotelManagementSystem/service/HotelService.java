package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.domain.Hotel;

import java.util.List;

public interface HotelService {

    Hotel saveHotel();

    Hotel findHotelById(Long id);

    void deleteHotelById(Long id);

    List<Hotel> findAllHotels();

    void updateHotel(Long id,Hotel updateHotel);
}
