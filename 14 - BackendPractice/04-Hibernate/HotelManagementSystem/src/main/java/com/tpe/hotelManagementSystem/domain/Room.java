package com.tpe.hotelManagementSystem.domain;

import javax.persistence.*;

@Entity
@Table(name="t_rooms")
public class Room {

    //Step 18a add fields
    @Id
    private Long id;
    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private int capacity;

    //Step 19a
    @ManyToOne
    @JoinColumn(name="hotel_id",nullable = false)
    private Hotel hotel;

    //Step 19b constructor
    public Room() {
    }

    public Room(Long id, String number, int capacity, Hotel hotel) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.hotel = hotel;
    }

    //Step 19c getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    //Step 19d toString
    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", capacity=" + capacity +
//                ", hotel=" + hotel +
                '}';
    }
}
