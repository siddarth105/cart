package com.ecomm.chkt.cart.repository.mapper;

import com.ecomm.chkt.cart.model.ItemDTO;
import com.ecomm.chkt.cart.model.OrderDTO;
import com.ecomm.chkt.cart.repository.domain.Order;
import com.ecomm.chkt.cart.repository.domain.OrderInt;
import com.ecomm.chkt.cart.repository.domain.OrderV2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoToOrderMapper {

    public List<OrderInt> map(OrderDTO orderDTO, boolean isV2){

        List<OrderInt> orderLst = new ArrayList<>();
        if (!isV2) {
            for (ItemDTO item : orderDTO.getItemList()) {
                orderLst.add(new Order(orderDTO.getOrderId(), orderDTO.getStatus(), item.getItemId(), item.getItemName()));

            }
        } else {
            for (ItemDTO item : orderDTO.getItemList()) {
                orderLst.add(new OrderV2(orderDTO.getOrderId(), orderDTO.getStatus(), item.getItemId(), item.getItemName()));

            }
        }
        return orderLst;
    }
}
