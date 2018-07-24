package com.ecomm.chkt.cart.repository.dao;

import com.ecomm.chkt.cart.repository.domain.OrderInt;

import java.util.List;

public interface AddCartRepositoryManager {

    int insertOrder(List<OrderInt> orderLst);
    List<OrderInt> viewAllCart(Integer orderId);
}
