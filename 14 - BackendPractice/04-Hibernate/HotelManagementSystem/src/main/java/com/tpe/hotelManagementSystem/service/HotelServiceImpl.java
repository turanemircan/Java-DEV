package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.domain.Hotel;
import com.tpe.hotelManagementSystem.exception.HotelResourceNotFoundException;
import com.tpe.hotelManagementSystem.repository.HotelRepository;
import com.tpe.hotelManagementSystem.repository.HotelRepositoryImpl;

import java.util.Scanner;

public class HotelServiceImpl implements HotelService{

    private static Scanner scanner;

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    //HotelRepository hotelRepository=new HotelRepositoryImpl();

    @Override
    public Hotel saveHotel() {
        scanner=new Scanner(System.in);
        Hotel hotel=new Hotel();

        System.out.print("Enter hotel Id: ");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();//Consume the newline character
        System.out.print("Enter hotel name: ");
        hotel.setName(scanner.nextLine());
        System.out.print("Enter hotel location: ");
        hotel.setLocation(scanner.nextLine());

        hotelRepository.saveHotel(hotel);
        System.out.println("Hotel saved successfully. Hotel ID : "+hotel.getId());

        return hotel;
    }

    @Override
    public Hotel findHotelById(Long id) {
        try {
            Hotel foundHotel=hotelRepository.findHotelById(id);
            if(foundHotel!=null){
                System.out.println("----------------------------------");
                System.out.println(foundHotel);
                return foundHotel;
            }else {
                throw new HotelResourceNotFoundException("Hotel not found with id : "+id);
            }
        }catch (HotelResourceNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
