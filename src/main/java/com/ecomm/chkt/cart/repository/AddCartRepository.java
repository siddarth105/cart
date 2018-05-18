package com.ecomm.chkt.cart.repository;

import com.ecomm.chkt.cart.model.OrderDTO;

public interface AddCartRepository {

    public int insert(OrderDTO orderDTO);
}
