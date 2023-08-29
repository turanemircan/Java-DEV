package com.tpe.controller;

import com.tpe.domain.OrderItem;
import com.tpe.dto.OrderDTO;
import com.tpe.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 10-OrderController Class
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 27-a-sipariş oluşturma ->http://localhost:8080/orders/save/filter?cid=1&prod=1&quant=3
    //farklı üründe yeni sipariş, aynı üründe sayı artırılır
    @PostMapping("/save/filter")
    public ResponseEntity<String> createOrderItem(@RequestParam("cid") Long customId,
                                                  @RequestParam("prod") Long prodId,
                                                  @RequestParam("quant") Integer quantity){

        if (quantity<=0){
            return new ResponseEntity<>("Quantity must be positive",HttpStatus.BAD_REQUEST);
        }

        orderService.createOrder(customId,prodId,quantity);

        return new ResponseEntity<>("Order Item is created successfully", HttpStatus.CREATED);//201
    }


    //28-a-tüm siparişleri getirme ->http://localhost:8080/orders
    @GetMapping()
    public ResponseEntity<List<OrderItem>> getAllOrders(){
        List<OrderItem> orderList=orderService.getAllOrders();
        return ResponseEntity.ok(orderList);//200:OK
    }

    //29-a-Id ile sipariş getirme ->http://localhost:8080/orders/5
    //29-b-DTO
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable("id") Long id){
        OrderDTO orderDTO=orderService.getOrderDTOById(id);
        return ResponseEntity.ok(orderDTO);
    }

    //30-a-Id ile sipariş miktarını update etme ->http://localhost:8080/orders/update/5/quantity/30 + PUT
    //quantity=0 ise siparişi sil, aksi halde miktarı güncelle
    @PutMapping("/update/{id}/quantity/{qua}")
    public ResponseEntity<String> updateQuantity(@PathVariable("id") Long id, @PathVariable("qua") Integer quantity){

        if (quantity<0){
            return new ResponseEntity<>("Quantity can not be negative",HttpStatus.BAD_REQUEST);
        }

        orderService.updateQuantity(id,quantity);

        return ResponseEntity.ok("Quantity is updated");//200
    }



    //31-a-Id ile sipariş delete etme ->http://localhost:8080/orders/delete?id=5
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOrder(@RequestParam("id") Long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok("Order is deleted successfully");//200
    }



    //ÖDEV:-tüm siparişleri page page gösterme-> http://localhost:8080/orders/page?page=1
    //        &size=&sort=id&direction=ASC






}
