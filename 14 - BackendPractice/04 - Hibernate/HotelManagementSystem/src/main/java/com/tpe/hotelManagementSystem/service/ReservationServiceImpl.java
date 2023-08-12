package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.domain.Guest;
import com.tpe.hotelManagementSystem.domain.Reservation;
import com.tpe.hotelManagementSystem.domain.Room;
import com.tpe.hotelManagementSystem.exception.GuestNotFoundException;
import com.tpe.hotelManagementSystem.exception.RoomResourceNotFoundException;
import com.tpe.hotelManagementSystem.repository.GuestRepository;
import com.tpe.hotelManagementSystem.repository.ReservationRepository;
import com.tpe.hotelManagementSystem.repository.RoomRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class ReservationServiceImpl implements ReservationService{

    //Step 51a create scanner
    private static Scanner scanner;

    //Step 51b create constructor injection ResrevationRepository,GuestRepository,RoomRepository
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private  final RoomRepository roomRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, GuestRepository guestRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }

    //Step 51c write saveReservation codes
    @Override
    public Reservation saveReservation() {
        scanner=new Scanner(System.in);

        //guest e ait bilgileri al
        System.out.println("Enter your guest id : ");
        Long guestId = scanner.nextLong();
        scanner.nextLine();

        //room ile ilgili bilgiler
        System.out.println("Enter room id : ");
        Long roomId= scanner.nextLong();
        scanner.nextLine();

        //giriş çıkış tarihlerini alalım
        System.out.println("Enter chek-in date (yyyy-MM-dd)");
        LocalDate checkInDate= LocalDate.parse(scanner.nextLine());

        System.out.println("Enter check-out date (yyyy-MM-dd)");
        LocalDate checkOutDate=LocalDate.parse(scanner.nextLine());

            try {
                Guest existingGuest=guestRepository.findGuestById(guestId);
                if(existingGuest==null){
                    throw  new GuestNotFoundException("Guest not found with id :"+guestId);
                }
                Room existingRoom=roomRepository.findRoomById(roomId);
                if(existingRoom==null){
                    throw new RoomResourceNotFoundException("Room not found with id "+roomId);
                }
                Reservation reservation=new Reservation();
                reservation.setGuest(existingGuest);
                reservation.setRoom(existingRoom);
                reservation.setCheckinDate(checkInDate);
                reservation.setCheckOut(checkOutDate);

                reservationRepository.saveReservation(reservation);
                System.out.println("Reservation saved successfully...");
                return reservation;

            }catch(GuestNotFoundException | RoomResourceNotFoundException e){
                System.out.println(e.getMessage());
                return  null;
            }
    }
}
