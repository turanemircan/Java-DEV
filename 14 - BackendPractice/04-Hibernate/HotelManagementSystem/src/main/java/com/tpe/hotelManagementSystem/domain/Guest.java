package com.tpe.hotelManagementSystem.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="t_guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id otomatik üretilecek
    private Long id;

    private String name;
    @Embedded
    private Address address;

    private LocalDateTime createDate;

    @PrePersist
   public void Prepersist(){
        createDate=LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

//    public void setCreateDate(LocalDateTime createDate) {
//        this.createDate = createDate;
//    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", createDate=" + createDate +
                '}';
    }
}
