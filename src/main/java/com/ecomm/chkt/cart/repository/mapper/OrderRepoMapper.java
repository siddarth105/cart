package com.ecomm.chkt.cart.repository.mapper;

import com.datastax.driver.core.Row;
import com.ecomm.chkt.cart.repository.domain.Order;
import com.ecomm.chkt.cart.repository.table.OrderTable;
import org.springframework.stereotype.Component;

@Component
public class OrderRepoMapper {

    public Order mapOrder(Row orderRow) {
        return new Order(orderRow.getInt(OrderTable.ORDER_ID), orderRow.getString(OrderTable.ORDER_STATUS), orderRow.getInt(OrderTable.ORDER_ITEM_ID), orderRow.getString(OrderTable.ORDER_ITEM_NAME));
    }
}
