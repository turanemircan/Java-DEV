package com.tpe.service;

import com.tpe.domain.Customer;
import com.tpe.domain.OrderItem;
import com.tpe.domain.Product;
import com.tpe.dto.OrderDTO;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//     11-OrderService Class
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerService customerService;

    private final ProductService productService;

    //27-b
    public void createOrder(Long customId, Long prodId, Integer quantity) {

        OrderItem orderItem=null;
        Customer customer =customerService.getCustomerById(customId);
        Product product =productService.getProductById(prodId);
        //daha önce bu ürün için sipariş oluşmuş mu
        boolean isSameProduct=orderRepository.existsByCustomerAndProduct(customer,product);
        if (isSameProduct){//aynı ürünse quantity artır

             orderItem=orderRepository.findByCustomerIdAndProductId(customId,prodId);
             orderItem.setQuantity(orderItem.getQuantity()+quantity);
        }else {//yeni ürün
            orderItem=new OrderItem();
            orderItem.setCustomer(customer);
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
        }
        //countTotalPrice();-->preUpdate , prePersist kullanıldığı için bu satıra gerek yok
        orderRepository.save(orderItem);

    }

    //28-b
    public List<OrderItem> getAllOrders() {
        return orderRepository.findAll();
    }

    //29-c
    public OrderItem getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order not found by id: "+id));
    }

    //29-d
    public OrderDTO getOrderDTOById(Long id) {
        OrderItem order=getOrderById(id);
        OrderDTO orderDTO=new OrderDTO(order.getQuantity(), order.getTotalPrice(),order.getProduct());
        return orderDTO;
    }

    //30-b
    public void updateQuantity(Long id, Integer quantity) {
          if (quantity==0){
              deleteOrderById(id);
          }else {
              OrderItem order=getOrderById(id);
              order.setQuantity(quantity);
              //order.countTotalPrice();-->PreUpdate
              orderRepository.save(order);//update
          }
    }


    //31-b
    public void deleteOrderById(Long id) {
        OrderItem order=getOrderById(id);
        orderRepository.delete(order);
    }




}
