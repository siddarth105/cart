package com.ecomm.chkt.cart.repository.mapper;

import com.ecomm.chkt.cart.model.OrderDTO;
import org.springframework.stereotype.Component;
import com.ecomm.chkt.cart.repository.domain.Order;

@Component
public class DtoToOrderMapper {

    public Order map(OrderDTO orderDTO){
        return new Order(orderDTO.getOrderId(), orderDTO.getStatus(), orderDTO.getItemList().get(0).getItemId(), orderDTO.getItemList().get(0).getItemName());
    }

}
