package com.tpe.hotelManagementSystem.service;

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
        return null;
    }
}
