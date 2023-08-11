package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.domain.Address;
import com.tpe.hotelManagementSystem.domain.Guest;
import com.tpe.hotelManagementSystem.repository.GuestRepository;

import java.util.Scanner;

public class GuestServiceImpl implements GuestService{
    private static Scanner scanner;
    private final GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public Guest saveGuest() {
        scanner=new Scanner(System.in);
        Guest guest=new Guest();
        //id otomatik generate edildiği için id sorulmadı
        System.out.println("Enter guest name : ");
        guest.setName(scanner.nextLine());

        Address address=new Address();

        System.out.println("Enter guest Street : ");
        address.setStreet(scanner.nextLine());

        System.out.println("Enter guest city : ");
        address.setCity(scanner.nextLine());

        System.out.println("Enter guest country : ");
        address.setCountry(scanner.nextLine());

        System.out.println("Enter guest zipCode : ");
        address.setZipCode(scanner.nextInt());

        guest.setAddress(address);

        guestRepository.saveGuest(guest);
        System.out.println("Guest saved successfully. Guest id : "+guest.getId());
        return guest;
    }
}
