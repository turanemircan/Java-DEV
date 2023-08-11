package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.domain.Room;

import java.util.List;

public interface RoomRepository {

    Room saveRoom(Room room);
    Room findRoomById(Long roomId);

    List<Room> findAllRoom();

    void deleteRoomById(Long id);


}
