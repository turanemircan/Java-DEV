package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.domain.Hotel;
import com.tpe.hotelManagementSystem.domain.Room;
import com.tpe.hotelManagementSystem.exception.HotelResourceNotFoundException;
import com.tpe.hotelManagementSystem.repository.HotelRepository;
import com.tpe.hotelManagementSystem.repository.RoomRepository;

import java.util.Scanner;

public class RoomServiceImpl implements RoomService {

    private static Scanner scanner;
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomServiceImpl(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Room saveRoom() {
        scanner = new Scanner(System.in);
        Room room = new Room();  //oda bilgilerini kaydetmek için boş bir oda objesi oluşturduk
        System.out.print("Enter room Id: ");//kaydedilecek oda bilgileri alındı
        room.setId(scanner.nextLong());
        scanner.nextLine();
        System.out.print("Enter room number: ");
        room.setNumber(scanner.nextLine());
        System.out.print("Enter room capacity: ");
        room.setCapacity(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Enter hotel id: "); //hangi hoteliin odası olacağı soruldu
        Long hotelId = scanner.nextLong();
        scanner.nextLine();

        try {
            Hotel existingHotel = hotelRepository.findHotelById(hotelId);
            if (existingHotel == null) { //id ye ait hotel varlığı kontrol edildi
                throw new HotelResourceNotFoundException("Hotel not found with id : " + hotelId);
            } else {
                room.setHotel(existingHotel);  //odaya ait hotel verildi
                Room savedRoom = roomRepository.saveRoom(room); //oda kaydedildi
                existingHotel.getRooms().add(savedRoom); //hotele ait oda listeleri eklendi
                System.out.println("Room saved successfully. Room id " + savedRoom.getId());
            }
        } catch (HotelResourceNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return room;
    }
}
