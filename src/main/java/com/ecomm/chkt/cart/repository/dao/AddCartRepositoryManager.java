package com.ecomm.chkt.cart.repository.dao;

import com.ecomm.chkt.cart.repository.domain.Order;

public interface AddCartRepositoryManager {

    public int insertOrder(Order order);
}
