package com.tpe.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

//1-Customer Entity
@Entity
@Getter
@Setter
@AllArgsConstructor//param const
@NoArgsConstructor//default const
public class Customer {//one

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "Name is required!")
    @Size(min = 2,max = 50)
    private String name;

    @NotBlank(message = "LastName is required!")
    @Size(min = 2,max = 50)
    private String lastName;

    @NotBlank(message = "Email is required!")
    @Email//aaa@bbb.ccc
    @Column(unique = true)
    private String email;

    private String phone;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private Set<OrderItem> orders=new HashSet<>();//many



}
