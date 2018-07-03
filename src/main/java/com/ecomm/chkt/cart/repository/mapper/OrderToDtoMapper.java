package com.ecomm.chkt.cart.repository.mapper;

import com.ecomm.chkt.cart.model.ItemDTO;
import com.ecomm.chkt.cart.model.OrderDTO;
import com.ecomm.chkt.cart.repository.domain.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderToDtoMapper {

    public OrderDTO map(List<Order> ordrLst){
        int ordId = 0;
        OrderDTO orderDto = null;
        for (Order ordr : ordrLst) {
            ItemDTO item = new ItemDTO(ordr.getItemId(),ordr.getItemName());
            if (ordId != ordr.getOrderId()) {
                ordId = ordr.getOrderId();
                List<ItemDTO> itemLst = new ArrayList<ItemDTO>();
                itemLst.add(item);
                orderDto = new OrderDTO(ordr.getOrderId(), itemLst, ordr.getStatus());
            } else {
                orderDto.getItemList().add(item);
            }
        }
        return orderDto;
    }
}
