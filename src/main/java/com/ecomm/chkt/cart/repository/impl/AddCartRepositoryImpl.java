package com.ecomm.chkt.cart.repository.impl;

import com.ecomm.chkt.cart.model.OrderDTO;
import com.ecomm.chkt.cart.repository.AddCartRepository;
import com.ecomm.chkt.cart.repository.dao.AddCartRepositoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ecomm.chkt.cart.repository.domain.Order;
import com.ecomm.chkt.cart.repository.mapper.DtoToOrderMapper;
import java.util.List;

@Repository
public class AddCartRepositoryImpl implements AddCartRepository {

    @Autowired
    private AddCartRepositoryManager addCartRepositoryManager;

    @Autowired
    private DtoToOrderMapper dtoToOrderMapper;

    public int insert(OrderDTO orderDTO) {
        Order order = dtoToOrderMapper.map(orderDTO);
        return addCartRepositoryManager.insertOrder(order);
    }

    public List<Order> viewAllCart() {
        return addCartRepositoryManager.viewAllCart();
    }

}
