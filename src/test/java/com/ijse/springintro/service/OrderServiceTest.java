package com.ijse.springintro.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import com.ijse.springintro.entity.Order;
import com.ijse.springintro.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    
    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderServiceImpl orderServiceImpl;

    @Test
    void createOrderShouldCreateOrder() {

        Order order = new Order();
        order.setId(1L);
        order.setTotalPrice(6000.0);
        Mockito.when(orderRepository.save(order)).thenReturn(order);

        Order createdOrder = orderServiceImpl.createOrder(order);
        Assertions.assertTrue(createdOrder.getId()==1L);
        Assertions.assertTrue(createdOrder.getTotalPrice()==order.getTotalPrice());
    
    }
 
    @Test
    void getAllOrdersShouldGetAllOrders() {

        Order order1 = new Order();
        order1.setId(1L);
        order1.setTotalPrice(5000.0);

        Order order2 = new Order();
        order2.setId(2L);
        order2.setTotalPrice(1000.0);

        List<Order> orders = Arrays.asList(order1,order2);
        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> orderedList = orderServiceImpl.getAllOrders();

        Assertions.assertEquals(orders, orderedList);
        Assertions.assertTrue(orderedList.get(0).getTotalPrice()==5000.0);
    }

}
