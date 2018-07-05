package com.ecomm.chkt.cart.repository;

import com.ecomm.chkt.cart.model.OrderDTO;
import com.ecomm.chkt.cart.repository.domain.Order;
import java.util.List;

public interface AddCartRepository {

    public int insert(OrderDTO orderDTO);
    public List<Order> viewAllCart(Integer orderId);
}
