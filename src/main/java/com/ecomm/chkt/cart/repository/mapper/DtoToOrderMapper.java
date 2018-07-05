package com.ecomm.chkt.cart.repository.mapper;

import com.ecomm.chkt.cart.model.ItemDTO;
import com.ecomm.chkt.cart.model.OrderDTO;
import com.ecomm.chkt.cart.repository.domain.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoToOrderMapper {

    public List<Order> map(OrderDTO orderDTO){

        List<Order> orderLst = new ArrayList<Order>();
        for (ItemDTO item : orderDTO.getItemList()) {
            orderLst.add(new Order(orderDTO.getOrderId(), orderDTO.getStatus(), item.getItemId(), item.getItemName()));

        }
        return orderLst;
    }

}
