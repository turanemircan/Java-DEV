package com.tpe.dto;

import com.tpe.domain.Product;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Integer quantity;

    private Double totalPrice;

    private Product product;


}
