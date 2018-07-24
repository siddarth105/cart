package com.ecomm.chkt.cart.repository;

import com.ecomm.chkt.cart.model.OrderDTO;
import com.ecomm.chkt.cart.repository.domain.OrderInt;

import java.util.List;

public interface AddCartRepository {

    int insert(OrderDTO orderDTO, boolean isV2);
    List<? extends OrderInt> viewAllCart(Integer orderId, boolean isV2);
}
