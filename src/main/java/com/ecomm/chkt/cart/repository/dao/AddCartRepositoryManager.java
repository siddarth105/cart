package com.ecomm.chkt.cart.repository.dao;

import com.ecomm.chkt.cart.repository.domain.Order;

import java.util.List;

public interface AddCartRepositoryManager {

    public int insertOrder(Order order);
    public List<Order> viewAllCart();
}
