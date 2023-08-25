package com.tpe.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//3-OrderItem Entity
@Entity
@Getter
@Setter
public class OrderItem {//many

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull(message = "Quantity is required!")
    private Integer quantity;

    @Setter(AccessLevel.NONE)
    private Double totalPrice;

    @ManyToOne//proje tasarımına göre bir sipariş kalemi sadece 1 ürün çeşidi için oluşturulur.
    @JoinColumn(nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore//bu fieldı JSON formatına dönüştürmeyi ignore et
    private Customer customer;//one

    //persit ve updateden önce bu metod çağrılarak totatlPrice set edilecek
    @PrePersist
    @PreUpdate
    public void countTotalPrice(){
        this.totalPrice=this.quantity*this.product.getPrice();
    }



}












